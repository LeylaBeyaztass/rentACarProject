package com.etiya.rentACar.business.requests.rentalRequests;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
	
	private int id;
	
	private LocalDate rentDate;
	
	private LocalDate returnDate;
	
	private int rentCityId;
	
	private int returnCityId;
	
	
	private int carId;
	
	private int customerId;
	
	private double dailyPrice;
}
