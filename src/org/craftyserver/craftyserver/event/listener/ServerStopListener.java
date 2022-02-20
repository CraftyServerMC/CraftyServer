package org.craftyserver.craftyserver.event.listener;

import org.craftyserver.craftyserver.event.events.ServerStopEvent;
import org.craftyserver.general.event.Listener;

/**
 * Listener Interface implemented by classes which have subscribed to {@link ServerStopEvent}
 * 
 * <p> Managed by {@link org.craftyserver.general.event.EventManager EventManager} 
 * initialized in {@link org.craftyserver.craftyserver.main.CraftyServer CraftyServer}.
 * 
 * @author PentagonLP
 */
// TODO move all server and connection related stuff to own "server.jar" module
public interface ServerStopListener extends Listener {
	
	/**
	 * Method called by {@link org.craftyserver.general.event.EventManager EventManager} when {@link ServerStopEvent} occurs
	 * 
	 * @param	event	the occurred {@link ServerStopEvent}
	 */
	public void onServerStop(ServerStopEvent event);

}
