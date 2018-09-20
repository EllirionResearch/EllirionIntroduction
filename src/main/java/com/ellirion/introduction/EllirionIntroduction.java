package com.ellirion.introduction;

import org.bukkit.plugin.java.JavaPlugin;

public class EllirionIntroduction extends JavaPlugin {

    private static EllirionIntroduction INSTANCE;

    /**
     * Constructor to set instance.
     */
    public EllirionIntroduction() {
        super();

        INSTANCE = this;
    }

    /**
     * @return BuildFramework instance
     */
    public static EllirionIntroduction getInstance() {
        return INSTANCE;
    }

    @Override
    public void onDisable() {
        getLogger().info("Introduction is disabled.");
    }

    @Override
    public void onEnable() {
        getLogger().info("Introduction is enabled.");
    }
}
