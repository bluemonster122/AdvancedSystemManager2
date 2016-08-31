package gigabit101.AdvancedSystemManager2.blocks;

import gigabit101.AdvancedSystemManager2.init.ModBlocks;
import gigabit101.AdvancedSystemManager2.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemIntake extends ItemBlock
{
    public ItemIntake(Block block)
    {
        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack item)
    {
        return "tile." + ModInfo.UNLOCALIZED_START + (ModBlocks.blockCableIntake.isAdvanced(item.getItemDamage()) ? ModBlocks.CABLE_INSTANT_INTAKE_UNLOCALIZED_NAME : ModBlocks.CABLE_INTAKE_UNLOCALIZED_NAME);
    }
}
