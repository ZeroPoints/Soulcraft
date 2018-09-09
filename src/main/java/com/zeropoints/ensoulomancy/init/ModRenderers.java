package com.zeropoints.ensoulomancy.init;

import com.zeropoints.ensoulomancy.entity.hallowed.*;
import com.zeropoints.ensoulomancy.entity.profane.*;
import com.zeropoints.ensoulomancy.render.entity.mobs.*;
import com.zeropoints.ensoulomancy.util.IHasModel;
import com.zeropoints.ensoulomancy.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
public class ModRenderers {
	
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
    	// Items
    	for (final Item item: ModItems.ITEMS) {
			if (item instanceof IHasModel) {
				((IHasModel)item).registerModels();	
			}
		}
    	
    	// Blocks
    	for (final Block block: ModBlocks.BLOCKS) {
    		if (block instanceof IHasModel) {
    			((IHasModel)block).registerModels();
    		}
    	}
    	
        // Entities
        /*for (final Entity entity: ModEntities.ENTITIES) {
        	if (entity instanceof IEntity) {
        		((IEntity)entity).RegisterEntityRenderer();
        	}
        }*/
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityPixie.class, new RenderPixie.RenderFactory());
    	RenderingRegistry.registerEntityRenderingHandler(EntityImp.class, new RenderImp.RenderFactory());
    }

    public static void registerRenderer(Item item, int meta, String id) {
        ModelResourceLocation resource = new ModelResourceLocation(item.getRegistryName(), id);
        ModelLoader.setCustomModelResourceLocation(item, meta, resource);
    }

    public static void registerRenderer(Block block, int meta, String id) {
        registerRenderer(Item.getItemFromBlock(block), meta, id);
    }
    
}