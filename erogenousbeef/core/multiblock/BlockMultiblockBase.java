package erogenousbeef.core.multiblock;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/*
 * Base class for multiblock-capable blocks. This is only a reference implementation
 * and can be safely ignored.
 * If you decide to implement your own Multiblock-capable blocks, make sure you
 * do what I do here in onBlockAdded - call the onBlockAdded callback in your tile entity.
 * If you don't do that, your blocks won't connect to a controller!
 */
public abstract class BlockMultiblockBase extends BlockContainer {

	protected BlockMultiblockBase(int par1, Material par2Material) {
		super(par1, par2Material);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if(te != null && te instanceof IMultiblockPart) {
			((IMultiblockPart)te).onBlockAdded(world, x, y, z);
		}
	}
}
