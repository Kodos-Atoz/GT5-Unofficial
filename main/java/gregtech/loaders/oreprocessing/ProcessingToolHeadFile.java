package gregtech.loaders.oreprocessing;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_ModHandler.RecipeBits;
import gregtech.common.items.GT_MetaGenerated_Tool_01;
import net.minecraft.item.ItemStack;

public class ProcessingToolHeadFile implements gregtech.api.interfaces.IOreRecipeRegistrator
{
  public ProcessingToolHeadFile()
  {
    OrePrefixes.toolHeadFile.add(this);
  }
  
  public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack)
  {
    GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(18, 1, aMaterial, aMaterial.mHandleMaterial, null), new Object[] { aOreDictName, OrePrefixes.stick.get(aMaterial.mHandleMaterial) });
    if ((!aMaterial.contains(SubTag.NO_SMASHING)) && (!aMaterial.contains(SubTag.BOUNCY))) {
      GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(18, 1, aMaterial, aMaterial.mHandleMaterial, null), GT_ModHandler.RecipeBits.MIRRORED | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[] { "P", "P", "S", Character.valueOf('P'), OrePrefixes.plate.get(aMaterial), Character.valueOf('S'), OrePrefixes.stick.get(aMaterial.mHandleMaterial) });
    }
  }
}


/* Location:              F:\Torrent\minecraft\jdgui test\gregtech_1.7.10-5.07.07-dev.jar!\gregtech\loaders\oreprocessing\ProcessingToolHeadFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1-SNAPSHOT-20140817
 */