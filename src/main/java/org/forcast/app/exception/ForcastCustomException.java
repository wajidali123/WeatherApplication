/**
 * 
 */
package org.forcast.app.exception;

import org.forcast.app.utils.MessagesUtil;

/**
 * @author Wajid Ali
 *
 * Dec 26, 2021
 */
@SuppressWarnings("unused")
public class ForcastCustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3621877257747630793L;
	
	private Throwable cause;
	private int    errorCode;
	private String resource;
	private String    key;
	private Object[]  params;

	public ForcastCustomException() {
		super();
	}

	public ForcastCustomException(String message) {
		super(message);
	}
	/**
	 * Construct exception.
	 *
	 * @param resource resource bundle base name
	 * @param message  exception message, or localization key for actual message
	 * @param params   exception message parameters
	 * @param x        underlying exception
	 */
	protected ForcastCustomException(int errorCode, String message, Exception exception)
	{
		super(message);
		this.errorCode = errorCode;
		this.cause = exception;
	}

	public int getErrorCode() {
		return this.errorCode;
	}

	public String getMessage() {
		return super.getMessage();
	}
	/**
	 * Return underlying exception.
	 * @return underlying exception <b>null</b> if none
	 */
	public Throwable getCause()
	{
		return cause;
	}
	
	private String getFormattedMessage()
	{
		return MessagesUtil.getErrorMessage(this.resource,this.key, this.params);
	}

	private String getFormattedMessageDescription()
	{
		return MessagesUtil.getErrorDescription(this.resource,this.key, this.params);
	}
}
