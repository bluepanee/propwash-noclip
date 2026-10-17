package me.bluepanee.pwnoclip.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import de.lardtom.propwash.drone.client.FpvEyeGuard;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static me.bluepanee.pwnoclip.CommonClass.isNoclipActive;

@Mixin(FpvEyeGuard.class)
public class MixinFpvEyeGuard {
    @ModifyExpressionValue(method = "apply(Lnet/minecraft/world/level/BlockGetter;Lorg/joml/Vector3d;Lorg/joml/Vector3dc;Lorg/joml/Vector3fc;Lorg/joml/Vector3fc;Lorg/joml/Vector3fc;FFD)Z", at = @At(value = "FIELD", target = "Lde/lardtom/propwash/drone/client/FpvEyeGuard;bypassed:Z", opcode = Opcodes.GETFIELD))
    private boolean bypassFpvEyeGuard(boolean original) {
        return original || isNoclipActive();
    }
}
