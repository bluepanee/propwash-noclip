package me.bluepanee.pwnoclip.mixin;

import de.lardtom.propwash.input.SwitchFunction;
import de.lardtom.propwash.input.client.FunctionKeys;
import de.lardtom.propwash.input.client.KeyDefaults;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FunctionKeys.class)
public class MixinFunctionKeys {
    @Inject(at = @At("HEAD"), method = "entry", cancellable = true)
    private static void en(SwitchFunction function, CallbackInfoReturnable<KeyDefaults.Entry> cir) {
        if (function.name().equals("PWNOCLIP_NOCLIP")) cir.setReturnValue(new KeyDefaults.Entry("noclip", 0, false, false));
    }
}
