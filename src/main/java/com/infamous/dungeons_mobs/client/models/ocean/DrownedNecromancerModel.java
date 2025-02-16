package com.infamous.dungeons_mobs.client.models.ocean;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.infamous.dungeons_mobs.DungeonsMobs;
import com.infamous.dungeons_mobs.client.particle.ModParticleTypes;
import com.infamous.dungeons_mobs.entities.water.DrownedNecromancerEntity;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.molang.MolangParser;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;
import software.bernie.geckolib3.resource.GeckoLibCache;

@OnlyIn(Dist.CLIENT)
public class DrownedNecromancerModel extends AnimatedGeoModel<DrownedNecromancerEntity> {

    @Override
    public ResourceLocation getAnimationFileLocation(DrownedNecromancerEntity entity) {
        return new ResourceLocation(DungeonsMobs.MODID, "animations/drowned_necromancer.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(DrownedNecromancerEntity entity) {
        return new ResourceLocation(DungeonsMobs.MODID, "geo/drowned_necromancer.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DrownedNecromancerEntity entity) {
        return new ResourceLocation(DungeonsMobs.MODID, "textures/entity/ocean/drowned_necromancer.png");
    }

    @Override
    public void setCustomAnimations(DrownedNecromancerEntity entity, int uniqueID, AnimationEvent customPredicate) {
        super.setCustomAnimations(entity, uniqueID, customPredicate);

        IBone head = this.getAnimationProcessor().getBone("bipedHead");
        IBone cape = this.getAnimationProcessor().getBone("bipedCape");
        
        IBone particles = this.getAnimationProcessor().getBone("staffParticles");
        
        if (particles instanceof GeoBone && entity.isSpellcasting()) {
        	GeoBone particleBone = ((GeoBone)particles);
        	entity.level.addParticle(entity.isInWaterOrBubble() ? ParticleTypes.BUBBLE_COLUMN_UP : ModParticleTypes.NECROMANCY.get(), particleBone.getWorldPosition().x, particleBone.getWorldPosition().y, particleBone.getWorldPosition().z, 0, 0, 0);
        }

        cape.setHidden(entity.getItemBySlot(EquipmentSlot.CHEST).getItem() != entity.getArmorSet().getChest().get());
        
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);

        if (extraData.headPitch != 0 || extraData.netHeadYaw != 0) {
            head.setRotationX(head.getRotationX() + (extraData.headPitch * ((float) Math.PI / 180F)));
            head.setRotationY(head.getRotationY() + (extraData.netHeadYaw * ((float) Math.PI / 180F)));
        }
    }
    
	@Override
	public void setMolangQueries(IAnimatable animatable, double currentTick) {
		super.setMolangQueries(animatable, currentTick);
		
		MolangParser parser = GeckoLibCache.getInstance().parser;
		LivingEntity livingEntity = (LivingEntity) animatable;
		Vec3 velocity = livingEntity.getDeltaMovement();
		float groundSpeed = Mth.sqrt((float) ((velocity.x * velocity.x) + (velocity.z * velocity.z)));
		parser.setValue("query.ground_speed", () -> groundSpeed * 20);
	}
}
