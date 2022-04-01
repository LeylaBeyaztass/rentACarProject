package com.etiya.rentACar.business.responses.rentalResponses;

import java.time.LocalDate;

import com.etiya.rentACar.entities.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ListRentalDto {

	private int id;
	private LocalDate rentDate;
	private LocalDate returnDate;
	private int rentCityId; 
	private int returnCityId; 
	private int carName;
	private int customerName;
	private double dailyPrice;	
	
}
