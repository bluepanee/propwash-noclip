package me.bluepanee.pwnoclip.mixin;

import de.lardtom.propwash.input.SwitchFunction;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SwitchFunction.class)
public enum MixinSwitchFunction {
    PWNOCLIP_NOCLIP;

    @Final
    @Shadow
    public static SwitchFunction COMMAND_1;

    @Shadow
    @Final
    public static int COMMAND_COUNT;

    @Inject(method = "supportsToggle", at = @At("HEAD"), cancellable = true)
    private void pwnoclip$hookSupportsToggle(CallbackInfoReturnable<Boolean> cir) {
        if (this.name().equals("PWNOCLIP_NOCLIP")) cir.setReturnValue(true);
    }

    @Inject(method = "command()Z", at = @At("HEAD"), cancellable = true)
    private void pwnoclip$fixCommand(CallbackInfoReturnable<Boolean> cir) {
        if (this.ordinal() >= COMMAND_1.ordinal() + COMMAND_COUNT) cir.setReturnValue(false);
    }
}
