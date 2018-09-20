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
        registerCommands();
        registerEvents();
    }

    private void registerCommands(){
        // name of the command defined in the plugin.yml as string and the class it needs to call.
        getCommand("helloWorld").setExecutor(new HelloWorld());
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new StickListener(), this);
    }
}
