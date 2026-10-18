package me.bluepanee.pwnoclip.mixin;

import de.lardtom.propwash.sim.DroneSim;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static me.bluepanee.pwnoclip.CommonClass.isNoclipActive;

@Mixin(DroneSim.class)
public class MixinDroneSim {
    @Shadow
    private boolean planeValid;

    @Inject(method = "choosePlane", at = @At("TAIL"))
    public void pwnoclip$bypassPlaneCheck(CallbackInfo ci) {
        if (isNoclipActive()) this.planeValid = false;
    }
}
