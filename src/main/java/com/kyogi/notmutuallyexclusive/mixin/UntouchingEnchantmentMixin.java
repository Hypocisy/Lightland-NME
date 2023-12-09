package com.kyogi.notmutuallyexclusive.mixin;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.UntouchingEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(UntouchingEnchantment.class)
public class UntouchingEnchantmentMixin {
    /**
     * @author
     * @reason
     */
    @Inject(at= @At("HEAD"), method = "checkCompatibility", cancellable = true)
    public void notMutuallyExclusive_overrideUntouchingEnchantment_checkCompatibility(Enchantment p_44590_, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(true);
    }
}
