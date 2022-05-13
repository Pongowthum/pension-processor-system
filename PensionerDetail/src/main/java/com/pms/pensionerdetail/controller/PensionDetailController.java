package com.pms.pensionerdetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pms.pensionerdetail.model.PensionerDetail;
import com.pms.pensionerdetail.service.LoadPensionerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
class PensionDetailController {

	@Autowired
	private LoadPensionerService service;

	@CrossOrigin(origins = "*")
	@RequestMapping("/PensionerDetailByAadhaar/{aadharId}")
	@ApiOperation(value="Get Pensioner By Aadhar",notes="It takes Aadhar number as input and return Pensioner details if the aadhar number and autherization is valid")
	public PensionerDetail getPensionerDetailByAadhar(@ApiParam(value="Unqiue identification key to retrive pensioner",required=true)@PathVariable("aadharId") String aadharId) {
		log.info("Getting Pensioner detail for "+aadharId);
		return service.getPensionerDetailByAadhar(aadharId);
	}
}