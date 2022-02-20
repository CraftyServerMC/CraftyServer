package org.craftyserver.craftyserver.connectionhandler;

import org.craftyserver.craftyserver.event.events.ServerAcceptEvent;
import org.craftyserver.craftyserver.event.listener.ServerAcceptListener;

/**
 * Listener waiting for {@link ServerAcceptEvent} and initializing {@link Connection}
 * 
 * @author PentagonLP
 */
// TODO move all server and connection related stuff to own "server.jar" module
public class ConnectionListener implements ServerAcceptListener {
	
	/**
	 * Methode called by {@link ServerAcceptListener}. Initializes new {@link Connection}
	 * 
	 * @param	event	the event, given by the {@link org.craftyserver.general.event.EventManager}
	 */
	@Override
	public void onServerAccept(ServerAcceptEvent event) {
		
		new Connection(event.getServer(), event.getSocket());
		
	}

}
