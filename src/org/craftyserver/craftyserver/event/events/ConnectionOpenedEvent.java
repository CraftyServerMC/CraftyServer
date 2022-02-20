package org.craftyserver.craftyserver.event.events;

import org.craftyserver.craftyserver.connectionhandler.Connection;

/**
 * Event called when a {@link Connection} to a client is opened.
 * 
 * <p> Managed by {@link org.craftyserver.general.event.EventManager EventManager} 
 * initialized in {@link org.craftyserver.craftyserver.main.CraftyServer CraftyServer}.
 * 
 * @author PentagonLP
 */
// TODO move all server and connection related stuff to own "server.jar" module
public class ConnectionOpenedEvent extends ConnectionEvent {
	
	/**
	 * Creates a {@code ConnectionOpenedEvent} by taking in a {@link Connection} and storing it.
	 * 
	 * @param	connection	the {@link Connection} to store in the event
	 */
	public ConnectionOpenedEvent(Connection connection) {
		super(connection);
	}
	
}
