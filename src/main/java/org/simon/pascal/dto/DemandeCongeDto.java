package org.simon.pascal.dto;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Maps;

import lombok.Data;

/**
 * 
 * @author simon.pascal.ngos
 *
 */
@Data
public class DemandeCongeDto {
  @NotNull
  @Min(1)
  private Long numberOfDays;
  @NotNull
  @Future
  private Date startDate;
  @Length(min=3)
  private String vacationMotivation;
  
  
public Map<String, Object> make() {
	Map<String, Object> map=Maps.newHashMap();
	map.put("numberOfDays", numberOfDays);
	map.put("vacationMotivation", vacationMotivation);
	map.put("startDate", startDate);
	return Collections.unmodifiableMap(map);
}
  
}
