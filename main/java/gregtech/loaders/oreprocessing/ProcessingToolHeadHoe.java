/*  1:   */ package gregtech.loaders.oreprocessing;
/*  2:   */ 
/*  3:   */ import gregtech.api.enums.Materials;
/*  4:   */ import gregtech.api.enums.OrePrefixes;
/*  5:   */ import gregtech.api.interfaces.IOreRecipeRegistrator;
/*  6:   */ import gregtech.api.util.GT_ModHandler;
/*  7:   */ import gregtech.common.items.GT_MetaGenerated_Tool_01;
/*  8:   */ import net.minecraft.item.ItemStack;
/*  9:   */ 
/* 10:   */ public class ProcessingToolHeadHoe
/* 11:   */   implements IOreRecipeRegistrator
/* 12:   */ {
/* 13:   */   public ProcessingToolHeadHoe()
/* 14:   */   {
/* 15:13 */     OrePrefixes.toolHeadHoe.add(this);
/* 16:   */   }
/* 17:   */   
/* 18:   */   public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack)
/* 19:   */   {
/* 20:18 */     GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(8, 1, aMaterial, aMaterial.mHandleMaterial, null), new Object[] { aOreDictName, OrePrefixes.stick.get(aMaterial.mHandleMaterial) });
/* 21:   */   }
/* 22:   */ }


/* Location:           F:\Torrent\minecraft\jd-gui-0.3.6.windows\gregtech_1.7.10-5.07.07-dev.jar
 * Qualified Name:     gregtech.loaders.oreprocessing.ProcessingToolHeadHoe
 * JD-Core Version:    0.7.0.1
 */