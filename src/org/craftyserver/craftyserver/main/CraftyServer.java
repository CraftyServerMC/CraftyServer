package org.craftyserver.craftyserver.main;

import java.io.IOException;

import org.craftyserver.craftyserver.connectionhandler.Connection;
import org.craftyserver.craftyserver.connectionhandler.ConnectionListener;
import org.craftyserver.craftyserver.event.events.ConnectionClosedEvent;
import org.craftyserver.craftyserver.event.events.ConnectionOpenedEvent;
import org.craftyserver.craftyserver.event.events.PackageRecievedEvent;
import org.craftyserver.craftyserver.event.events.ServerAcceptEvent;
import org.craftyserver.craftyserver.event.events.ServerStartEvent;
import org.craftyserver.craftyserver.event.events.ServerStopEvent;
import org.craftyserver.craftyserver.event.listener.ConnectionClosedListener;
import org.craftyserver.craftyserver.event.listener.ConnectionOpenedListener;
import org.craftyserver.craftyserver.event.listener.PackageRecievedListener;
import org.craftyserver.craftyserver.event.listener.ServerAcceptListener;
import org.craftyserver.craftyserver.event.listener.ServerStartListener;
import org.craftyserver.craftyserver.event.listener.ServerStopListener;
import org.craftyserver.craftyserver.server.Server;
import org.craftyserver.general.config.ConfigFile;
import org.craftyserver.general.config.ConfigSection;
import org.craftyserver.general.event.EventManager;
import org.craftyserver.general.event.EventManagerCollection;
import org.craftyserver.general.log.Level;
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
	 * Default port, if not otherwise specified in the "server.config" {@link ConfigFile}
	 */
	private final static int DEFAULTPORT = 25565;
	
	/**
	 * Main list of {@link EventManager EventManagers}
	 */
	private final static EventManagerCollection EVENTMANAGERS = new EventManagerCollection();
	/**
	 * The main {@link Server}
	 */
	private final static Server SERVER = new Server();
	
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
	@SuppressWarnings("deprecation") // Ignore included testing classes. TODO remove this once testing period is over
	public static void main(String[] args) {
		
		Log.log("CraftyServer Startup! Good morning!");
		
		Log.log("Building environment...");
		
		// Init Logger
		AnsiColor.setSystemOutAnsi(true);
		
		Log.registerClassName(CraftyServer.class.getName(), "CraftyServer");
		Log.registerClassName(EventManager.class.getName(), "EventManager");
		Log.registerClassName(ConnectionListener.class.getName(), "ConnectionListener");
		Log.registerClassName(Connection.class.getName(), "Connection");
		Log.registerClassName(Server.class.getName(), "Server");
		
		// Init EventManagers
		try {
			new EventManager("onServerAccept", ServerAcceptListener.class, ServerAcceptEvent.class);
			new EventManager("onServerStart", ServerStartListener.class, ServerStartEvent.class);
			new EventManager("onServerStop", ServerStopListener.class, ServerStopEvent.class);
			new EventManager("onConnectionOpened", ConnectionOpenedListener.class, ConnectionOpenedEvent.class);
			new EventManager("onConnectionClosed", ConnectionClosedListener.class, ConnectionClosedEvent.class);
			new EventManager("onPackageRecieved", PackageRecievedListener.class, PackageRecievedEvent.class);
		} catch (NoSuchMethodException | SecurityException e) {
			Log.log(Level.FATAL, "Failed to register Event Manager: " + e);
			Log.printStackTrace(e);
			Log.log("Startup aborted.");
			return;
		}
		
		// Init Events
		EVENTMANAGERS.registerAllEvents(new ConnectionListener());
		EVENTMANAGERS.registerAllEvents(new Testlistener());
		
		// Init Config
		Log.log("Loading config...");
		try {
			configfile = new ConfigFile("server.config");
			getMainModuleConfigSection().get("port").setDefaultValue(DEFAULTPORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Start Server
		Log.log("Starting Server on port " + getMainModuleConfigSection().get("serverport").getInt() + "...");
		getServer().start(getMainModuleConfigSection().get("serverport").getInt());
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
	 * Get the main {@link Server}
	 * 
	 * @return	the main {@link Server}
	 */
	public static Server getServer() {
		return SERVER;
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
	
	/**
	 * Get the default port, if no other port is otherwise specified in the "server.config" {@link ConfigFile}
	 * 
	 * @return	the default port of the main {@link Server}
	 */
	public static int getDefaultServerPort() {
		return DEFAULTPORT;
	}

}
