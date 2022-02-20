package org.craftyserver.general.module;

/**
 * Super class for the main class of each module
 * 
 * @author PentagonLP
 */
// TODO move out of "general" to org.craftyserver.craftyserver in the main, runnable jar
// TODO everything. just everything. This is supposed to be the class that is extended by the main class of every module, containg stuff like onEnable(), onDisable() and so on.
public abstract class Module {
	
	/**
	 * Method called once module is being enabled. "Main method" of the module.
	 */
	public abstract void onEnable();
	/**
	 * Method called once module is being disabled.
	 */
	public abstract void onDisable();
}
