/**
 * 
 */
package org.forcast.app.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.forcast.app.config.PropertiesConfig;
import org.forcast.app.dto.ResponseDto;
import org.forcast.app.dto.UserDto;
import org.forcast.app.dto.WeatherDto;
import org.forcast.app.enums.ForcastEnum.StatusCode;
import org.forcast.app.exception.BusinessException;
import org.forcast.app.service.UserService;
import org.forcast.app.service.WeatherService;
import org.forcast.app.utils.MessagesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;

/**
 * @author Wajid Ali
 *
 * Dec 26, 2021
 */
@RestController
@RequestMapping(value = "api/v1/forcast")
@Api(tags = "Forcast")
public class ForcastController {

	private static final Logger log = LoggerFactory.getLogger(ForcastController.class);
	
	@Autowired
	private WeatherService weatherService;

	
	
	@RequestMapping(value = "/weather", params = {"city", "countryCode"}, method = RequestMethod.GET)
	public ResponseDto getWeatherDetailsByCityName(@PathParam("city") String city, @PathParam("countryCode") String countryCode) {
		ResponseDto response = new ResponseDto();
		try {
			log.info("<--------------- in getWeatherDetailsByCityName method ----------->");
			WeatherDto weatherByCity = weatherService.getWeatherDetailsByCityName(city,countryCode);
			response.setResponse(weatherByCity);
			response.setStatusCode(StatusCode.Success.getStatusValue());
			response.setRespMessage(StatusCode.Success.name());
		}catch (BusinessException e) {
			MessagesUtil.constructResponse(response, e);
			log.error("<-------Error  in ForcastController.getWeatherDetailsByCityName BusinessException--->: " + e);
		}
		catch (Exception e) {
			MessagesUtil.constructResponse(response, e);
			log.error("<-------Error  in ForcastController.getWeatherDetailsByCityName Exception--->: " + e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/weather/coordinate", params = {"latitude", "longitude"}, method = RequestMethod.GET)
	public ResponseDto getWeatherDetailsByLatAndLon(@PathParam("latitude") double latitude, @PathParam("longitude") double longitude) {
		ResponseDto response = new ResponseDto();
		try {
			log.info("<--------------- in getWeatherDetailsByLatAndLon method ----------->");
			WeatherDto weatherByCity = weatherService.getWeatherDetailsByLatitudeAndLongitude(latitude,longitude);
			response.setResponse(weatherByCity);
			response.setStatusCode(StatusCode.Success.getStatusValue());
			response.setRespMessage(StatusCode.Success.name());
		}catch (BusinessException e) {
			MessagesUtil.constructResponse(response, e);
			log.error("<-------Error  in ForcastController.getWeatherDetailsByLatAndLon BusinessException--->: " + e);
		}
		catch (Exception e) {
			MessagesUtil.constructResponse(response, e);
			log.error("<-------Error  in ForcastController.getWeatherDetailsByLatAndLon Exception--->: " + e.getMessage());
		}
		return response;
	}

}
