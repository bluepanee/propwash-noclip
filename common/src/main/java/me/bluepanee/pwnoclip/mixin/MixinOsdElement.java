package me.bluepanee.pwnoclip.mixin;

import de.lardtom.propwash.osd.OsdElement;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(OsdElement.class)
public enum MixinOsdElement {
    PWNOCLIP_NOCLIP(15, 11, OsdElement.Align.CENTER, true, true, OsdElement.Group.STATUS);

    @Shadow
    @Final
    private int baseCol;

    @Shadow
    private MixinOsdElement(int baseCol, int baseRow, OsdElement.Align align, boolean classicEnabled, boolean movable, OsdElement.Group group) {
    }
}
