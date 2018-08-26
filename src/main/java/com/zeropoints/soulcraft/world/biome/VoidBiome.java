package com.zeropoints.soulcraft.world.biome;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.zeropoints.soulcraft.init.ModBiomes;


import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.ChunkPrimer;


public class VoidBiome extends Biome implements ICustomBiome {

	
	/**
	 * Initiates the purgatories Void biome 
	 */
	public VoidBiome(BiomeProperties properties) {
		super(properties);

		

		this.setRegistryName("sc", "voidbiome");

		this.topBlock = Blocks.AIR.getDefaultState(); 
		this.fillerBlock = Blocks.AIR.getDefaultState(); 

		
        
	}
	
	
	

	/**
	 * Goes through each block from ceiling to floor replacing blocks related to this biome
	 */
	@Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        int l = x & 15;
        int i1 = z & 15;

        for (int j1 = 256; j1 >= 0; --j1)
        {
        	//If you want all to be air just get rid of IF
        	
        	chunkPrimerIn.setBlockState(i1, j1, l, AIR);
        	
        }
        
		
    }
	
	



	
	/**
	 * Gets the monsters that this biome will spawn
	 */
	public List<Biome.SpawnListEntry> getSpawnableList(EnumCreatureType creatureType, BlockPos pos)
    {
		return null;
    }

	
	
	@Override
	public List<SpawnListEntry> getMiddleSpawn() {    
		return Lists.newArrayList() ;	
	}
	

	
	@Override
	public List<SpawnListEntry> getLocaleSpawn() {
		return Lists.newArrayList() ;	
	}
	
	

	@Override
	public int GetMaxHeight() {
		return -1;
	}
	
	@Override
	public int GetMinHeight() {
		return -1;
	}
	
	
}
