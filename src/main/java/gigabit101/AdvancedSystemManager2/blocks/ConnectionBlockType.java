package gigabit101.AdvancedSystemManager2.blocks;

import gigabit101.AdvancedSystemManager2.lib.Localization;
import gigabit101.AdvancedSystemManager2.tiles.*;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;

public enum ConnectionBlockType {
    INVENTORY(Localization.TYPE_INVENTORY, null, false),
    TANK(Localization.TYPE_TANK, IFluidHandler.class, false),
    EMITTER(Localization.TYPE_EMITTER, TileEntityOutput.class, false),
    RECEIVER(Localization.TYPE_RECEIVER, TileEntityInput.class, false),
    NODE(Localization.TYPE_NODE, IRedstoneNode.class, true),
    BUD(Localization.TYPE_BUD, TileEntityBUD.class, false),
    CAMOUFLAGE(Localization.TYPE_CAMOUFLAGE, TileEntityCamouflage.class, false),
    SIGN(Localization.TYPE_SIGN, TileEntitySignUpdater.class, false);

    private Localization name;
    private Class clazz;
    private boolean group;

    private ConnectionBlockType(Localization name, Class clazz, boolean group) {
        this.name = name;
        this.clazz = clazz;
        this.group = group;
    }

    public boolean isInstance(TileEntity tileEntity) {
        boolean flag = false;
        /*
        If Type is Inventory, check if the block allows for you to take from the inventory on any side.
        If it has the capability, the flag is changed, and the loop is broken.
        If Type is not Inventory, then it checks if the tile is an instance of the given class.
         */
        if (this.equals(INVENTORY)) {
            for (int i = 0; i < EnumFacing.VALUES.length && !flag; i++) {
                flag = tileEntity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.VALUES[i]);
            }
        } else {
            flag = clazz.isInstance(tileEntity);
        }
        return flag;
    }

    public <T> T getObject(TileEntity tileEntity) {
        return (T) tileEntity;
    }

    public boolean isGroup() {
        return group;
    }

    public Localization getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
