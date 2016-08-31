package gigabit101.AdvancedSystemManager2.blocks;

import gigabit101.AdvancedSystemManager2.AdvancedSystemManager2;
import gigabit101.AdvancedSystemManager2.init.ModBlocks;
import gigabit101.AdvancedSystemManager2.lib.ModInfo;
import gigabit101.AdvancedSystemManager2.tiles.TileEntityManager;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class BlockManager extends BlockContainer
{
    public BlockManager()
    {
        super(Material.IRON);
        setUnlocalizedName(ModInfo.UNLOCALIZED_START + ModBlocks.MANAGER_UNLOCALIZED_NAME);
        setSoundType(SoundType.METAL);
        setCreativeTab(ModBlocks.creativeTab);
        setHardness(2F);
    }

    public static final IProperty LIMITLESS = PropertyBool.create("limitless");

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, LIMITLESS);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(LIMITLESS, meta == 1);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return (Boolean) state.getValue(LIMITLESS) ? 1 : 0;
    }


    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityManager();
    }


    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
        {
            FMLNetworkHandler.openGui(player, AdvancedSystemManager2.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(world, pos, state);
        updateInventories(world, pos);
    }

//    @Override
//    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
//        super.onNeighborChange(world, pos, neighbor);
//        updateInventories(world, pos);
//    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        super.breakBlock(world, pos, state);
        updateInventories(world, pos);
    }

    private void updateInventories(World world, BlockPos pos)
    {
        TileEntity tileEntity = world.getTileEntity(pos);
        if (tileEntity != null && tileEntity instanceof TileEntityManager)
        {
            ((TileEntityManager) tileEntity).updateInventories();
        }
    }
}
