package org.craftyserver.general.log.writer;

import org.craftyserver.general.log.Log;
import org.craftyserver.general.log.LogWriter;

/**
 * Super class for all writers that only print {@link Exception Exceptions} in debug mode.
 * This feature can be turned on and off using {@link ExceptionOnlyInDebugModeLogWriter#setExceptionOnlyInDebugMode(boolean)}.
 * 
 * @author PentagonLP
 */
public abstract class ExceptionOnlyInDebugModeLogWriter implements LogWriter {
	
	/**
	 * Default value whether {@link Exception Exceptions} should only be written in debug mode
	 * @see	ExceptionOnlyInDebugModeLogWriter#setExceptionOnlyInDebugMode(boolean)
	 */
	private static final boolean DEFAULTEXCEPTIONONLYINDEBUGMODE = true;
	
	/**
	 * If {@code true}, {@link Exception Exceptions} are only written in debug mode. If {@code false}, {@link Exception Exceptions} are always written
	 * 
	 * @see	ExceptionOnlyInDebugModeLogWriter#setExceptionOnlyInDebugMode(boolean)
	 */
	private boolean exceptiononlyindebugmode;
	
	/**
	 * Creates a new {@link ExceptionOnlyInDebugModeLogWriter}, implementing a check whether {@link Exception Exceptions} should only be written in debug mode.
	 */
	public ExceptionOnlyInDebugModeLogWriter() {
		this(DEFAULTEXCEPTIONONLYINDEBUGMODE);
	}
	
	/**
	 * Creates a new {@link ExceptionOnlyInDebugModeLogWriter}, implementing a check whether {@link Exception Exceptions} should only be written in debug mode.
	 * {@code exceptiononlyindebugmode} describes, whether the check is active or {@link Exception Exceptions} should also be written if 
	 * {@link Log} id not in debug mode.
	 * 
	 * @param	exceptiononlyindebugmode	{@code true} if the check should be enabled, {@code false} if disabled
	 * @see									ExceptionOnlyInDebugModeLogWriter#setExceptionOnlyInDebugMode(boolean)
	 */
	public ExceptionOnlyInDebugModeLogWriter(boolean exceptiononlyindebugmode) {
		this.exceptiononlyindebugmode = exceptiononlyindebugmode;
	}
	
	/**
	 * Override {@link LogWriter#printStackTrace(Exception)}, to implement the check if needed.
	 * 
	 * @param	e	the {@link Exception} to print the {@code StackTrace} of
	 * @see			{@link ExceptionOnlyInDebugModeLogWriter#printStackTraceAfterCheck(Exception)} <i>the method called if the check was successful and the 
	 * 				{@code StackTrace} should be printed by the {@link LogWriter} extending {@link ExceptionOnlyInDebugModeLogWriter}</i>
	 */
	@Override
	public final void printStackTrace(Exception e) {
		if (!Log.isDebugmode()&&exceptiononlyindebugmode) return;
		printStackTraceAfterCheck(e);
	}
	
	/**
	 * The method called if the check was successful and the {@code StackTrace} should be printed by the {@link LogWriter} extending 
	 * {@link ExceptionOnlyInDebugModeLogWriter}
	 * 
	 * @param	e	the {@link Exception} to print the {@code StackTrace} of
	 */
	protected abstract void printStackTraceAfterCheck(Exception e);
	
	/**
	 * Get whether the check is active.
	 * 
	 * @return	{@code boolean}: If {@code true}, {@link Exception Exceptions} are only written in debug mode. If {@code false}, {@link Exception Exceptions} 
	 * 			are always written
	 * @see		ExceptionOnlyInDebugModeLogWriter#setExceptionOnlyInDebugMode(boolean)
	 */
	public boolean getExceptionOnlyInDebugMode() {
		return exceptiononlyindebugmode;
	}
	
	/**
	 * Set whether the check is active.
	 * 
	 * @param	exceptiononlyindebugmode	If {@code true}, {@link Exception Exceptions} are only written in debug mode. If {@code false}, {@link Exception Exceptions} 
	 * 										are always written
	 * @see									ExceptionOnlyInDebugModeLogWriter#getExceptionOnlyInDebugMode()
	 */
	public void setExceptionOnlyInDebugMode(boolean exceptiononlyindebugmode) {
		this.exceptiononlyindebugmode = exceptiononlyindebugmode;
	}

}
