package com.infamous.dungeons_mobs.client.renderer.jungle;

import com.infamous.dungeons_mobs.DungeonsMobs;
import com.infamous.dungeons_mobs.client.models.jungle.WhispererModel;
import com.infamous.dungeons_mobs.client.renderer.layers.GeoEyeLayer;
import com.infamous.dungeons_mobs.entities.jungle.WhispererEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.example.client.DefaultBipedBoneIdents;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderers.geo.ExtendedGeoEntityRenderer;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class WhispererRenderer extends ExtendedGeoEntityRenderer<WhispererEntity> {
	
    @SuppressWarnings("unchecked")
	public WhispererRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WhispererModel());
        this.addLayer(new GeoEyeLayer(this, new ResourceLocation(DungeonsMobs.MODID, "textures/entity/jungle/whisperer_glow.png")));
    }

    @Override
    protected void applyRotations(WhispererEntity entityLiving, PoseStack matrixStackIn, float ageInTicks,
                                  float rotationYaw, float partialTicks) {
        float scaleFactor = 1.0F;
        matrixStackIn.scale(scaleFactor, scaleFactor, scaleFactor);
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);

    }

    @Override
    public RenderType getRenderType(WhispererEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

    @Override
    public void renderRecursively(GeoBone bone, PoseStack stack, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        if(this.isArmorBone(bone)) {
            bone.setCubesHidden(true);
        }
        super.renderRecursively(bone, stack, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    @Override
    protected boolean isArmorBone(GeoBone bone) {
        return bone.getName().startsWith("armor");
    }

    @Nullable
    @Override
    protected ResourceLocation getTextureForBone(String s, WhispererEntity windcallerEntity) {
        return null;
    }

	@Override
	protected ItemStack getHeldItemForBone(String boneName, WhispererEntity currentEntity) {
		switch (boneName) {
		case DefaultBipedBoneIdents.LEFT_HAND_BONE_IDENT:
			return currentEntity.isLeftHanded() ? mainHand : offHand;
		case DefaultBipedBoneIdents.RIGHT_HAND_BONE_IDENT:
			return currentEntity.isLeftHanded() ? offHand : mainHand;
		case DefaultBipedBoneIdents.POTION_BONE_IDENT:
			break;
		}
		return null;
	}

	@Override
	protected TransformType getCameraTransformForItemAtBone(ItemStack boneItem, String boneName) {
		switch (boneName) {
		case DefaultBipedBoneIdents.LEFT_HAND_BONE_IDENT:
			return TransformType.THIRD_PERSON_RIGHT_HAND;
		case DefaultBipedBoneIdents.RIGHT_HAND_BONE_IDENT:
			return TransformType.THIRD_PERSON_RIGHT_HAND;
		default:
			return TransformType.NONE;
		}
	}

	@Override
	protected void preRenderItem(PoseStack stack, ItemStack item, String boneName, WhispererEntity currentEntity, IBone bone) {
		if(item == this.mainHand || item == this.offHand) {
			stack.scale(1.1F, 1.1F, 1.1F);
			stack.mulPose(Vector3f.XP.rotationDegrees(-90.0F));
			boolean shieldFlag = item.getItem() instanceof ShieldItem;
			if(item == this.mainHand) {
				if(shieldFlag) {
					stack.translate(0.0, 0.125, -0.25);
				} else {
					
				}
			} else {
				if(shieldFlag) {
					stack.translate(-0.15, 0.125, 0.05);
					stack.mulPose(Vector3f.YP.rotationDegrees(90));
				} else {
					
				}
					
				
			}
		}
	}

	@Override
	protected void postRenderItem(PoseStack matrixStack, ItemStack item, String boneName, WhispererEntity currentEntity, IBone bone) {

	}
    
	@Override
	protected BlockState getHeldBlockForBone(String boneName, WhispererEntity currentEntity) {
		return null;
	}
	
	@Override
	protected void preRenderBlock(PoseStack matrixStack, BlockState block, String boneName,
			WhispererEntity currentEntity) {
		
	}

	@Override
	protected void postRenderBlock(PoseStack matrixStack, BlockState block, String boneName,
			WhispererEntity currentEntity) {
		
	}

    @Nullable
    @Override
    protected ItemStack getArmorForBone(String boneName, WhispererEntity currentEntity) {
        switch (boneName) {
            case "armorBipedLeftFoot":
            case "armorBipedRightFoot":
                return boots;
            case "armorBipedLeftLeg":
            case "armorBipedRightLeg":
                return leggings;
            case "armorBipedBody":
            case "armorBipedRightArm":
            case "armorBipedLeftArm":
            case "armorIllagerRightArm":
            case "armorIllagerLeftArm":
                return chestplate;
            case "armorBipedHead":
                return helmet;
            default:
                return null;
        }
    }

    @Override
    protected EquipmentSlot getEquipmentSlotForArmorBone(String boneName, WhispererEntity currentEntity) {
        switch (boneName) {
            case "armorBipedLeftFoot":
            case "armorBipedRightFoot":
                return EquipmentSlot.FEET;
            case "armorBipedLeftLeg":
            case "armorBipedRightLeg":
                return EquipmentSlot.LEGS;
            case "armorBipedRightHand":
                return !currentEntity.isLeftHanded() ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            case "armorBipedLeftHand":
                return currentEntity.isLeftHanded() ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            case "armorBipedRightArm":
            case "armorBipedLeftArm":
            case "armorIllagerRightArm":
            case "armorIllagerLeftArm":
            case "armorBipedBody":
                return EquipmentSlot.CHEST;
            case "armorBipedHead":
                return EquipmentSlot.HEAD;
            default:
                return null;
        }
    }

    @Override
    protected ModelPart getArmorPartForBone(String name, HumanoidModel<?> armorBipedModel) {
        switch (name) {
            case "armorBipedLeftFoot":
            case "armorBipedLeftLeg":
                return armorBipedModel.leftLeg;
            case "armorBipedRightFoot":
            case "armorBipedRightLeg":
                return armorBipedModel.rightLeg;
            case "armorBipedRightArm":
            case "armorIllagerRightArm":
                return armorBipedModel.rightArm;
            case "armorBipedLeftArm":
            case "armorIllagerLeftArm":
                return armorBipedModel.leftArm;
            case "armorBipedBody":
                return armorBipedModel.body;
            case "armorBipedHead":
                return armorBipedModel.head;
            default:
                return null;
        }
    }
}