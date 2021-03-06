package fr.mpremont.confirmmenu.managers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;

import fr.mpremont.confirmmenu.MainClass;

public class ConfigManager {
	
	public static boolean checkConfig() {
		
		boolean result = true;
		
		String confv = MainClass.getInstance().getConfig().getString("ConfigVersion");
		if(confv == null || confv == "" || (!confv.contains("#"))) {
			
			Bukkit.getConsoleSender().sendMessage("�b[�eConfirmMenu�b] �cInvalid configuration file !");
			result = false;
			
		}else {
			
			Configuration c = MainClass.getInstance().getConfig();
			String version = c.getString("ConfigVersion").split("#")[0];
			
			if(!version.equalsIgnoreCase("1.0.6")) {
				
				setBasic(c);
				MainClass.getInstance().reloadConfig();
				c = MainClass.getInstance().getConfig();
				
			}
			
			String lang = c.getString("ConfigVersion").split("#")[1];
			String current = c.getString("Language");
			
			if(!lang.equalsIgnoreCase(current)) {
				
				if(current.equalsIgnoreCase("FR")) {
					setFR(c);
				}else if(current.equalsIgnoreCase("ES")) {
					setES(c);
				}else if(current.equalsIgnoreCase("OTHER")) {
					setOTHER(c);
				}else {
					setEN(c);
				}
				
				MainClass.getInstance().reloadConfig();
				
			}
			
		}
		
		return result;
		
	}
	
