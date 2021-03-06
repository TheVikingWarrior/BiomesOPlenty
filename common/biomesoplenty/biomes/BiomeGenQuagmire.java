package biomesoplenty.biomes;

import java.awt.Color;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import worldcore.interfaces.IWCFog;
import biomesoplenty.api.Blocks;
import biomesoplenty.configuration.configfile.BOPConfigurationMisc;
import biomesoplenty.worldgen.tree.WorldGenDeadTree;

public class BiomeGenQuagmire extends BiomeGenBase implements IWCFog
{
	private BiomeDecoratorBOP customBiomeDecorator;

	public BiomeGenQuagmire(int par1)
	{
		super(par1);
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		topBlock = (byte)Blocks.mud.get().blockID;
		fillerBlock = (byte)Blocks.mud.get().blockID;
		theBiomeDecorator = new BiomeDecoratorBOP(this);
		customBiomeDecorator = (BiomeDecoratorBOP)theBiomeDecorator;
		customBiomeDecorator.treesPerChunk = 0;
		customBiomeDecorator.grassPerChunk = 10;
		customBiomeDecorator.mushroomsPerChunk = 3;
		customBiomeDecorator.flowersPerChunk = -999;
		customBiomeDecorator.sandPerChunk = -999;
		customBiomeDecorator.sandPerChunk2 = -999;
		customBiomeDecorator.wheatGrassPerChunk = 3;
		customBiomeDecorator.waterReedsPerChunk = 2;
		customBiomeDecorator.koruPerChunk = 1;
		waterColorMultiplier = 13390080;
		customBiomeDecorator.generateQuagmire = true;
	}
	
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);
		int var5 = 12 + par2Random.nextInt(6);

		for (int var6 = 0; var6 < var5; ++var6)
		{
			int var7 = par3 + par2Random.nextInt(16);
			int var8 = par2Random.nextInt(28) + 4;
			int var9 = par4 + par2Random.nextInt(16);
			int var10 = par1World.getBlockId(var7, var8, var9);

			Block block = Block.blocksList[var10]; 
			if (block != null && block.isGenMineableReplaceable(par1World, var7, var8, var9, Block.stone.blockID))
			{
				par1World.setBlock(var7, var8, var9, Blocks.amethystOre.get().blockID, 10, 2);
			}
		}
	}

	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
	 @Override
	 public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	 {
		 return new WorldGenDeadTree(false);
	 }

	 /**
	  * Provides the basic grass color based on the biome temperature and rainfall
	  */
	 @Override
	 public int getBiomeGrassColor()
	 {
		 return 10390377;
	 }

	 /**
	  * Provides the basic foliage color based on the biome temperature and rainfall
	  */
	 @Override
	 public int getBiomeFoliageColor()
	 {
		 return 10390377;
	 }
	 
	@Override
	public int getFogColour()
	{
		return 13291213;
	}
	
	@Override
	public float getFogCloseness()
	{
	    // TODO Auto-generated method stub
	    return 0.6F;
	}

	 /**
	  * takes temperature, returns color
	  */
	 @Override
	 public int getSkyColorByTemp(float par1)
	 {
		 if (BOPConfigurationMisc.skyColors)
			 return 12436670;
		 else
		 {
			 par1 /= 3.0F;

			 if (par1 < -1.0F)
			 {
				 par1 = -1.0F;
			 }

			 if (par1 > 1.0F)
			 {
				 par1 = 1.0F;
			 }

			 return Color.getHSBColor(0.62222224F - par1 * 0.05F, 0.5F + par1 * 0.1F, 1.0F).getRGB();
		 }
	 }
}
