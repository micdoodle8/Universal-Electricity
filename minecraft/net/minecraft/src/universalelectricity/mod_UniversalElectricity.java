package net.minecraft.src.universalelectricity;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraft.src.universalelectricity.electricity.ElectricityManager;
import net.minecraft.src.universalelectricity.ore.BlockUEOre;
import net.minecraft.src.universalelectricity.ore.UEOreManager;
import net.minecraft.src.universalelectricity.recipe.UERecipeManager;

/**
 * This class is basically just a loader for Universal Components
 * @author Calclavia
 */

public class mod_UniversalElectricity extends BaseMod
{	
	@Override
	public void load()
	{
		//MinecraftForge.versionDetect("Universal Electricity", 3, 4, 9);
		ModLoader.setInGameHook(this, true, true);
		
		ModLoader.registerBlock(UEOreManager.blockOre[0], ItemUniversalOre0.class);
		ModLoader.registerBlock(UEOreManager.blockOre[1], ItemUniversalOre1.class);
	}
	
	@Override
    public void modsLoaded()
    {
		UERecipeManager.initialize();
    }
	
	@Override
	public String getVersion()
	{
		return UniversalElectricity.getVersion();
	}
	
	@Override
	public String getPriorities()
    {
        return "before:*";
    }
	
	/**
     * Ticked every game tick if you have subscribed to tick events through {@link ModLoader#setInGameHook(BaseMod, boolean, boolean)}
     * 
     * @param time the rendering subtick time (0.0-1.0)
     * @param minecraftInstance the client
     * @return true to continue receiving ticks
     */
	@Override
    public boolean onTickInGame(float time, Minecraft minecraftInstance)
    {
		ElectricityManager.onUpdate();
        return true;
    }
	
	@Override
	public void generateSurface(World world, Random rand, int chunkX, int chunkZ)
    {
		UEOreManager.generateSurface(world, rand, chunkX, chunkZ);
    }
    
    @Override
	public String getName()
    {
        return "Universal Electricity";
    }
}