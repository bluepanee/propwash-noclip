package me.bluepanee.pwnoclip.mixin;

import de.lardtom.propwash.input.SwitchFunction;
import de.lardtom.propwash.input.client.FunctionKeys;
import de.lardtom.propwash.input.client.KeyDefaults;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(targets = "de.lardtom.propwash.input.client.screen.ModesTab$Row")
public enum MixinModesTab {
    PWNOCLIP_NOCLIP(SwitchFunction.valueOf("PWNOCLIP_NOCLIP"), new KeyDefaults.Entry("noclip", 0, false, false));

    @Shadow
    MixinModesTab(@Nullable SwitchFunction function, KeyDefaults.Entry key) {
    }
}
