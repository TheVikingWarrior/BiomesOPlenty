package biomesoplenty.common.world.forceddecorators.overworld;

import biomesoplenty.api.BOPBlockHelper;
import biomesoplenty.common.world.decoration.ForcedDecorator;
import biomesoplenty.common.world.features.WorldGenBOPFlora;
import biomesoplenty.common.world.features.WorldGenBOPTallGrass;
import net.minecraft.init.Blocks;

public class SavannaForcedDecorator extends ForcedDecorator
{
	public SavannaForcedDecorator(int id)
	{
        super(id);

        this.bopWorldFeatures.setFeature("leafPilesPerChunk", 10);
        this.bopWorldFeatures.setFeature("deadLeafPilesPerChunk", 5);
        this.bopWorldFeatures.setFeature("bushesPerChunk", 3);
        this.bopWorldFeatures.setFeature("waterReedsPerChunk", 5);

        this.bopWorldFeatures.setFeature("bopFlowersPerChunk", 10);
        this.bopWorldFeatures.setFeature("bopGrassPerChunk", 20);

        this.bopWorldFeatures.weightedFlowerGen.put(new WorldGenBOPFlora(BOPBlockHelper.get("flowers"), 7), 8);

        this.bopWorldFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(Blocks.tallgrass, 1), 1D);
        this.bopWorldFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(BOPBlockHelper.get("foliage"), 2), 0.5D);
        this.bopWorldFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(BOPBlockHelper.get("foliage"), 10), 0.5D);
        this.bopWorldFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(BOPBlockHelper.get("foliage"), 11), 0.5D);
	}
}