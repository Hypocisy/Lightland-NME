package com.kyogi.notmutuallyexclusive.mixin;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ProtectionEnchantment.class)
public class ProtectionEnchantmentMixin {
    /**
     * @author kyogi
     * @reason remove enchantment exclusive
     */
    @Inject(at= @At("HEAD"), method = "checkCompatibility", cancellable = true)
    public void notMutuallyExclusive_overrideProtectionEnchantment_checkCompatibility(Enchantment p_44590_, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(true);
    }
}
