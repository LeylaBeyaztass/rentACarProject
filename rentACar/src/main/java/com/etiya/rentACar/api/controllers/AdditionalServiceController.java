package com.etiya.rentACar.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.AdditionalServiceService;
import com.etiya.rentACar.business.requests.additionalServiceRequest.CreateAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequest.DeleteAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequest.UpdateAdditionalServiceRequest;
import com.etiya.rentACar.business.responses.additionalServiceResponses.AdditionalServiceDto;
import com.etiya.rentACar.business.responses.additionalServiceResponses.ListAdditionalServiceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

@RestController
@RequestMapping("/api/additionalServices")
public class AdditionalServiceController {

	private AdditionalServiceService additionalServiceService;

	public AdditionalServiceController(AdditionalServiceService additionalServiceService) {
		this.additionalServiceService = additionalServiceService;
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody @Valid CreateAdditionalServiceRequest createAdditionalServiceRequest) {
		return this.additionalServiceService.add(createAdditionalServiceRequest);
	}
	
	@PostMapping("/update")
	public Result update (@RequestBody @Valid UpdateAdditionalServiceRequest updateAdditionalServiceRequest) {
		return this.additionalServiceService.update(updateAdditionalServiceRequest);
	}
	
	@PostMapping("/delete")
	public Result delete (@RequestBody @Valid DeleteAdditionalServiceRequest deleteAdditionalServiceRequest) {
		return this.additionalServiceService.delete(deleteAdditionalServiceRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ListAdditionalServiceDto>> getAll() {
		return this.additionalServiceService.getAll();
	}
	
	@GetMapping("/getbyid")
	public AdditionalServiceDto getById(@RequestParam("id") int id) {
		return this.additionalServiceService.getById(id);
	}
	
	
}
