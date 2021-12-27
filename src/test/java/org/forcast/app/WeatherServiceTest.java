/**
 * 
 */
package org.forcast.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.forcast.app.dto.WeatherDto;
import org.forcast.app.entity.UserEntity;
import org.forcast.app.exception.BusinessException;
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
}