	private static void setOTHER(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = c.getString("Text.ConfirmMessage");
		if(confirmMessage == null || confirmMessage == "") {
			confirmMessage = "&eAre you sure ?";
		}
		String menuTitle = c.getString("Text.MenuTitle");
		if(menuTitle == null || menuTitle == "") {
			menuTitle = "&8&lCONFIRM";
		}
		String menuConfirm = c.getString("Text.MenuConfirm");
		if(menuConfirm == null || menuConfirm == "") {
			menuConfirm = "&a&lCONFIRM";
		}
		String menuCancel = c.getString("Text.MenuCancel");
		if(menuCancel == null || menuCancel == "") {
			menuCancel = "&c&lCANCEL";
		}
		String newVersion = c.getString("Text.NewVersion");
		if(newVersion == null || newVersion == "") {
			newVersion = "&eA new version of the plugin is available !";
		}
		String updateFail = c.getString("Text.UpdateFail");
		if(updateFail == null || updateFail == "") {
			updateFail = "&cCould not check for updates !";
		}
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			PrintWriter writer = new PrintWriter("./plugins/ConfirmMenu/config.yml");
			writer.println("# ========== Confirm Menu by MaximePremont ==========\n"
					+ "\n"
					+ "# List of commands that require confirmation\n"
					+ "Commands: \""+commands+"\"\n"
					+ "\n"
					+ "# Enable open sound\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# OP players have permission to skip confirmation by default ( confirmmenu.skip )\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Messages ( color codes are valid )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Changing the language will automatically change the configuration on the next reboot\n"
					+ "# Available languages : EN | FR | ES | OTHER\n"
					+ "Language : \"OTHER\"\n"
					+ "# Check for updates and send a message to the console\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Do not touch] Configuration version\n"
					+ "ConfigVersion: 1.0.6#other");
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setES(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = "&eEstas seguro ?";
		String menuTitle = "&8&lCONFIRMAR";
		String menuConfirm = "&a&lCONFIRMAR";
		String menuCancel = "&c&lCANCELAR";
		String newVersion = "&e�Una nueva versi�n del plugin est� disponible!";
		String updateFail = "&c�No se pueden buscar actualizaciones!";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			PrintWriter writer = new PrintWriter("./plugins/ConfirmMenu/config.yml");
			writer.println("# ========== Confirm Menu de MaximePremont ==========\n"
					+ "\n"
					+ "# Lista de comandos que necesitan confirmaci�n\n"
					+ "Commands: \""+commands+"\"\n"
					+ "\n"
					+ "# Activa el sonido de apertura del men�\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# Los jugadores OP tienen permiso para pasar la confirmaci�n ( confirmmenu.skip )\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Mensajes ( los c�digos de colores funcionan )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Cambiar el idioma cambiar� autom�ticamente la configuraci�n en el pr�ximo reinicio\n"
					+ "# Idiomas disponibles : EN | FR | ES | OTHER\n"
					+ "Language : \"ES\"\n"
					+ "# Comprube si hay un actualizaci�n e ind�quela en la consola\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [No modificar] Versi�n de configuraci�n\n"
					+ "ConfigVersion: 1.0.6#es");
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setFR(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = "&e�tes-vous s�r ?";
		String menuTitle = "&8&lCONFIRMATION";
		String menuConfirm = "&a&lCONFIRMER";
		String menuCancel = "&c&lANNULER";
		String newVersion = "&eUne nouvelle version du plugin est disponible !";
		String updateFail = "&cImpossible de v�rifier les mises � jour !";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			PrintWriter writer = new PrintWriter("./plugins/ConfirmMenu/config.yml");
			writer.println("# ========== Confirm Menu par MaximePremont ==========\n"
					+ "\n"
					+ "# Liste des commandes qui ont besoins d'une confirmation\n"
					+ "Commands: \""+commands+"\"\n"
					+ "\n"
					+ "# Activer le son d'ouverture du menu\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# Les joueurs OP ont la permission de passer la confirmation ( confirmmenu.skip )\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Messages ( les codes couleurs fonctionnent )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Changer la langue modifiera automatiquement la configuration au prochain red�marrage\n"
					+ "# Langages disponibles : EN | FR | ES | OTHER\n"
					+ "Language : \"FR\"\n"
					+ "# V�rifier si il y � une mise � jour et l'indiquer dans la console\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Ne pas modifier] Version de la configuration\n"
					+ "ConfigVersion: 1.0.6#fr");
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setEN(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = "&eAre you sure ?";
		String menuTitle = "&8&lCONFIRM";
		String menuConfirm = "&a&lCONFIRM";
		String menuCancel = "&c&lCANCEL";
		String newVersion = "&eA new version of the plugin is available !";
		String updateFail = "&cCould not check for updates !";
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			PrintWriter writer = new PrintWriter("./plugins/ConfirmMenu/config.yml");
			writer.println("# ========== Confirm Menu by MaximePremont ==========\n"
					+ "\n"
					+ "# List of commands that require confirmation\n"
					+ "Commands: \""+commands+"\"\n"
					+ "\n"
					+ "# Enable open sound\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# OP players have permission to skip confirmation by default ( confirmmenu.skip )\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Messages ( color codes are valid )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Changing the language will automatically change the configuration on the next reboot\n"
					+ "# Available languages : EN | FR | ES | OTHER\n"
					+ "Language : \"EN\"\n"
					+ "# Check for updates and send a message to the console\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Do not touch] Configuration version\n"
					+ "ConfigVersion: 1.0.6#en");
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setBasic(Configuration c) {
		
		String commands = c.getString("Commands");
		if(commands == null || commands == "") {
			commands = "stop, reload";
		}
		String openSound = c.getString("OpenSound");
		if(openSound == null || openSound == "") {
			openSound = "true";
		}
		String SkipPermsForOP = c.getString("SkipPermsForOP");
		if(SkipPermsForOP == null || SkipPermsForOP == "") {
			SkipPermsForOP = "false";
		}
		String confirmMessage = c.getString("Text.ConfirmMessage");
		if(confirmMessage == null || confirmMessage == "") {
			confirmMessage = "&eAre you sure ?";
		}
		String menuTitle = c.getString("Text.MenuTitle");
		if(menuTitle == null || menuTitle == "") {
			menuTitle = "&8&lCONFIRM";
		}
		String menuConfirm = c.getString("Text.MenuConfirm");
		if(menuConfirm == null || menuConfirm == "") {
			menuConfirm = "&a&lCONFIRM";
		}
		String menuCancel = c.getString("Text.MenuCancel");
		if(menuCancel == null || menuCancel == "") {
			menuCancel = "&c&lCANCEL";
		}
		String newVersion = c.getString("Text.NewVersion");
		if(newVersion == null || newVersion == "") {
			newVersion = "&eA new version of the plugin is available !";
		}
		String updateFail = c.getString("Text.UpdateFail");
		if(updateFail == null || updateFail == "") {
			updateFail = "&cCould not check for updates !";
		}
		String language = c.getString("Language");
		if(language == null || language == "") {
			language = "EN";
		}
		String updateCheck = c.getString("UpdateCheck");
		if(updateCheck == null || updateCheck == "") {
			updateCheck = "true";
		}
		
		try {
			
			PrintWriter writer = new PrintWriter("./plugins/ConfirmMenu/config.yml");
			writer.println("# ========== Confirm Menu by MaximePremont ==========\n"
					+ "\n"
					+ "# List of commands that require confirmation\n"
					+ "Commands: \""+commands+"\"\n"
					+ "\n"
					+ "# Enable open sound\n"
					+ "OpenSound: "+openSound+"\n"
					+ "# OP players have permission to skip confirmation by default ( confirmmenu.skip )\n"
					+ "SkipPermsForOP: "+SkipPermsForOP+"\n"
					+ "# Messages ( color codes are valid )\n"
					+ "Text:\n"
					+ "    ConfirmMessage: \""+confirmMessage+"\"\n"
					+ "    MenuTitle: \""+menuTitle+"\"\n"
					+ "    MenuConfirm: \""+menuConfirm+"\"\n"
					+ "    MenuCancel: \""+menuCancel+"\"\n"
					+ "    NewVersion: \""+newVersion+"\"\n"
					+ "    UpdateFail: \""+updateFail+"\"\n"
					+ "# Changing the language will automatically change the configuration on the next reboot\n"
					+ "# Available languages : EN | FR | ES | OTHER\n"
					+ "Language : \""+language+"\"\n"
					+ "# Check for updates and send a message to the console\n"
					+ "UpdateCheck: "+updateCheck+"\n"
					+ "\n"
					+ "# [Do not touch] Configuration version\n"
					+ "ConfigVersion: 1.0.6#CREATION");
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
