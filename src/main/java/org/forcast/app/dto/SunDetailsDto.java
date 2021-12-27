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
public class SunDetailsDto {
	private int type;
	private long id;
	private String country;
	private long sunrise;
	private long sunset;
}
