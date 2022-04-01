package com.etiya.rentACar.business.requests.additionalServiceRequest;

import com.etiya.rentACar.business.responses.additionalServiceResponses.AdditionalServiceDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteAdditionalServiceRequest {

	private int id;
}
