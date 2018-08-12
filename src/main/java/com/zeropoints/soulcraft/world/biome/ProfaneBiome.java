package com.zeropoints.soulcraft.world.biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.ChunkPrimer;


public class ProfaneBiome extends Biome implements ICustomBiome {

	protected List<Biome.SpawnListEntry> highMonsterList = Lists.<Biome.SpawnListEntry>newArrayList();
	protected List<Biome.SpawnListEntry> midMonsterList = Lists.<Biome.SpawnListEntry>newArrayList();
	protected List<Biome.SpawnListEntry> lowMonsterList = Lists.<Biome.SpawnListEntry>newArrayList();
	

	
	public ProfaneBiome(BiomeProperties properties) {
		super(properties);

		this.setRegistryName("sc", "profane");


		this.topBlock = Blocks.NETHERRACK.getDefaultState(); 
		this.fillerBlock = Blocks.SOUL_SAND.getDefaultState(); 

		highMonsterList = Lists.newArrayList(
        	new SpawnListEntry(net.minecraft.entity.monster.EntityMagmaCube.class, 1, 1, 1)
	    ) ;
		midMonsterList = Lists.newArrayList(
			new SpawnListEntry(net.minecraft.entity.monster.EntityHusk.class, 1, 1, 1)
	    ) ;
		lowMonsterList = Lists.newArrayList(
			new SpawnListEntry(net.minecraft.entity.monster.EntityGhast.class, 1, 1, 1)
	    ) ;
	    
	    
	}
	
	public IBlockState getBaseBlock() {
		return Blocks.NETHERRACK.getDefaultState();
	}
	

	@Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
		int i = 40;
        IBlockState iblockstate = this.topBlock;
        IBlockState iblockstate1 = this.fillerBlock;
        int j = -1;
        //int k = (int)(noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        //K is noise for how many blocks it will FILL up. Fill goes reverse from air to fill depth
        int k = 5;
        int l = x & 15;
        int i1 = z & 15;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        IBlockState iPrevBlockState = Blocks.AIR.getDefaultState();
        
        for (int j1 = 300; j1 >= 0; --j1)
        {
        
            IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);

            if (iblockstate2.getMaterial() == Material.AIR)
            {
                j = -1;
                if(iPrevBlockState.getMaterial() != Material.AIR) {
                    iPrevBlockState = Blocks.AIR.getDefaultState();
                    chunkPrimerIn.setBlockState(i1, j1 + 1, l, iPrevBlockState);
                }
            }
            else if (iblockstate2.getBlock() == Blocks.EMERALD_BLOCK)
            {
            	if (j == -1 && iPrevBlockState.getMaterial() == Material.AIR)
                {
                	iblockstate = this.topBlock;
                    iblockstate1 = this.fillerBlock;

                    j = k;


                    chunkPrimerIn.setBlockState(i1, j1, l, iblockstate);
                    iPrevBlockState = iblockstate;
                    
                }
            	else if (j >= 0)
                {
                    --j;
                    chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);
                    iPrevBlockState = iblockstate1;
                }
                else {
                    chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);
                    iPrevBlockState = iblockstate1;
                }
            }
        }
        
		
    }
	
	public List<Biome.SpawnListEntry> getSpawnableList(EnumCreatureType creatureType, BlockPos pos)
    {

    	if(pos.getY() <= 50) {
    		return lowMonsterList;
    	}
    	if(pos.getY() > 50 && pos.getY() <= 90) {
    		return midMonsterList;
    	}
    	if(pos.getY() > 90) {
    		return highMonsterList;
    	}
		return midMonsterList;

    }
	

}
