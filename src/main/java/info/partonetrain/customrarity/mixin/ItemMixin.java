package info.partonetrain.customrarity.mixin;

import info.partonetrain.customrarity.Customrarity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
	@Inject(at = @At("HEAD"), method = "getRarity", cancellable = true)
	private void init(ItemStack itemStack, CallbackInfoReturnable<Rarity> cir) {
		Customrarity.LOGGER.info("getRarity called");
		String tag = itemStack.getOrCreateTag().getString("CustomRarity");
		Customrarity.LOGGER.info(tag);
		if(!tag.isEmpty()){
            switch (tag) {
                case "Common" -> cir.setReturnValue(Rarity.COMMON);
                case "Uncommon" -> cir.setReturnValue(Rarity.UNCOMMON);
                case "Rare" -> cir.setReturnValue(Rarity.RARE);
                case "Epic" -> cir.setReturnValue(Rarity.EPIC);
				default -> cir.setReturnValue(Rarity.COMMON);
            }
		}

		//config code here
	}
}