/**
 * 
 */
package org.forcast.app.controller;

import java.util.List;

import org.forcast.app.dto.ResponseDto;
import org.forcast.app.dto.UserDto;
import org.forcast.app.enums.ForcastEnum.StatusCode;
import org.forcast.app.exception.BusinessException;
import org.forcast.app.service.UserService;
import org.forcast.app.utils.MessagesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * @author Wajid Ali
 *
 * Dec 27, 2021
 */
@RestController
@RequestMapping(value = "api/v1/user")
@Api(tags = "User")
public class UserController {
private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService forcastService;
	
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseDto getAllUser() {
		ResponseDto response = new ResponseDto();
		try {
			log.error("<------- in UserController.getAllUser() --->: ");
			List<UserDto> users = forcastService.getAllUser();
			response.setResponse(users);
			response.setStatusCode(StatusCode.Success.getStatusValue());
			response.setRespMessage(StatusCode.Success.name());
		}catch (BusinessException e) {
			MessagesUtil.constructResponse(response, e);
			
			log.error("<-------Error  in UserController.getAllUser() BusinessException--->: " + e);
		}
		catch (Exception e) {
			MessagesUtil.constructResponse(response, e);
			log.error("<-------Error  in UserController.getAllUser() Exception--->: " + e.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseDto registerUser(@RequestBody @Validated UserDto userDto) {
		ResponseDto response = new ResponseDto();
		try {
			UserDto users = forcastService.registerUser(userDto);
			response.setResponse(users);
			response.setStatusCode(StatusCode.Success.getStatusValue());
			response.setRespMessage(StatusCode.Success.name());
		}catch (BusinessException e) {
			MessagesUtil.constructResponse(response, e);
			
			log.error("<-------Error  in UserController.registerUser() BusinessException--->: " + e);
		}
		catch (Exception e) {
			MessagesUtil.constructResponse(response, e);
			log.error("<-------Error  in UserController.registerUser() Exception--->: " + e.getMessage());
		}
		return response;
	}
}
