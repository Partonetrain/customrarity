package info.partonetrain.customrarity.mixin;

import info.partonetrain.customrarity.Customrarity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(at = @At("HEAD"), method = "getRarity", cancellable = true)
    private void customrarity_changeRarity(ItemStack itemStack, CallbackInfoReturnable<Rarity> cir) {
        //Customrarity.LOGGER.info("getRarity called");
        if(itemStack.getTag() != null) {
            String tag = itemStack.getTag().getString("CustomRarity");
            //Customrarity.LOGGER.info(tag);
            if (!tag.isEmpty()) {
                switch (tag) {
                    case "Common" -> cir.setReturnValue(Rarity.COMMON);
                    case "Uncommon" -> cir.setReturnValue(Rarity.UNCOMMON);
                    case "Rare" -> cir.setReturnValue(Rarity.RARE);
                    case "Epic" -> cir.setReturnValue(Rarity.EPIC);
                    default -> cir.setReturnValue(Rarity.COMMON);
                }
            }
        }

        if (cir.getReturnValue() == null) {
            ResourceLocation itemID = BuiltInRegistries.ITEM.getKey(itemStack.getItem());
            if (Arrays.asList(Customrarity.config.commons).contains(itemID.toString())) {
                cir.setReturnValue(Rarity.COMMON);
            } else if (Arrays.asList(Customrarity.config.uncommons).contains(itemID.toString())) {
                cir.setReturnValue(Rarity.UNCOMMON);
            } else if (Arrays.asList(Customrarity.config.rares).contains(itemID.toString())) {
                cir.setReturnValue(Rarity.RARE);
            } else if (Arrays.asList(Customrarity.config.epics).contains(itemID.toString())) {
                cir.setReturnValue(Rarity.EPIC);
            }
        }
    }
}