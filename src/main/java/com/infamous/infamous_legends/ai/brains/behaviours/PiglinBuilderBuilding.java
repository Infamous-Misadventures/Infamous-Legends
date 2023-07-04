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
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate.processBlockInfos;

public class PiglinBuilderBuilding extends Behavior<PiglinBuilder> {
    private static final String[] STRUCTURE_LOCATION_PORTALS = new String[]{"ruined_portal/portal_1", "ruined_portal/portal_2", "ruined_portal/portal_3", "ruined_portal/portal_4", "ruined_portal/portal_5", "ruined_portal/portal_6", "ruined_portal/portal_7", "ruined_portal/portal_8", "ruined_portal/portal_9", "ruined_portal/portal_10"};
    private static final Logger LOGGER = Logger.getLogger(InfamousLegends.MOD_ID);
    private final float speedMultiplier;
    private boolean workOver = false;
    private BlockPos maxPos;
    private BlockPos currentBlockPos;
    private StructureTemplate template;
    private StructurePlaceSettings templateSettings;
    private BlockState blockState;
    private Rotation rotation;

    private int step;
    private int tick = 3;

    public PiglinBuilderBuilding(float p_275357_) {
        super(ImmutableMap.of(), 2400);
        this.speedMultiplier = p_275357_;
    }


    @Override
    protected boolean checkExtraStartConditions(ServerLevel pLevel, PiglinBuilder pOwner) {
        Brain<?> brain = pOwner.getBrain();
        return pOwner.getTarget() == null && brain.getMemory(MemoryModuleTypeInit.WORK_POS.get()).isPresent();
    }

    protected boolean canStillUse(ServerLevel level, PiglinBuilder piglinBuilder, long p_147393_) {
        return piglinBuilder.getTarget() == null && !workOver && ForgeEventFactory.getMobGriefingEvent(level, piglinBuilder);
    }

    protected void start(ServerLevel level, PiglinBuilder piglinBuilder, long p_147401_) {
        this.workOver = false;
        Brain<?> brain = piglinBuilder.getBrain();
        GlobalPos globalPos = brain.getMemory(MemoryModuleTypeInit.WORK_POS.get()).get();
        int i = piglinBuilder.getRandom().nextInt(STRUCTURE_LOCATION_PORTALS.length);
        StructureTemplateManager structuretemplatemanager = level.getLevel().getServer().getStructureManager();

        ResourceLocation resourceLocation = ResourceLocation.tryParse(STRUCTURE_LOCATION_PORTALS[i]);


        if (piglinBuilder.getBuildingStructureName() != null) {
            resourceLocation = piglinBuilder.getBuildingStructureName();
            this.step = piglinBuilder.getBuildingStep();
        } else {
            piglinBuilder.setBuildingStructureName(resourceLocation);
        }
        StructureTemplate structuretemplate = structuretemplatemanager.getOrCreate(resourceLocation);

        this.template = structuretemplate;
        Rotation rotation = Rotation.getRandom(piglinBuilder.getRandom());
        ChunkPos chunkpos = new ChunkPos(globalPos.pos());
        BoundingBox boundingbox = new BoundingBox(chunkpos.getMinBlockX() - 16, level.getMinBuildHeight(), chunkpos.getMinBlockZ() - 16, chunkpos.getMaxBlockX() + 16, level.getMaxBuildHeight(), chunkpos.getMaxBlockZ() + 16);
        StructurePlaceSettings structureplacesettings = (new StructurePlaceSettings()).setRotation(rotation).setBoundingBox(boundingbox).setRandom(piglinBuilder.getRandom());
        Vec3i vec3i = structuretemplate.getSize(rotation);
        this.templateSettings = structureplacesettings;

        BlockPos blockpos1 = new BlockPos(-vec3i.getX() / 2, 0, -vec3i.getZ() / 2);
        BlockPos blockpos2 = new BlockPos(vec3i.getX() / 2, vec3i.getY(), vec3i.getZ() / 2);

        this.maxPos = blockpos2;
        this.rotation = rotation;
    }

    protected void stop(ServerLevel p_217118_, PiglinBuilder p_217119_, long p_217120_) {
        Brain<?> brain = p_217119_.getBrain();

        if (this.workOver) {
            brain.eraseMemory(MemoryModuleTypeInit.WORK_POS.get());
            p_217119_.setBuildingStructureName(null);
            p_217119_.setBuildingStep(0);
        }
    }

    protected void tick(ServerLevel level, PiglinBuilder mob, long p_147405_) {
        Brain<?> brain = mob.getBrain();
        Optional<GlobalPos> globalPos = brain.getMemory(MemoryModuleTypeInit.WORK_POS.get());


        if (globalPos.isPresent()) {
            BlockPos blockpos1 = globalPos.get().pos().offset(-maxPos.getX(), 0, -maxPos.getZ());

            BlockPos blockpos2 = template.getZeroPositionWithTransform(blockpos1, Mirror.NONE, this.rotation);

            List<StructureTemplate.StructureBlockInfo> list = templateSettings.getRandomPalette(template.palettes, blockpos2).blocks();

            List<StructureTemplate.StructureBlockInfo> list2 = processBlockInfos(level, blockpos2, blockpos2, this.templateSettings, list, this.template).stream().filter(info -> !(mob.level.getBlockState(globalPos.get().pos().offset(info.pos)).isAir() && info.state.isAir())).toList();
            if (step > list2.size() - 1) {
                workOver = true;
                return;
            }
            if (this.currentBlockPos == null) {
                StructureTemplate.StructureBlockInfo structureBlockInfo = list2.get(step);
                BlockPos origin = structureBlockInfo.pos;
                if (isReplaceable(level.getBlockState(origin), level, mob)) {
                    blockState = structureBlockInfo.state;
                    currentBlockPos = origin;
                    step += 1;
                } else {
                    step += 1;
                }
            }
            mob.getNavigation().moveTo(globalPos.get().pos().getX(), globalPos.get().pos().getY(), globalPos.get().pos().getZ(), this.speedMultiplier);

            if (--this.tick < 0) {
                if (currentBlockPos != null) {

                    if (globalPos.get().pos().distSqr(mob.blockPosition()) < 32F) {
                        if (isReplaceable(level.getBlockState(currentBlockPos), level, mob)) {
                            if (blockState != null && !blockState.isAir() && blockState.getFluidState().isEmpty()) {
                                SoundType soundType = blockState.getSoundType();
                                level.playSound(null, currentBlockPos, soundType.getPlaceSound(), SoundSource.BLOCKS, soundType.getVolume(), blockState.getSoundType().getPitch());
                            }
                            BlockState realState = blockState.mirror(templateSettings.getMirror()).rotate(templateSettings.getRotation());

                            Block.pushEntitiesUp(level.getBlockState(currentBlockPos), realState, level, currentBlockPos);
                            level.setBlock(currentBlockPos, realState, 3);

                            currentBlockPos = null;
                        } else {
                            currentBlockPos = null;
                        }
                    }
                }
                this.tick = 4;

            }
            mob.getNavigation().moveTo(globalPos.get().pos().getX(), globalPos.get().pos().getY(), globalPos.get().pos().getZ(), this.speedMultiplier);

        }
        mob.setBuildingStep(this.step);
    }


    private boolean isReplaceable(BlockState blockState, ServerLevel level, PiglinBuilder mob) {
        return !blockState.is(BlockTags.FEATURES_CANNOT_REPLACE) && ForgeEventFactory.getMobGriefingEvent(level, mob);
    }

    @Override
    protected boolean timedOut(long pGameTime) {
        return false;
    }
}
