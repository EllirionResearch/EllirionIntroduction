package com.ellirion.introduction;

import com.ellirion.introduction.command.HelloWorld;
import org.bukkit.plugin.java.JavaPlugin;
import com.ellirion.introduction.Listener.StickListener;

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

        getServer().getPluginManager().registerEvents(new StickListener(), this);
    }

    private void registerCommands(){
        getCommand("helloWorld").setExecutor(new HelloWorld());
    }
}
