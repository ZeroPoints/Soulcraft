package com.zeropoints.soulcraft.renderer.entity.mobs;

import com.zeropoints.soulcraft.model.profane.ModelImp;
import com.zeropoints.soulcraft.util.Reference;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;


@SideOnly(Side.CLIENT)
public class RenderImp extends RenderLiving<EntityImp> {
	
	private static final ResourceLocation IMP_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/profane/imp.png");
	
	public RenderImp(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelImp(), 0.2F);
		GlStateManager.scale(0.1F, 0.1F, 0.1F);
		//this.addLayer(new LayerImp(this));
	}
	
	protected ResourceLocation getEntityTexture(EntityImp entity) {
		return IMP_TEXTURES;
	}
	
	@Override
    protected void preRenderCallback(EntityImp entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scale(0.7F, 0.7F, 0.7F);
    }
	
	@Override
	protected void applyRotations(EntityImp entityLiving, float a, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, a, rotationYaw, partialTicks);
		
		if((double)entityLiving.limbSwingAmount >= 0.01D) {
			float f = 13.0F;
			float f1 = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - partialTicks);
			float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
			GlStateManager.rotate(6.5F * f2, 0.0F, 0.0F, 1.0F);
		}
	}
	
}