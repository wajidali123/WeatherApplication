/**
 * 
 */
package org.forcast.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {
	private CoordinatesDto coord;
	private List<WeatherDetailDto> weather;
	private String base;
	private TempratureDetailsDto main;
	private long visibility;
	private WindDetailsDto wind;
	private RainDetailsDto rain;
	private CloudDetailsDto cloud;
	private long dt;
	private SunDetailsDto sys;
	private int timezone;
	private long id;
	private String name;
	private String cod;
	
}
