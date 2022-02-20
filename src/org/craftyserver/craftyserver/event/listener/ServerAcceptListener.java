package org.craftyserver.craftyserver.event.listener;

import org.craftyserver.craftyserver.event.events.ServerAcceptEvent;
import org.craftyserver.general.event.Listener;

/**
 * Listener Interface implemented by classes which have subscribed to {@link ServerAcceptEvent}
 * 
 * <p> Managed by {@link org.craftyserver.general.event.EventManager EventManager} 
 * initialized in {@link org.craftyserver.craftyserver.main.CraftyServer CraftyServer}.
 * 
 * @author PentagonLP
 */
// TODO move all server and connection related stuff to own "server.jar" module
public interface ServerAcceptListener extends Listener {
	
	/**
	 * Method called by {@link org.craftyserver.general.event.EventManager EventManager} when {@link ServerAcceptEvent} occurs
	 * 
	 * @param	event	the occurred {@link ServerAcceptEvent}
	 */
	public void onServerAccept(ServerAcceptEvent event);
	
}
