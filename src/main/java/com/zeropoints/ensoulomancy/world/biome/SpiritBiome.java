package com.zeropoints.ensoulomancy.world.biome;

import java.util.Random;

import com.zeropoints.ensoulomancy.Main;
import com.zeropoints.ensoulomancy.entity.ghost.EntityIttanMomen;
import com.zeropoints.ensoulomancy.init.ModBlocks;


import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;


public class SpiritBiome extends Biome implements ICustomBiome {

	
	/**
	 * Initiates the purgatories Spirit biome 
	 */
	public SpiritBiome() {
		super(new Biome.BiomeProperties("SpiritBiome").setBaseHeight(2.55F).setHeightVariation(0.4F));
		
		//May aswell register it i guess
		this.setRegistryName(Main.MOD_ID, "spirit");
		
		//Set some default blocks for this biome
		this.topBlock = Blocks.SOUL_SAND.getDefaultState(); 
		this.fillerBlock = ModBlocks.SOUL_STONE.getDefaultState(); 
		
		
		//Clear and set new defaults
		this.spawnableMonsterList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityIttanMomen.class, 1, 1, 1));
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
	}
	


	/**
	 * Goes through each block from ceiling to floor replacing blocks related to this biome
	 */
	@Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
		ICustomBiome.CustomeGenTerrainBlocks(this.topBlock, this.fillerBlock, GetMaxHeight(), GetMinHeight(), worldIn, rand, chunkPrimerIn, x, z, noiseVal);

    }
	
	

	
	

	/**
	 * Height limitation for this biome
	 */
	@Override
	public int GetMaxHeight() {
		return 160;
	}
	
	/**
	 * Height limitation for this biome
	 */
	@Override
	public int GetMinHeight() {
		return 100;
	}
}
