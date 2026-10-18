package me.bluepanee.pwnoclip.mixin;

import de.lardtom.propwash.osd.OsdConfig;
import de.lardtom.propwash.osd.OsdElement;
import de.lardtom.propwash.osd.client.OsdRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static me.bluepanee.pwnoclip.CommonClass.isNoclipActive;

@Mixin(OsdRenderer.class)
public abstract class MixinOsdRenderer {
    @Shadow
    protected abstract void text(OsdElement element, OsdConfig.Slot slot, String text, int textColor);

    @Shadow
    protected abstract int caution();

    @Inject(method = "drawElement", at = @At("HEAD"))
    private void pwnoclip$hookDrawElement(OsdElement element, OsdConfig.Slot slot, CallbackInfo ci) {
        if (element.name().equals("PWNOCLIP_NOCLIP") && isNoclipActive()) {
            text(element, slot, "NOCLIP ACTIVE", caution());
        }
    }
}
