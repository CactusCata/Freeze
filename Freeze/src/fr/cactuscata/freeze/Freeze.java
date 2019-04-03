package fr.cactuscata.freeze;

import org.bukkit.plugin.java.JavaPlugin;

import fr.cactuscata.freeze.commands.other.FreezeCmd;
import fr.cactuscata.freeze.listeners.Move;

public class Freeze extends JavaPlugin {
	
	public static final String freezePrefix = "§1[§cFreeze§1] ";

	public final void onEnable(){
		getCommand("freeze").setExecutor(new FreezeCmd());
		getServer().getPluginManager().registerEvents(new Move(), this);
	}
	
}
