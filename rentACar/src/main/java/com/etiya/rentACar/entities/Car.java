package com.etiya.rentACar.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cars")
@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="dailyPrice")
	private double dailyPrice;
	
	@Column(name="description")
	private String description;
	
	@Column(name="modelYear")
	private double modelYear;
	
	@Column(name="carState")
	private CarStates carState;

	
	@ManyToOne
	@JoinColumn(name="color_id")
	private Color color;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	

	@OneToMany(mappedBy = "car")
	private List<CarDamage>carDamages;
	
	@OneToMany(mappedBy = "car") //maintanence içindeki car ile mapli
	private List<CarMaintenance> carMaintenances;
	
	@OneToMany(mappedBy = "car")
	private List<Rental> rentals;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	

	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
}
