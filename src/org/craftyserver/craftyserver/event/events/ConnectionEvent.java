package org.craftyserver.craftyserver.event.events;

import org.craftyserver.craftyserver.connectionhandler.Connection;
import org.craftyserver.general.event.Event;

/**
 * Superclass for all {@link Event Events} that have a {@link Connection} as a parameter
 * 
 * @author PentagonLP
 */
// TODO move all server and connection related stuff to own "server.jar" module
public abstract class ConnectionEvent extends Event {
	
	/**
	 * The stored {@link Connection}
	 */
	private final Connection connection;
	
	/**
	 * Creates a {@code ConnectionEvent} by taking in a {@link Connection} and storing it.
	 * 
	 * @param	connection	the {@link Connection} to store in the event
	 */
	protected ConnectionEvent(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Get the {@link Connection} which is stored as a parameter
	 *
	 * @return	the stored {@link Connection}
	 */
	public Connection getConnection() {
		return connection;
	}
	
}
