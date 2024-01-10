package com.ip.DTO;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PolicyDto {
	@Range(min = 1, max = 10, message = "{PolicyDto.policyId}")
	private Integer policyId;
	@NotNull(message = "{PolicyDto.policyName}")
	private String policyName;
	@NotNull(message = "{PolicyDto.policyType}")
	private String policyType;
	@NotNull(message = "{PolicyDto.policyDuration}")
	private String policyDuration;
	@NotNull(message = "{PolicyDto.policyPremium}")
	private Double policyPremium;

	
			
		
			
			
}
