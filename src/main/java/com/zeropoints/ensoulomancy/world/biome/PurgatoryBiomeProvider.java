package com.zeropoints.ensoulomancy.world.biome;

import com.zeropoints.ensoulomancy.init.ModDimensions;
import com.zeropoints.ensoulomancy.world.gen.layer.GenLayerPurgatory;
import com.zeropoints.ensoulomancy.world.gen.layer.GenLayerRiverStyx;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;


public class PurgatoryBiomeProvider extends BiomeProvider {


	public PurgatoryBiomeProvider(World world) {
		this(world.getSeed(), world.getWorldInfo().getTerrainType(), world.getWorldInfo().getGeneratorOptions());
	}
	
	public PurgatoryBiomeProvider(long seed, WorldType worldType, String chunkProviderSettings) {
		super(ModDimensions.purgatoryWorldInfo);
		
	}
	
	
	

	/**
	 * Initiates Purgatorys gen layers for deciding what chunks get what biomes
	 * Technically this does nothing besides seeding the funcctions with recursiveness.
	 * Look at GetInts functions inside the genlayers to see what actually logic is applied
	 */
    @Override
    public GenLayer[] getModdedBiomeGenerators(WorldType worldType, long seed, GenLayer[] original) {
        
    	//Initiates the 3 biomes layout to seed the world.
    	GenLayer biomes = new GenLayerPurgatory(seed);
        
        //Zooms in...Kinda amplifies the size of biomes...Int is how many times it calls this function
        biomes = GenLayerZoom.magnify(1000L, biomes,3);

        //Smothes the edges of biomes. Can probably move this up higher on.
        biomes = new GenLayerSmooth(1000L, biomes);

        //Creates voids between our 3 custom biomes from the purgatory biome
        biomes = new GenLayerRiverStyx(1000L, biomes);

        //Smothes the edges of biomes. Can probably move this up higher on.
        biomes = new GenLayerSmooth(1000L, biomes);
        

        //Zooms in...Kinda amplifies the size of biomes...Int is how many times it calls this function
        biomes = GenLayerZoom.magnify(1000L, biomes,4);

        //Smothes the edges of biomes. Can probably move this up higher on.
        biomes = new GenLayerSmooth(1000L, biomes);
        
        

       //Magic...Dont know..DONT KNOW. Cant pass in biomes as second genlayer. Has to be a voronoizoom?
        GenLayer biomeIndexLayer = new GenLayerVoronoiZoom(1000L, biomes);
        biomeIndexLayer.initWorldGenSeed(seed);
        biomes.initWorldGenSeed(seed);

        //Have to return 2 always...Dont know why
        return new GenLayer[]{
                biomes,
                biomeIndexLayer
        };
    }
	
	
	
	
}
