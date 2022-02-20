package org.craftyserver.general.packageparser;

/**
 * Exception that is thrown when the data in the given {@link java.io.InputStream} does not comply with an expected format of a method from {@link DataTypeParser}
 * 
 * @author PentagonLP
 */
// TODO move out of general to org.craftyserver.server; move all server and connection related stuff to own "server.jar" module anyways
public class InvalidDataException extends RuntimeException {
	
	/**
	 * The {@code serialVersionUID}, required as {@link InvalidDataException} extends {@link RuntimeException}
	 */
	private static final long serialVersionUID = 6204934804865653448L;
	
	/**
	 * Creates a new {@link InvalidDataException} with a given error message.
	 * 
	 * @param	message	the error message
	 */
	public InvalidDataException(String message) {
		super(message);
	}
	
}
