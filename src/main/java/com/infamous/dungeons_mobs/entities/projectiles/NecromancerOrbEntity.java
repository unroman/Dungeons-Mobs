package com.infamous.dungeons_mobs.entities.projectiles;

import com.infamous.dungeons_mobs.client.particle.ModParticleTypes;
import com.infamous.dungeons_mobs.mod.ModEntityTypes;
import com.infamous.dungeons_mobs.mod.ModSoundEvents;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import static software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes.LOOP;

public class NecromancerOrbEntity extends StraightMovingProjectileEntity implements IAnimatable {

	private static final EntityDataAccessor<Boolean> DELAYED_FORM = SynchedEntityData.defineId(NecromancerOrbEntity.class,
			EntityDataSerializers.BOOLEAN);
	
	public int formAnimationTick;
	public int formAnimationLength = 20;

	public int vanishAnimationTick;

	public int textureChange = 0;

	AnimationFactory factory = GeckoLibUtil.createFactory(this);

	public NecromancerOrbEntity(Level worldIn) {
		super(ModEntityTypes.NECROMANCER_ORB.get(), worldIn);
	}

	public NecromancerOrbEntity(EntityType<? extends NecromancerOrbEntity> p_i50147_1_, Level p_i50147_2_) {
		super(p_i50147_1_, p_i50147_2_);
	}

	public NecromancerOrbEntity(Level p_i1794_1_, LivingEntity p_i1794_2_, double p_i1794_3_, double p_i1794_5_,
								double p_i1794_7_) {
		super(ModEntityTypes.NECROMANCER_ORB.get(), p_i1794_2_, p_i1794_3_, p_i1794_5_, p_i1794_7_, p_i1794_1_);
	}

	public NecromancerOrbEntity(EntityType<? extends NecromancerOrbEntity> necromancerOrbEntityType, Level p_i1795_1_, double p_i1795_2_, double p_i1795_4_, double p_i1795_6_,
								double p_i1795_8_, double p_i1795_10_, double p_i1795_12_) {
		super(necromancerOrbEntityType, p_i1795_2_, p_i1795_4_, p_i1795_6_, p_i1795_8_, p_i1795_10_,
				p_i1795_12_, p_i1795_1_);
	}

	public NecromancerOrbEntity(Level p_i1795_1_, double p_i1795_2_, double p_i1795_4_, double p_i1795_6_,
								double p_i1795_8_, double p_i1795_10_, double p_i1795_12_) {
		super(ModEntityTypes.NECROMANCER_ORB.get(), p_i1795_2_, p_i1795_4_, p_i1795_6_, p_i1795_8_, p_i1795_10_,
				p_i1795_12_, p_i1795_1_);
	}

	public NecromancerOrbEntity(EntityType<? extends NecromancerOrbEntity> necromancerOrbEntityType, LivingEntity p_i1794_2_, double p_i1794_3_, double p_i1794_5_, double p_i1794_7_, Level p_i1794_1_) {
		super(necromancerOrbEntityType, p_i1794_2_, p_i1794_3_, p_i1794_5_, p_i1794_7_, p_i1794_1_);
	}
	
	public void handleEntityEvent(byte p_28844_) {
		if (p_28844_ == 1) {
			this.vanishAnimationTick = this.getVanishAnimationLength();
		} else if (p_28844_ == 2) {
			this.formAnimationTick = formAnimationLength;
		} else {
			super.handleEntityEvent(p_28844_);
		}
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
	public boolean shouldSpawnParticles() {
		return this.vanishAnimationTick <= 0;
	}
	
	@Override
	protected float getInertia() {
		return 0.8F;
	}

	public void startForming() {
		if (!this.level.isClientSide) {
			this.formAnimationTick = this.formAnimationLength;
			this.level.broadcastEntityEvent(this, (byte) 2);
		}
	}
	
	@Override
	protected MovementEmission getMovementEmission() {
        return MovementEmission.NONE;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		this.tickDownAnimTimers();
		
		if (this.tickCount % 5 == 0) {
			textureChange ++;
		}
		
		if (!this.level.isClientSide && this.lifeTime >= this.vanishAfterTime() && this.vanishAnimationTick <= 0) {
			this.vanishAnimationTick = this.getVanishAnimationLength();
			this.level.broadcastEntityEvent(this, (byte) 1);
		}
		
		if (!this.level.isClientSide && this.hasDelayedForm()) {
			this.startForming();
			this.setDelayedForm(false);
		}
		
		if (!this.level.isClientSide && this.vanishAnimationTick > 0) {
			this.setDeltaMovement(0, 0, 0);
		}

		if (!this.level.isClientSide && this.vanishAnimationTick == 2) {
			this.remove(RemovalReason.DISCARDED);
		}
	}

	public void tickDownAnimTimers() {
		if (this.formAnimationTick > 0) {
			this.formAnimationTick--;
		}

		if (this.vanishAnimationTick > 0) {
			this.vanishAnimationTick--;
		}
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller", 2, this::predicate));
	}

	private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
		if (this.vanishAnimationTick > 0) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("necromancer_orb_vanish", LOOP));
		} else if (this.formAnimationTick > 0) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("necromancer_orb_form", LOOP));
		} else {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("necromancer_orb_idle", LOOP));
		}
		return PlayState.CONTINUE;
	}
	
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DELAYED_FORM, false);
	}
	
	public boolean hasDelayedForm() {
		return this.entityData.get(DELAYED_FORM);
	}

	public void setDelayedForm(boolean attached) {
		this.entityData.set(DELAYED_FORM, attached);
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
				flag = entity.hurt(DamageSource.indirectMagic(this, livingentity), 6.0F);
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
		    	
			this.playSound(ModSoundEvents.NECROMANCER_ORB_IMPACT.get(), 1.0F, 1.0F);
			this.vanishAnimationTick = this.getVanishAnimationLength();
			this.level.broadcastEntityEvent(this, (byte) 1);
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
		return ModSoundEvents.NECROMANCER_ORB_IMPACT.get();
	}

	@Override
	public int getVanishAnimationLength() {
		return 40;
	}
}
