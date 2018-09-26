package com.ellirion.introduction;

import com.ellirion.introduction.command.HelloWorld;
import com.ellirion.introduction.groundWars.FriendlyFireListener;
import com.ellirion.introduction.groundWars.Team;
import com.ellirion.introduction.groundWars.Teamstest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.ellirion.introduction.Listener.StickListener;

public class EllirionIntroduction extends JavaPlugin {

    private static EllirionIntroduction INSTANCE;

    Teamstest teamsCommand = new Teamstest();

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
        getCommand("joinred").setExecutor(teamsCommand);
        getCommand("joinblue").setExecutor(teamsCommand);
        getCommand("leavered").setExecutor(teamsCommand);
        getCommand("leaveblue").setExecutor(teamsCommand);
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new StickListener(), this);
        getServer().getPluginManager().registerEvents(new FriendlyFireListener(), this);

    }
}
