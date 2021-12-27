/**
 * 
 */
package org.forcast.app.utils;

import java.util.Locale;

import org.forcast.app.constant.MessagesCode;
import org.forcast.app.dto.ResponseDto;
import org.forcast.app.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Wajid Ali
 *
 * Dec 26, 2021
 */
@Component
public class MessagesUtil {
	private static MessageSourceAccessor accessor;

	private static Environment env;

	@SuppressWarnings("static-access")
	@Autowired
	private void autoWiredEnvironment(Environment env) {
		this.env= env;
	}

	public static String getErrorMessage(String code) {

		try {
			System.out.println(env.getProperty(code));
			return env.getProperty(code+"-message");
		} catch (Exception e) {
			e.printStackTrace();
			return code;
		}

	}

	public static String getErrorDescription(String code) {
		try {
			return env.getProperty(code+"-description");
		} catch (Exception e) {
			e.printStackTrace();
			return code;
		}
	}

	public static String getErrorMessage(String resource,String code,Object[] params) {
		if (accessor == null){
			ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
			messageSource.setBasenames(resource);
			accessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
		}
		return accessor.getMessage(code,new Object[] {params});
	}

	public static String getErrorDescription(String resource,String code,Object[] params) {
		if (accessor == null){
			ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
			messageSource.setBasenames(resource);
			accessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
		}
		return accessor.getMessage(code,new Object[] {params});
	}

	public static void constructResponse(ResponseDto response, Exception exception) {

		if (exception instanceof BusinessException) {
			BusinessException bussexception = (BusinessException)exception;
			String errorCode = String.valueOf(bussexception.getErrorCode());
			response.setStatusCode(Integer.valueOf(errorCode));
			response.setRespMessage(getErrorMessage(errorCode));
			response.setRespDescription(getErrorDescription(errorCode));
		}
		else {
			response.setStatusCode(MessagesCode.GENERAL_EXCEPTION);
			String[] responseMessage = exception.getMessage().split(":");
			response.setRespMessage(responseMessage[0]);
			response.setRespDescription(responseMessage[0]+"->"+getErrorDescription(String.valueOf(MessagesCode.GENERAL_EXCEPTION)));
		}
	}

	public static void constructResponse(ResponseDto response, String errorCode) {

		response.setStatusCode(Integer.valueOf(errorCode));
		response.setRespMessage(getErrorMessage(errorCode));
		response.setRespDescription(getErrorDescription(errorCode));

	}
}
