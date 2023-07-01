package com.infamous.infamous_legends.ai.brains.behaviours;

import com.google.common.collect.ImmutableMap;
import com.infamous.infamous_legends.InfamousLegends;
import com.infamous.infamous_legends.entities.PiglinBuilder;
import com.infamous.infamous_legends.init.MemoryModuleTypeInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.WalkTarget;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class PiglinBuilderBuilding extends Behavior<PiglinBuilder> {
    private static final String[] STRUCTURE_LOCATION_PORTALS = new String[]{"ruined_portal/portal_1", "ruined_portal/portal_2", "ruined_portal/portal_3", "ruined_portal/portal_4", "ruined_portal/portal_5", "ruined_portal/portal_6", "ruined_portal/portal_7", "ruined_portal/portal_8", "ruined_portal/portal_9", "ruined_portal/portal_10"};
    private static final Logger LOGGER = Logger.getLogger(InfamousLegends.MOD_ID);
    private final float speedMultiplier;
    private boolean workOver = false;
    private BlockPos minPos;
    private BlockPos maxPos;
    private BlockPos currentBlockPos;
    private StructureTemplate template;
    private StructurePlaceSettings templateSettings;
    private BlockState blockState;
    private Rotation rotation;

    private int step;
    private int tick = 3;

    public PiglinBuilderBuilding(float p_275357_) {
        super(ImmutableMap.of(MemoryModuleTypeInit.WORK_POS.get(), MemoryStatus.VALUE_PRESENT), 2400);
        this.speedMultiplier = p_275357_;
    }


    protected boolean canStillUse(ServerLevel level, PiglinBuilder piglinBuilder, long p_147393_) {
        return !workOver && ForgeEventFactory.getMobGriefingEvent(level, piglinBuilder);
    }

    protected void start(ServerLevel level, PiglinBuilder piglinBuilder, long p_147401_) {
        this.workOver = false;
        Brain<?> brain = piglinBuilder.getBrain();
        GlobalPos globalPos = brain.getMemory(MemoryModuleTypeInit.WORK_POS.get()).get();
        int i = piglinBuilder.getRandom().nextInt(STRUCTURE_LOCATION_PORTALS.length);
        StructureTemplateManager structuretemplatemanager = level.getLevel().getServer().getStructureManager();
        StructureTemplate structuretemplate = structuretemplatemanager.getOrCreate(ResourceLocation.tryParse(STRUCTURE_LOCATION_PORTALS[i]));

        this.template = structuretemplate;
        Rotation rotation = Rotation.getRandom(piglinBuilder.getRandom());
        ChunkPos chunkpos = new ChunkPos(globalPos.pos());
        BoundingBox boundingbox = new BoundingBox(chunkpos.getMinBlockX() - 16, level.getMinBuildHeight(), chunkpos.getMinBlockZ() - 16, chunkpos.getMaxBlockX() + 16, level.getMaxBuildHeight(), chunkpos.getMaxBlockZ() + 16);
        StructurePlaceSettings structureplacesettings = (new StructurePlaceSettings()).setRotation(rotation).setBoundingBox(boundingbox).setRandom(piglinBuilder.getRandom());
        Vec3i vec3i = structuretemplate.getSize(rotation);
        this.templateSettings = structureplacesettings;

        BlockPos blockpos1 = new BlockPos(-vec3i.getX() / 2, 0, -vec3i.getZ() / 2);
        BlockPos blockpos2 = new BlockPos(vec3i.getX() / 2, vec3i.getY(), vec3i.getZ() / 2);

        this.minPos = blockpos1;
        this.maxPos = blockpos2;
        this.rotation = rotation;
    }

    protected void stop(ServerLevel p_217118_, PiglinBuilder p_217119_, long p_217120_) {
        Brain<?> brain = p_217119_.getBrain();
        brain.eraseMemory(MemoryModuleTypeInit.WORK_POS.get());
    }

    protected void tick(ServerLevel level, PiglinBuilder mob, long p_147405_) {
        Brain<?> brain = mob.getBrain();
        Optional<GlobalPos> globalPos = brain.getMemory(MemoryModuleTypeInit.WORK_POS.get());

        if (--this.tick < 0) {
            if (globalPos.isPresent()) {
                BlockPos blockpos1 = globalPos.get().pos().offset(-maxPos.getX(), 0, -maxPos.getZ());

                BlockPos blockpos2 = template.getZeroPositionWithTransform(blockpos1, Mirror.NONE, this.rotation);

                List<StructureTemplate.StructureBlockInfo> list = templateSettings.getRandomPalette(template.palettes, blockpos2).blocks();
                if (step > list.size() - 1) {
                    workOver = true;
                }

                StructureTemplate.StructureBlockInfo structureBlockInfo = list.get(step);
                BlockPos origin = globalPos.get().pos().offset(structureBlockInfo.pos);
                if (isReplaceable(level.getBlockState(origin), level, mob)) {
                    blockState = structureBlockInfo.state;
                    currentBlockPos = origin;
                    step += 1;
                } else {
                    step += 1;
                }

                if (currentBlockPos != null) {
                    if (mob.getNavigation().isDone()) {
                        brain.setMemory(MemoryModuleType.WALK_TARGET, new WalkTarget(globalPos.get().pos(), this.speedMultiplier, 16));
                    }


                    if (globalPos.get().pos().distSqr(mob.blockPosition()) < 32F) {
                        if (isReplaceable(level.getBlockState(currentBlockPos), level, mob)) {
                            if (!level.getBlockState(currentBlockPos).isAir() && level.getFluidState(currentBlockPos).isEmpty()) {
                                level.levelEvent(2001, currentBlockPos, Block.getId(level.getBlockState(currentBlockPos)));

                            }
                            BlockState realState = blockState.mirror(templateSettings.getMirror()).rotate(templateSettings.getRotation());

                            Block.pushEntitiesUp(level.getBlockState(currentBlockPos), realState, level, currentBlockPos);
                            level.setBlock(currentBlockPos, realState, 3);
                        } else {
                            currentBlockPos = null;
                        }
                    }
                }
            }
            this.tick = 3;
        }
    }


    private boolean isReplaceable(BlockState blockState, ServerLevel level, PiglinBuilder mob) {
        return !blockState.is(BlockTags.FEATURES_CANNOT_REPLACE) && ForgeEventFactory.getMobGriefingEvent(level, mob);
    }

    @Override
    protected boolean timedOut(long pGameTime) {
        return false;
    }
}
