package gregtech.common.items.behaviors;

import gregtech.api.GregTech_API;
import gregtech.api.items.GT_MetaBase_Item;
import gregtech.api.items.GT_MetaGenerated_Tool;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_Utility;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import thaumcraft.api.aspects.IEssentiaTransport;

public class Behaviour_Plunger_Essentia
  extends Behaviour_None
{
  private final int mCosts;
  
  public Behaviour_Plunger_Essentia(int aCosts)
  {
    this.mCosts = aCosts;
  }
  
  public boolean onItemUseFirst(GT_MetaBase_Item aItem, ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ, int aSide, float hitX, float hitY, float hitZ)
  {
    if (aWorld.isRemote) {
      return false;
    }
    TileEntity aTileEntity = aWorld.getTileEntity(aX, aY, aZ);
    if (((aTileEntity instanceof IEssentiaTransport)) && (
      (aPlayer.capabilities.isCreativeMode) || (((GT_MetaGenerated_Tool)aItem).doDamage(aStack, this.mCosts))))
    {
      GT_Utility.sendSoundToPlayers(aWorld, (String)GregTech_API.sSoundList.get(Integer.valueOf(101)), 1.0F, -1.0F, aX, aY, aZ);
      for (ForgeDirection tDirection : ForgeDirection.VALID_DIRECTIONS) {
        ((IEssentiaTransport)aTileEntity).takeEssentia(((IEssentiaTransport)aTileEntity).getEssentiaType(tDirection), ((IEssentiaTransport)aTileEntity).getEssentiaAmount(tDirection), tDirection);
      }
      return true;
    }
    return false;
  }
  
  private final String mTooltip = GT_LanguageManager.addStringLocalization("gt.behaviour.plunger.essentia", "Clears Essentia from Containers and Tubes");
  
  public List<String> getAdditionalToolTips(GT_MetaBase_Item aItem, List<String> aList, ItemStack aStack)
  {
    aList.add(this.mTooltip);
    return aList;
  }
}


/* Location:           F:\Torrent\minecraft\jd-gui-0.3.6.windows\gregtech_1.7.10-5.07.07-dev.jar
 * Qualified Name:     gregtech.common.items.behaviors.Behaviour_Plunger_Essentia
 * JD-Core Version:    0.7.0.1
 */