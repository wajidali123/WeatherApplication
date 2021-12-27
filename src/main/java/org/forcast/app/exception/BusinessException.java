/**
 * 
 */
package org.forcast.app.exception;

/**
 * @author Wajid Ali
 *
 * Dec 26, 2021
 */
public class BusinessException extends ForcastCustomException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2827469721808470693L;

	public BusinessException(String message) {
		super(message);
	}
	
	/**
	 * Construct exception.
	 * 
	 * @param key
	 *            location key for exception message
	 */	
	public BusinessException(int errorCode) {
		this(errorCode, null, null);
	}

	


	/**
	 * Construct exception.
	 * 
	 * @param key
	 *            location key for exception message
	 * @param params
	 *            exception message parameters
	 */
	public BusinessException(int errorCode,String message) {
		this(errorCode,message, null);
	}

	/**
	 * Construct exception.
	 * 
	 * @param key
	 *            location key for exception message
	 * @param param
	 *            exception message parameter
	 * @param x
	 *            underlying exception
	 */
	public BusinessException(int errorCode,String message, Exception e) {
		super(errorCode,message, e);
	}
	
}
