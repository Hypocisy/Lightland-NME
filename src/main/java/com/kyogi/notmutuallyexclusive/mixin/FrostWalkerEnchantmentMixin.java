package com.kyogi.notmutuallyexclusive.mixin;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.FrostWalkerEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FrostWalkerEnchantment.class)
public class FrostWalkerEnchantmentMixin {

    /**
     * @author
     * @reason
     */
    @Inject(at= @At("HEAD"), method = "checkCompatibility", cancellable = true)
    public void notMutuallyExclusive_overrideFrostWalkerEnchantment_checkCompatibility(Enchantment p_44590_, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(true);
    }
}
