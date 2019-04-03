package fr.cactuscata.freeze.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.cactuscata.freeze.Freeze;
import fr.cactuscata.freeze.commands.other.FreezeCmd;

public class Move implements Listener {

	@EventHandler
	public final void move(PlayerMoveEvent event) {

		if (FreezeCmd.getMap().contains(event.getPlayer())) {
			event.getPlayer().sendMessage(Freeze.freezePrefix + "Vous etes freeze, vous ne pouvez plus bouger");
			event.setCancelled(true);
		}
	}

	@EventHandler
	public final void quit(PlayerQuitEvent event) {
		if (FreezeCmd.getMap().contains(event.getPlayer())) {
			Bukkit.broadcastMessage(Freeze.freezePrefix + "Le joueur " + event.getPlayer().getName()
					+ " s'est déconnecté en étant freeze, il a donc trouvé la mort !");
			event.getPlayer().setHealth(0.0d);
			FreezeCmd.getMap().remove(event.getPlayer());
		}
	}

}
