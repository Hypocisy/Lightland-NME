package com.kyogi.notmutuallyexclusive.mixin;

import com.kyogi.notmutuallyexclusive.config.NmeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EndPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EndPortalBlock.class)
public class EndPortalBlockMixin {
    @Unique
    private ServerLevel customEndPortalDimension$serverLevel;

    @Inject(method = "entityInside", at = @At(value = "HEAD", target = "Lnet/minecraft/world/level/block/EndPortalBlock;entityInside(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/Entity;)V"), cancellable = true)
    private void onEntityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity, CallbackInfo ci) {
        if (pLevel instanceof ServerLevel && pEntity.canChangeDimensions() && Shapes.joinIsNotEmpty(Shapes.create(pEntity.getBoundingBox().move(-pPos.getX(), -pPos.getY(), -pPos.getZ())), pState.getShape(pLevel, pPos), BooleanOp.AND)) {
            ResourceKey<Level> dimensionKey = pLevel.dimension() == Level.END ? Level.OVERWORLD : Level.END;
            if (NmeConfig.getConfigSpec().getRight().get("dimensionKey") != null) {
                dimensionKey = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("aether"));
            }
            this.customEndPortalDimension$serverLevel = ((ServerLevel) pLevel).getServer().getLevel(dimensionKey);
            if (this.customEndPortalDimension$serverLevel == null) {
                return;
            }
            pEntity.changeDimension(this.customEndPortalDimension$serverLevel);
            ci.cancel();
        }
    }

}
