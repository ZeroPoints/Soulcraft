package com.zeropoints.ensoulomancy.items.tools;

import java.util.HashMap;

import com.zeropoints.ensoulomancy.Main;
import com.zeropoints.ensoulomancy.init.ModItems;
import com.zeropoints.ensoulomancy.init.ModRenderers;
import com.zeropoints.ensoulomancy.util.IHasModel;

import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel {
	
	/* For general abilities */ 
	public HashMap<String,Object> Abilities = new HashMap<String,Object>();
	
	protected Boolean CAN_BEHEAD = false;
	protected float HEAD_DROP_CHANCE = 0.0F;
	
	public ToolSword(String name, ToolMaterial material) {
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.ENSOULOMANCY_TAB);
		
		this.registerAbilities();
		
		ModItems.ITEMS.add(this);
	}
	
	/*
	 * Override this method to register abilities in the map
	 */
	protected void registerAbilities() {
		
	}
	
	@Override
	public void registerModels() {
		ModRenderers.registerRenderer(this, 0, "inventory");
	}
	
}
