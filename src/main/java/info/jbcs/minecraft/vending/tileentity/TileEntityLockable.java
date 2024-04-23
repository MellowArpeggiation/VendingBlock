package info.jbcs.minecraft.vending.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.nbt.NBTTagCompound;

public abstract class TileEntityLockable extends TileEntity implements ISidedInventory {

    private String ownerName = "";

    public boolean canUnlock(EntityPlayer player) {
        if (player.capabilities.isCreativeMode) return true;
        return player.getDisplayName().equals(ownerName);
    }

    public String getOwner() {
        return ownerName;
    }

    public void setOwner(EntityPlayer player) {
        setOwner(player.getDisplayName());
    }

    public void setOwner(String ownerName) {
        this.ownerName = ownerName;
    }

	@Override
	public void readFromNBT(NBTTagCompound nbttagcompound) {
		super.readFromNBT(nbttagcompound);
		ownerName = nbttagcompound.getString("owner");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		nbttagcompound.setString("owner", ownerName);
	}

}
