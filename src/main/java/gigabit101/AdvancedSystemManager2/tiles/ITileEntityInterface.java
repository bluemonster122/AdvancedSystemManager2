package gigabit101.AdvancedSystemManager2.tiles;

import gigabit101.AdvancedSystemManager2.network.DataReader;
import gigabit101.AdvancedSystemManager2.network.DataWriter;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface ITileEntityInterface
{
    public abstract Container getContainer(TileEntity te, InventoryPlayer inv);

    @SideOnly(Side.CLIENT)
    public abstract GuiScreen getGui(TileEntity te, InventoryPlayer inv);

    public abstract void readAllData(DataReader dr, EntityPlayer player);

    public abstract void readUpdatedData(DataReader dr, EntityPlayer player);

    public abstract void writeAllData(DataWriter dw);
}
