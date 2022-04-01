package com.etiya.rentACar.business.requests.additionalServiceRequest;

import javax.validation.constraints.NotNull;

import com.etiya.rentACar.business.responses.additionalServiceResponses.AdditionalServiceDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateAdditionalServiceRequest {
	@JsonIgnore
	private int id;
	@NotNull
	private String name;
	private double dailyPrice;

}
