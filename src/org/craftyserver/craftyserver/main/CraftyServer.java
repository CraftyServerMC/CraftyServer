package org.craftyserver.craftyserver.main;

import java.io.IOException;

import org.craftyserver.general.config.ConfigFile;
import org.craftyserver.general.config.ConfigSection;
import org.craftyserver.general.event.EventManager;
import org.craftyserver.general.event.EventManagerCollection;
import org.craftyserver.general.log.Log;
import org.craftyserver.general.log.ansi.AnsiColor;
/**
 * Main class of the Program, containing {@link CraftyServer#main(String []) CraftyServer.main(String[] args)}
 * 
 * <p> Responsible for the startup sequence including setting up the {@link Log Logger}, registering {@link EventManager EventManagers} 
 * and {@link org.craftserver.general.event.Event Events} for the main module, loading the "server.config" {@link ConfigFile} and
 * starting up the main {@link Server}.
 */
public class CraftyServer {
	
	/**
	 * Main list of {@link EventManager EventManagers}
	 */
	private final static EventManagerCollection EVENTMANAGERS = new EventManagerCollection();
	
	/**
	 * The "server.config" {@link ConfigFile}
	 */
	private static ConfigFile configfile;
	
	/**
	 * The main method, responsible for the startup sequence including setting up the {@link Log Logger}, registering {@link EventManager EventManagers} 
	 * and {@link org.craftserver.general.event.Event Events} for the main module, loading the "server.config" {@link ConfigFile} and
	 * starting up the main {@link Server}.
	 * 
	 * @param	args	console arguments passed to the program. This argument is not used.
	 */
	
	public static void main(String[] args) {
		
		Log.log("CraftyServer Startup! Good morning!");
		
		Log.log("Building environment...");
		
		// Init Logger
		AnsiColor.setSystemOutAnsi(true);
		
		Log.registerClassName(CraftyServer.class.getName(), "CraftyServer");
		Log.registerClassName(EventManager.class.getName(), "EventManager");
		
		// Init Config
		Log.log("Loading config...");
		try {
			configfile = new ConfigFile("server.config");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Log.log("Ready to accept connections!");
		
	}
	
	/**
	 * Get main list of {@link EventManager EventManagers}
	 * 
	 * @return	the main list of {@link EventManager EventManagers}
	 */
	public static EventManagerCollection getEventmanagers() {
		return EVENTMANAGERS;
	}
	
	/**
	 * Get the "server.config" {@link ConfigFile}
	 * 
	 * @return	the "server.config" {@link ConfigFile}
	 */
	public static ConfigFile getConfigFile() {
		return configfile;
	}
	
	/**
	 * Get the {@link ConfigSection} of the "server.config" {@link ConfigFile} concerning the main module
	 * 
	 * @return	the {@link ConfigSection} of the "server.config" {@link ConfigFile} concerning the main module
	 */
	public static ConfigSection getMainModuleConfigSection() {
		return configfile.get("CraftyServer");
	}

}
