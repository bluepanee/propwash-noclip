package me.bluepanee.pwnoclip.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import org.spongepowered.asm.mixin.Mixin;
import de.lardtom.propwash.drone.DronePiloting;
import org.spongepowered.asm.mixin.injection.At;

import static me.bluepanee.pwnoclip.CommonClass.isNoclipActive;

@Mixin(DronePiloting.class)
public class MixinDronePiloting {
    @ModifyExpressionValue(method = "onState", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;noBlockCollision(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/AABB;)Z"))
    private static boolean pwnoclip$bypassBlockCollisionCheck(boolean original) {
        return original || isNoclipActive();
    }

    @ModifyExpressionValue(method = "onState", at = @At(value = "INVOKE", target = "Lde/lardtom/propwash/drone/PathCheck;clear(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/AABB;Lnet/minecraft/world/phys/Vec3;)Z"))
    private static boolean pwnoclip$bypassPathCheck(boolean original) {
        return original || isNoclipActive();
    }
}
