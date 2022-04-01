package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.additionalServiceRequest.CreateAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequest.DeleteAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequest.UpdateAdditionalServiceRequest;
import com.etiya.rentACar.business.responses.additionalServiceResponses.AdditionalServiceDto;
import com.etiya.rentACar.business.responses.additionalServiceResponses.ListAdditionalServiceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

public interface AdditionalServiceService {

	Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest);
	DataResult<List<ListAdditionalServiceDto>> getAll();
	Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest);
	Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequest);
	
	AdditionalServiceDto getById(int id);
}
