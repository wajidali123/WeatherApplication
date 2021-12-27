/**
 * 
 */
package org.forcast.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TempratureDetailsDto {
	private float temp;
	private float feels_like;
	private float temp_min;
	private float temp_max;
	private int pressure;
	private int humidity;
	private long sea_level;
	private long grnd_level;
}
