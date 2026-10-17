package me.bluepanee.pwnoclip;

import de.lardtom.propwash.drone.client.FpvView;
import de.lardtom.propwash.input.RadioState;
import de.lardtom.propwash.input.SwitchFunction;

public class CommonClass {
    public static void init() {}

    public static boolean isNoclipActive() {
        return RadioState.INSTANCE.isActive(SwitchFunction.valueOf("PWNOCLIP_NOCLIP")) && FpvView.active();
    }
}