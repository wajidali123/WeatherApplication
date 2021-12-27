/**
 * 
 */
package org.forcast.app.dto;

import java.util.List;

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
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WeatherByCoordinateDto {
	private CoordinatesDto coord;
	private List<WeatherDetailDto> weather;
	private String base;
	private TempratureDetailsDto main;
	private long visibility;
	private WindDetailsDto wind;
	private CloudDetailsDto cloud;
	private long dt;
}
