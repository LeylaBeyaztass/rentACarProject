package com.etiya.rentACar.business.requests.rentalRequests;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.etiya.rentACar.business.responses.customerResponses.CustomerDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {
	@JsonIgnore
	private int id;
	@NotNull
	private LocalDate rentDate;
	@NotNull
	private LocalDate returnDate;
	@NotNull
	private int rentCityId;
	@NotNull
	private int returnCityId;
	
	@NotNull
	private int carId;
	@NotNull
	private int customerId;
	@NotNull
	private double dailyPrice;
	
}
