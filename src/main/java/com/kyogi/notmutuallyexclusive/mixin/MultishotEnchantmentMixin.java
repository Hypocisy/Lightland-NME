package com.kyogi.notmutuallyexclusive.mixin;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.MultiShotEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MultiShotEnchantment.class)
public class MultishotEnchantmentMixin {
    /**
     * @author
     * @reason
     */
    @Inject(at= @At("HEAD"), method = "checkCompatibility", cancellable = true)
    public void notMutuallyExclusive_overrideMultiShotEnchantment_checkCompatibility(Enchantment p_44590_, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(true);
    }
}
