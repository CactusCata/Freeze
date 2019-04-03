package fr.cactuscata.freeze.commands.other;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.cactuscata.freeze.Freeze;

public class FreezeCmd implements CommandExecutor {

	private static final List<Player> map = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (args.length == 0) {
			sender.sendMessage(Freeze.freezePrefix + "Veuillez préciser un joueur ! ");
			return true;
		}

		final Player player = Bukkit.getPlayerExact(args[0]);
		if (player == null || !player.isOnline()) {
			sender.sendMessage(Freeze.freezePrefix + "Le joueur " + args[0] + " n'est pas connecté !");
			return true;
		}

		if (map.contains(player)) {
			map.remove(player);
			sender.sendMessage(Freeze.freezePrefix + "Le joueur " + args[0] + " n'est plus freeze !");
			player.sendMessage(Freeze.freezePrefix + "Vous n'êtes plus freeze !");
		} else {
			map.add(player);
			sender.sendMessage(Freeze.freezePrefix + "Le joueur " + args[0] + " a bien été freeze !");
			player.sendMessage(Freeze.freezePrefix + "Vous êtes freeze !");
		}

		return true;
	}

	public static final List<Player> getMap() {
		return map;
	}

}
