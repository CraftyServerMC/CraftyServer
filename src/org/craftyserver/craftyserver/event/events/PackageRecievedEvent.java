package org.craftyserver.craftyserver.event.events;

import org.craftyserver.craftyserver.connectionhandler.Connection;
import org.craftyserver.craftyserver.connectionhandler.Package;

/**
 * Event called when a {@link Package} is recieved from the client via a {@link Connection}.
 * 
 * <p> Managed by {@link org.craftyserver.general.event.EventManager EventManager} 
 * initialized in {@link org.craftyserver.craftyserver.main.CraftyServer CraftyServer}.
 * 
 * @author PentagonLP
 */
// TODO move all server and connection related stuff to own "server.jar" module
public class PackageRecievedEvent extends ConnectionEvent {
	
	/**
	 * The stored {@link Package}
	 */
	private final Package _package;
	
	/**
	 * Creates a {@code PackageRecievedEvent} by taking in a {@link Connection} and a {@link Package} and storing it.
	 * 
	 * @param	connection	the {@link Connection} to store in the event
	 * @param	package		the {@link Package} to store in the Event
	 */
	public PackageRecievedEvent(Connection connection, Package _package) {
		super(connection);
		this._package = _package;
		
	}
	
	/**
	 * Get the {@link Package} which is stored as a parameter
	 *
	 * @return	the stored {@link Package}
	 */
	public Package getPackage() {
		return _package;
	}

}
