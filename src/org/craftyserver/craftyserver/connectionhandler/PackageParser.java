package org.craftyserver.craftyserver.connectionhandler;

import java.io.IOException;

/**
 * Interface for package parsers to be able to be used by {@link Connection}.
 * 
 * @author PentagonLP
 */
// TODO move all server and connection related stuff to own "server.jar" module
public interface PackageParser {
	
	/**
	 * Parse a package read from the next Bytes read from {@link BacklogInputStream}
	 * 
	 * @param	input		the BacklogInputStream to read from
	 * @throws	IOException	if reading from {@link BacklogInputStream} fails
	 */
	public Package parseNextPackage(BacklogInputStream input) throws IOException;
	
}
