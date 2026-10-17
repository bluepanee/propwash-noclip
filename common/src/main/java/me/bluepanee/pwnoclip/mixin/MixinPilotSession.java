package me.bluepanee.pwnoclip.mixin;

import de.lardtom.propwash.drone.QuadcopterEntity;
import de.lardtom.propwash.drone.client.FpvView;
import de.lardtom.propwash.drone.client.PilotSession;
import de.lardtom.propwash.input.RadioState;
import de.lardtom.propwash.input.SwitchFunction;
import de.lardtom.propwash.sim.Fluid;
import me.bluepanee.pwnoclip.Constants;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static me.bluepanee.pwnoclip.CommonClass.isNoclipActive;

@Mixin(PilotSession.class)
public abstract class MixinPilotSession {
    @Shadow
    private @Nullable QuadcopterEntity drone;

    @Shadow
    protected abstract boolean stillValid(Minecraft mc, QuadcopterEntity d);

    @Unique
    public void pwnoclip$setDronePhysics(boolean on) {
        if (this.drone != null) this.drone.noPhysics = on;
    }

    @Inject(at = @At(value = "INVOKE", target = "Lde/lardtom/propwash/drone/client/FpvView;setPilotBody(Ljava/lang/Object;)V", shift = At.Shift.AFTER), method = "onClientTick")
    private void hookOnClientTick(Minecraft mc, CallbackInfo ci) {
        if (drone != null) {
            drone.noPhysics = isNoclipActive();
        }
    }

    @Inject(at = @At("HEAD"), method = "fluidAt", cancellable = true)
    private static void hookFluidAt(Level level, double x, double y, double z, CallbackInfoReturnable<Fluid> cir) {
        if (isNoclipActive()) cir.setReturnValue(Fluid.NONE);
    }
}
