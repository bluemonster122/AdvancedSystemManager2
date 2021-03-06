package gigabit101.AdvancedSystemManager2.tiles;

import gigabit101.AdvancedSystemManager2.blocks.ClusterMethodRegistration;
import gigabit101.AdvancedSystemManager2.init.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import java.util.EnumSet;


public class TileEntityCreative extends TileEntityClusterElement implements IInventory, IFluidHandler
{


    @Override
    public int fill(EnumFacing from, FluidStack resource, boolean doFill)
    {
        return resource == null ? 0 : resource.amount;
    }

    @Override
    public FluidStack drain(EnumFacing from, FluidStack resource, boolean doDrain)
    {
        return resource == null ? null : resource.copy();
    }

    @Override
    public FluidStack drain(EnumFacing from, int maxDrain, boolean doDrain)
    {
        return null;
    }

    @Override
    public boolean canFill(EnumFacing from, Fluid fluid)
    {
        return true;
    }

    @Override
    public boolean canDrain(EnumFacing from, Fluid fluid)
    {
        return true;
    }

    @Override
    public FluidTankInfo[] getTankInfo(EnumFacing from)
    {
        return new FluidTankInfo[0];
    }

    @Override
    public int getSizeInventory()
    {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int i)
    {
        return null;
    }

    @Override
    public ItemStack decrStackSize(int i, int j)
    {
        return null;
    }

    @Override
    public ItemStack removeStackFromSlot(int i)
    {
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack)
    {

    }

    @Override
    public String getName()
    {
        return ModBlocks.CABLE_CREATIVE_NAME_TAG;
    }

    @Override
    public boolean hasCustomName()
    {
        return false;
    }

    @Override
    public ITextComponent getDisplayName()
    {
        return null;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        return false;
    }

    @Override
    public void openInventory(EntityPlayer player)
    {

    }

    @Override
    public void closeInventory(EntityPlayer player)
    {

    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
        return true;
    }

    @Override
    public int getField(int id)
    {
        return 0;
    }

    @Override
    public void setField(int id, int value)
    {

    }

    @Override
    public int getFieldCount()
    {
        return 0;
    }

    @Override
    public void clear()
    {

    }

    @Override
    protected EnumSet<ClusterMethodRegistration> getRegistrations()
    {
        return EnumSet.noneOf(ClusterMethodRegistration.class);
    }

    @Override
    public void update()
    {

    }



    /**
     * Capabilities
     */

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T) new InvWrapper(this) : super.getCapability(capability, facing);
    }
}
