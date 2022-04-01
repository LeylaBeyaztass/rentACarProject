package com.etiya.rentACar.business.responses.rentalResponses;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RentalDto {

	private int id;
	private LocalDate rentDate;
	private LocalDate returnDate;
	private String rentCity;
	private String returnCity;
	private int carName;
	private int customerName;
	
	
}
