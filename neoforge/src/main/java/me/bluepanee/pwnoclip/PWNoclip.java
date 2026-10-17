package me.bluepanee.pwnoclip;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class PWNoclip {
    public PWNoclip(IEventBus eventBus) {
        CommonClass.init();
    }
}