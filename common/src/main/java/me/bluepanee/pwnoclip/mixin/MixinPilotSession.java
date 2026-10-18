package me.bluepanee.pwnoclip.mixin;

import de.lardtom.propwash.drone.QuadcopterEntity;
import de.lardtom.propwash.drone.client.PilotSession;
import de.lardtom.propwash.sim.Fluid;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static me.bluepanee.pwnoclip.CommonClass.isNoclipActive;

@Mixin(PilotSession.class)
public abstract class MixinPilotSession {
    @Shadow
    private @Nullable QuadcopterEntity drone;

    @Inject(method = "onClientTick", at = @At(value = "INVOKE", target = "Lde/lardtom/propwash/drone/client/FpvView;setPilotBody(Ljava/lang/Object;)V", shift = At.Shift.AFTER))
    private void pwnoclip$hookOnClientTick(Minecraft mc, CallbackInfo ci) {
        if (drone != null) {
            drone.noPhysics = isNoclipActive();
        }
    }

    @Inject(method = "fluidAt", at = @At("HEAD"), cancellable = true)
    private static void pwnoclip$hookFluidAt(Level level, double x, double y, double z, CallbackInfoReturnable<Fluid> cir) {
        if (isNoclipActive()) cir.setReturnValue(Fluid.NONE);
    }
}
