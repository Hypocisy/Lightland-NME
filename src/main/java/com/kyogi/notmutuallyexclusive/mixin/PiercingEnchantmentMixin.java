package com.kyogi.notmutuallyexclusive.mixin;

import net.minecraft.world.item.enchantment.ArrowPiercingEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArrowPiercingEnchantment.class)
public class PiercingEnchantmentMixin {
    /**
     * @author
     * @reason
     */
    @Inject(at= @At("HEAD"), method = "checkCompatibility", cancellable = true)
    public void notMutuallyExclusive_overridePiercingEnchantmentMixin_checkCompatibility(Enchantment p_44590_, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(true);
    }
}
