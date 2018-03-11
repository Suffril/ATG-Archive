package com.lcm.doctorwho.common.blocks;

import javax.annotation.Nullable;

import com.lcm.doctorwho.common.capabilities.CapabilityTileTardis;
import com.lcm.doctorwho.common.capabilities.ITardis;
import com.lcm.doctorwho.common.tiles.TileEntityTardis;
import com.lcm.doctorwho.networking.ATGNetwork;
import com.lcm.doctorwho.networking.packets.MessageSyncTardis;
import com.lcm.doctorwho.utils.ATGUtils;
import com.lcm.doctorwho.utils.TardisUtils;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class BlockTardis extends BlockOutline {
    public BlockTardis(Material material, MapColor color, String name) {
        super(material, color, name);
        setLightLevel(1.0F);
    }

    public BlockTardis(Material material, String name) {
        super(material, name);
        setLightLevel(1.0F);
    }

    /**
     * Called by ItemBlocks after a block is set in the world, to allow post-place logic
     */
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        TileEntityTardis tardis = (TileEntityTardis) worldIn.getTileEntity(pos);
        ITardis capa = tardis.getCapability(CapabilityTileTardis.TARDIS, null);
        capa.setTardisID(700); //Need to figure out a way of assigning these
        capa.setOwner(placer.getUniqueID().toString());
    }





    /**
     * Called when the block is right clicked by a player.
     */
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntityTardis tardis = (TileEntityTardis) worldIn.getTileEntity(pos);
        ITardis capa = tardis.getCapability(CapabilityTileTardis.TARDIS, null);
        if(playerIn.getUniqueID().toString().equalsIgnoreCase(capa.getOwner())) {
            capa.setDoorOpen(!capa.isDoorOpen());
            NBTTagCompound tardisNBT = tardis.writeToNBT(TardisUtils.tardisWriteToNBT(capa));
            tardis.readFromNBT(tardisNBT);
            tardis.markDirty();
            ATGNetwork.INSTANCE.sendToAllAround(new MessageSyncTardis(pos, TardisUtils.tardisWriteToNBT(capa)), new NetworkRegistry.TargetPoint(playerIn.dimension, playerIn.posX, playerIn.posY, playerIn.posY, 50));
        }
        else
            {
                ATGUtils.sendPlayerMessage(playerIn, "This is not your TARDIS!");
            }

        return true;
    }
        /**
         * Called throughout the code as a replacement for block instanceof
         * BlockContainer Moving this to the Block base class allows for mods that wish
         * to extend vanilla blocks, and also want to have a tile entity on that block,
         * may.
         *
         * Return true from this function to specify this block has a tile entity.
         *
         * @param state
         *            State of the current block
         * @return True if block has a tile entity, false otherwise
         */
    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    /**
     * Called throughout the code as a replacement for
     * ITileEntityProvider.createNewTileEntity Return the same thing you would from
     * that function. This will fall back to
     * ITileEntityProvider.createNewTileEntity(World) if this block is a
     * ITileEntityProvider
     *
     * @param state
     *            The state of the current block
     * @return A instance of a class extending TileEntity
     */
    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityTardis();
    }

    /**
     * The type of render function called. MODEL for mixed tesr and static model,
     * MODELBLOCK_ANIMATED for TESR-only, LIQUID for vanilla liquids, INVISIBLE to
     * skip all rendering
     */
    @Deprecated
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

}
