/**
 * 
 */
package org.forcast.app.config;

import org.forcast.app.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Wajid Ali
 *
 * Dec 27, 2021
 */
@PropertySources({
    @PropertySource("classpath:weather.properties")
})
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Configuration
public class PropertiesConfig {
	
	@Value("${org.forcast.app.api.key}")
	private String apiKey;
	
	@Value("${org.forcast.app.api.weather.by.name}")
	private String weatherByNameUrl;
	

	@Value("${org.forcast.app.api.weather.by.name.and.code}")
	private String weatherByNameAndCodeUrl;
	
	@Value("${org.forcast.app.api.weather.by.coordinates}")
	private String weatherByCoordinatesUrl;
}
