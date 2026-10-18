package me.bluepanee.pwnoclip;

import com.mojang.brigadier.CommandDispatcher;
import de.lardtom.propwash.drone.client.FpvView;
import de.lardtom.propwash.input.RadioState;
import de.lardtom.propwash.input.SwitchFunction;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;

import static me.bluepanee.pwnoclip.Constants.MC;

public class CommonClass {
    public static void init() {}

    public static boolean canUseNoclip() {
        CommandDispatcher<ClientSuggestionProvider> clientSuggestionProvider = MC.getConnection().getCommands();
        return clientSuggestionProvider.getRoot().getChild("gamemode") != null || MC.hasSingleplayerServer();
    }

    public static boolean isNoclipActive() {
        boolean isNoclipKeyActive = RadioState.INSTANCE.isActive(SwitchFunction.valueOf("PWNOCLIP_NOCLIP"));
        return isNoclipKeyActive && FpvView.active() && canUseNoclip();
    }
}