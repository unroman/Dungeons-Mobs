package com.infamous.dungeons_mobs.entities.projectiles;

import com.infamous.dungeons_mobs.client.particle.ModParticleTypes;
import com.infamous.dungeons_mobs.mod.ModEntityTypes;
import com.infamous.dungeons_mobs.mod.ModSoundEvents;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.protocol.Packet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class DrownedNecromancerOrbEntity extends StraightMovingProjectileEntity implements IAnimatable {
	
	public int textureChange = 0;

	AnimationFactory factory = GeckoLibUtil.createFactory(this);
		   
	public DrownedNecromancerOrbEntity(Level worldIn) {
		super(ModEntityTypes.DROWNED_NECROMANCER_ORB.get(), worldIn);
	}

	public DrownedNecromancerOrbEntity(EntityType<? extends DrownedNecromancerOrbEntity> p_i50147_1_, Level p_i50147_2_) {
		super(p_i50147_1_, p_i50147_2_);
	}

	public DrownedNecromancerOrbEntity(Level p_i1794_1_, LivingEntity p_i1794_2_, double p_i1794_3_, double p_i1794_5_,
			double p_i1794_7_) {
		super(ModEntityTypes.DROWNED_NECROMANCER_ORB.get(), p_i1794_2_, p_i1794_3_, p_i1794_5_, p_i1794_7_, p_i1794_1_);
	}

	@OnlyIn(Dist.CLIENT)
	public DrownedNecromancerOrbEntity(Level p_i1795_1_, double p_i1795_2_, double p_i1795_4_, double p_i1795_6_,
			double p_i1795_8_, double p_i1795_10_, double p_i1795_12_) {
		super(ModEntityTypes.DROWNED_NECROMANCER_ORB.get(), p_i1795_2_, p_i1795_4_, p_i1795_6_, p_i1795_8_, p_i1795_10_,
				p_i1795_12_, p_i1795_1_);
	}
	
	@Override
	protected ParticleOptions getTrailParticle() {
		return ModParticleTypes.NECROMANCY.get();
	}
	
	@Override
	public double getSpawnParticlesY() {
		return 0.2;
	}
	
	@Override
	public boolean slowedDownInWater() {
		return false;
	}
	
	@Override
	protected float getInertia() {
		return 0.8F;
	}
	
	@Override
	protected MovementEmission getMovementEmission() {
        return MovementEmission.NONE;
	}

	@Override
	public void baseTick() {
		super.baseTick();		
		
		if (this.tickCount % 5 == 0) {
			textureChange ++;		
		}
		
		if (!this.level.isClientSide && !this.isInWaterRainOrBubble()) {
			this.playSound(ModSoundEvents.DROWNED_NECROMANCER_STEAM_MISSILE_IMPACT.get(), 1.0F, 1.0F);
			this.remove(RemovalReason.DISCARDED);
		}
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller", 2, this::predicate));
	}

	private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
		return PlayState.CONTINUE;
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}

	public boolean isOnFire() {
		return false;
	}

	protected void onHitEntity(EntityHitResult p_213868_1_) {
		super.onHitEntity(p_213868_1_);
	}
	
	public void onHitEntity(Entity entity) {
		if (entity instanceof Mob && ((Mob)entity).getMobType() == MobType.UNDEAD) {
			
		} else if (!this.level.isClientSide) {
			super.onHitEntity(entity);
			Entity entity1 = this.getOwner();
			boolean flag;
			if (entity1 instanceof LivingEntity) {
				LivingEntity livingentity = (LivingEntity) entity1;
				flag = entity.hurt(DamageSource.indirectMobAttack(this, livingentity), 8.0F);
				if (flag) {
					if (entity.isAlive()) {
						this.doEnchantDamageEffects(livingentity, entity);
					}
				}
			} else {
				flag = entity.hurt(DamageSource.MAGIC, 6.0F);
			}

	    	entity.getRootVehicle().ejectPassengers();
	    	
	    	entity.setDeltaMovement(entity.getDeltaMovement().add(this.getDeltaMovement().scale(2.0D)));
			
			this.playSound(ModSoundEvents.DROWNED_NECROMANCER_STEAM_MISSILE_IMPACT.get(), 1.0F, 1.0F);
			this.remove(RemovalReason.DISCARDED);
		}
	}

	public boolean isPickable() {
		return false;
	}

	public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {
		return false;
	}

	protected boolean shouldBurn() {
		return false;
	}
	
	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	@Override
	public SoundEvent getImpactSound() {
		return ModSoundEvents.DROWNED_NECROMANCER_STEAM_MISSILE_IMPACT.get();
	}
}
