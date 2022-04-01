package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.CityService;
import com.etiya.rentACar.business.requests.cityRequests.CreateCityRequest;
import com.etiya.rentACar.business.requests.cityRequests.DeleteCityRequest;
import com.etiya.rentACar.business.requests.cityRequests.UpdateCityRequest;
import com.etiya.rentACar.business.responses.cityResponses.ListCityDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CityDao;
import com.etiya.rentACar.entities.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;
	private ModelMapperService modelMapperService;
	private CarService carService;
	
	public CityManager(CityDao cityDao, ModelMapperService modelMapperService,CarService carService) {
		this.cityDao = cityDao;
		this.modelMapperService = modelMapperService;
		this.carService=carService;
	}


	@Override
	public Result add(CreateCityRequest createCityRequest) {		
		City city = this.modelMapperService.forRequest().map(createCityRequest, City.class);// ilgili alanları mapler
		this.cityDao.save(city);
		return new SuccessResult("CITY_ADDED");
	}

	@Override
	public Result delete(DeleteCityRequest deleteCityRequest) {
		List<City> cities = this.cityDao.findAll();
		List<ListCityDto> response = cities.stream()
				.map(city -> this.modelMapperService.forDto().map(city, ListCityDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<ListCityDto>>(response);	
	}

	@Override
	public Result update(UpdateCityRequest updateCityRequest) {
		City city = this.modelMapperService.forRequest().map(updateCityRequest, City.class);// ilgili alanları mapler
		this.cityDao.save(city);
		return new SuccessResult("CITY_UPDATED");
	}

	@Override
	public DataResult<List<ListCityDto>> getAll() {
		List<City> cities = this.cityDao.findAll();
		List<ListCityDto> response = cities.stream()
				.map(city -> this.modelMapperService.forDto().map(city, ListCityDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<ListCityDto>>(response);
	}

}
