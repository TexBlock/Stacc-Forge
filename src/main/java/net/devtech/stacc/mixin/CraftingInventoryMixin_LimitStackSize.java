package net.devtech.stacc.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.Inventory;

import static net.devtech.stacc.Stacc.fastbenchLoaded;

@Mixin(CraftingInventory.class)
public abstract class CraftingInventoryMixin_LimitStackSize implements Inventory {
	private static final int STACC_SIZE_LIMIT;
	static {
		if(fastbenchLoaded) {
			STACC_SIZE_LIMIT = 1_000_000;
		} else {
			STACC_SIZE_LIMIT = 1_000;
		}
	}

	@Override
	public int getMaxCountPerStack() {
		return STACC_SIZE_LIMIT;
	}
}
