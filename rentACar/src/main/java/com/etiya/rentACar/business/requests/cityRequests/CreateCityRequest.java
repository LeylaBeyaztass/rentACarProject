package com.etiya.rentACar.business.requests.cityRequests;

import javax.validation.constraints.NotNull;

import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.entities.CarStates;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateCityRequest {
	
	@JsonIgnore
	private int id;
	@NotNull
	private String name;;
//	@NotNull
//	private int carId;
	
}
