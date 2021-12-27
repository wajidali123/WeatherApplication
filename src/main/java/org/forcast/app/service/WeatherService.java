/**
 * 
 */
package org.forcast.app.service;

import org.forcast.app.config.PropertiesConfig;
import org.forcast.app.constant.MessagesCode;
import org.forcast.app.dto.WeatherDto;
import org.forcast.app.exception.BusinessException;
import org.forcast.app.exception.ForcastException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Wajid Ali
 *
 * Dec 27, 2021
 */
@Service
public class WeatherService {
	
	@Autowired
	private PropertiesConfig weatherProperties;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Cacheable(value="getWeatherDetailsByCityName", cacheManager="cacheTimeoutManager")
	public WeatherDto getWeatherDetailsByCityName(String cityName, String countryCode) throws BusinessException, Exception {
		ResponseEntity<String> response = null;
		WeatherDto weatherDetails = new WeatherDto();
		if("".equals(cityName) || "".equals(countryCode)) {
			throw new ForcastException(MessagesCode.EMPTY_CITYNAME);
		}
		else {
			String apiUrl = weatherProperties.getWeatherByNameUrl()+cityName+","+countryCode+"&appid="+weatherProperties.getApiKey();
			try {
				response = restTemplate.getForEntity(apiUrl, String.class);
			} catch (Exception e) {
				throw new ForcastException(MessagesCode.GENERAL_EXCEPTION);
			}
			weatherDetails = new ObjectMapper().readValue(response.getBody(), WeatherDto.class);
			System.out.println(weatherDetails);
		}
		return weatherDetails;
	}
	
	@Cacheable(value="getWeatherDetailsByLatitudeAndLongitude", cacheManager="cacheTimeoutManager")
	public WeatherDto getWeatherDetailsByLatitudeAndLongitude(double latitude, double longitude) throws BusinessException, Exception {
		ResponseEntity<String> response = null;
		WeatherDto weatherDetails = new WeatherDto();
		
		if(0.0d == latitude || 0.0d == longitude) {
			throw new ForcastException(MessagesCode.INCORRECT_COORDINATES);
		}
		else {
			String apiUrl = weatherProperties.getWeatherByCoordinatesUrl()+"lat="+latitude+"&lon="+longitude+"&appid="+weatherProperties.getApiKey();
			try {
				response = restTemplate.getForEntity(apiUrl, String.class);
			} catch (Exception e) {
				throw new BusinessException(MessagesCode.INCORRECT_COORDINATES);
			}
			weatherDetails = new ObjectMapper().readValue(response.getBody(), WeatherDto.class);
			System.out.println(weatherDetails);
		}
		
		return weatherDetails;
	}
}
