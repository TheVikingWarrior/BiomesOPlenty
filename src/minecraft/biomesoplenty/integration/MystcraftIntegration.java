package biomesoplenty.integration;

import java.lang.reflect.Method;

import biomesoplenty.api.Liquids;
import biomesoplenty.configuration.BOPConfiguration;

public class MystcraftIntegration {

	public static void init()
	{
		blacklistSymbols();
	}

	private static void blacklistSymbols()
	{
		try 
		{
			Method method = Class.forName("com.xcompwiz.mystcraft.generation.symbols.SymbolManager").getMethod("blackListSymbol", String.class);
			
			method.invoke("biome" + BOPConfiguration.promisedLandForestID);
			method.invoke("biome" + BOPConfiguration.promisedLandPlainsID);
			method.invoke("biome" + BOPConfiguration.promisedLandSwampID);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}