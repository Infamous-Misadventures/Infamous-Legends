package com.infamous.infamous_legends.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class SpawnerFlameParticle extends TextureSheetParticle {
	
	private SpriteSet sprites;
	
    protected SpawnerFlameParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
    		SpriteSet spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);

        this.sprites = spriteSet;
        
        this.quadSize = 0.4F;
        this.lifetime = 10;
        this.hasPhysics = false;
        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
        
        this.setSpriteFromAge(this.sprites);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.sprites);
        this.fadeOut();
    }
    
    private void fadeOut() {
        this.alpha = ((-(1/(float)lifetime) * age) * 0.5F + 1);
    }
    
    public int getLightColor(float pPartialTick) {
        int i = super.getLightColor(pPartialTick);
        int j = 240;
        int k = i >> 16 & 255;
        return 240 | k << 16;
     }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new SpawnerFlameParticle(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }
}
