package me.bluepanee.pwnoclip.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static me.bluepanee.pwnoclip.CommonClass.isNoclipActive;

@Mixin(Camera.class)
public class MixinCamera {
    @ModifyExpressionValue(method = "extractRenderState", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isSpectator()Z"))
    private boolean pwnoclip$bypassSmartCullCheck(boolean original) {
        return original || isNoclipActive();
    }
}
