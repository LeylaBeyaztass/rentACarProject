package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.AdditionalServiceService;
import com.etiya.rentACar.business.requests.additionalServiceRequest.CreateAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequest.DeleteAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequest.UpdateAdditionalServiceRequest;
import com.etiya.rentACar.business.responses.additionalServiceResponses.AdditionalServiceDto;
import com.etiya.rentACar.business.responses.additionalServiceResponses.ListAdditionalServiceDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.AdditionalServiceDao;
import com.etiya.rentACar.entities.AdditionalService;
import com.etiya.rentACar.entities.Brand;

@Service
public class AdditionalServiceManager implements AdditionalServiceService {

	private AdditionalServiceDao additionalServiceDao;
	private ModelMapperService modelMapperService;
	
	
	public AdditionalServiceManager(AdditionalServiceDao additionalServiceDao, ModelMapperService modelMapperService) {
		
		this.additionalServiceDao = additionalServiceDao;
		this.modelMapperService = modelMapperService;
	}


	@Override
	public Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest) {
		AdditionalService additionalService = this.modelMapperService.forRequest().map(createAdditionalServiceRequest, AdditionalService.class);
		this.additionalServiceDao.save(additionalService);

		return new SuccessResult("ADDITIONAL_SERVICE_ADDED");
	}


	@Override
	public DataResult<List<ListAdditionalServiceDto>> getAll() {
		List<AdditionalService> additionalServices = this.additionalServiceDao.findAll();
		List<ListAdditionalServiceDto> response = additionalServices.stream().map(additionalService -> this.modelMapperService.forDto()
		                .map(additionalService, ListAdditionalServiceDto.class))
		        .collect(Collectors.toList());
		return new SuccessDataResult<List<ListAdditionalServiceDto>>(response);
	}


	@Override
	public Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest) {
		AdditionalService additionalService = this.modelMapperService.forRequest().map(updateAdditionalServiceRequest, AdditionalService.class);
		this.additionalServiceDao.save(additionalService);

		return new SuccessResult("ADDITIONAL_SERVICE_UPDATE");
	}


	@Override
	public Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequest) {
		this.additionalServiceDao.deleteById(deleteAdditionalServiceRequest.getId());
		return new SuccessResult("ADDITIONAL_SERVICE_DELETED");
	}


	@Override
	public AdditionalServiceDto getById(int id) {
		AdditionalService result= additionalServiceDao.getById(id);
		AdditionalServiceDto additionalServiceDto=modelMapperService.forRequest().map(result,AdditionalServiceDto.class);
		return additionalServiceDto; 
	}


	
}
