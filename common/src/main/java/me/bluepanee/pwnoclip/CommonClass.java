package me.bluepanee.pwnoclip;

import de.lardtom.propwash.drone.client.FpvView;
import de.lardtom.propwash.input.RadioState;
import de.lardtom.propwash.input.SwitchFunction;
import net.minecraft.server.commands.GameModeCommand;

import static me.bluepanee.pwnoclip.Constants.MC;

public class CommonClass {
    public static void init() {}

    private static boolean hasPermissions() {
        return MC.canSwitchGameMode() && GameModeCommand.PERMISSION_CHECK.check(MC.player.permissions());
    }

    public static boolean isNoclipActive() {
        boolean isNoclipKeyActive = RadioState.INSTANCE.isActive(SwitchFunction.valueOf("PWNOCLIP_NOCLIP"));
        return isNoclipKeyActive && FpvView.active() && hasPermissions();
    }
}