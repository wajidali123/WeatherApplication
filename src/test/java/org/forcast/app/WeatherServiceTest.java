/**
 * 
 */
package org.forcast.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.forcast.app.constant.MessagesCode;
import org.forcast.app.dto.WeatherDto;
import org.forcast.app.entity.UserEntity;
import org.forcast.app.exception.BusinessException;
import org.forcast.app.exception.ForcastException;
import org.forcast.app.repository.UserRepository;
import org.forcast.app.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Wajid Ali
 *
 * Dec 27, 2021
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherServiceTest {
	
	@Autowired
	private WeatherService weatherService;
	
	@Test
	public void checkCityNameIsNotNull() throws BusinessException, Exception {
		WeatherDto weatherDto = weatherService.getWeatherDetailsByCityName("Islamabad", "PK");
		assertThat(weatherDto.getName()).isNotEmpty();
		assertThat(weatherDto.getSys().getCountry()).isNotEmpty();
	}
	
	@Test
	public void checkLatAndLonIsNotNull() throws BusinessException, Exception {
		WeatherDto weatherDto = weatherService.getWeatherDetailsByLatitudeAndLongitude(33.7104, 73.1338);
		assertThat(weatherDto.getCoord()).isNotNull();
	}
	
	@Test(expected = ForcastException.class)
	public void emptycityandNameValidation() {
		//Exception exception = (Exception) when(weatherService.getWeatherDetailsByCityName("", "")).thenThrow(new ForcastException(MessagesCode.EMPTY_CITYNAME));
		try {
			weatherService.getWeatherDetailsByCityName("", "");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			assertEquals(MessagesCode.EMPTY_CITYNAME, e.getErrorCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected = ForcastException.class)
	public void emptyLatAndLonValidation() {
		//Exception exception = (Exception) when(weatherService.getWeatherDetailsByCityName("", "")).thenThrow(new ForcastException(MessagesCode.EMPTY_CITYNAME));
		try {
			weatherService.getWeatherDetailsByLatitudeAndLongitude(0.0d,0.0d );
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			assertEquals(MessagesCode.INCORRECT_COORDINATES, e.getErrorCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
