/**
 * 
 */
package org.forcast.app.exception;

import org.forcast.app.constant.MessagesCode;

/**
 * @author Wajid Ali
 *
 * Dec 26, 2021
 */
public class ForcastException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param errorCode
	 */
	public ForcastException(int errorCode) {
		super(errorCode);
		// TODO Auto-generated constructor stub
	}

}
