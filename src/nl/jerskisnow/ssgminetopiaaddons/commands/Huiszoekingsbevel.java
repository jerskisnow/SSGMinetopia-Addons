package nl.jerskisnow.ssgminetopiaaddons.commands;

import nl.jerskisnow.ssgminetopiaaddons.Main;
import nl.jerskisnow.ssgminetopiaaddons.utils.Boekjes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class Huiszoekingsbevel implements CommandExecutor {

    Main main;

    public Huiszoekingsbevel(Main plugin) {
    	main = plugin;
    }

	private Boekjes bj = new Boekjes();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		if (sender.hasPermission("ssgminetopia.politie")) {
			Player p = (Player) sender;

			if (args.length >= 2) {
				String agr = "";
				for (int i = 1; i != args.length; i++) {
					agr = agr + args[i] + " ";
				}

				bj.huiszoekingsbevel(p, args[0], agr);

				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3Je hebt succesvol een huiszoekingsbevel aangemaakt voor &b" + args[0] + "&3!"));
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3Gebruik: &b/huiszoekingsbevel <Plot> <Reden>"));
			}
		} else {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("NoPermissions")));
		}
		return true;
	}

}
