package com.pms.processpension.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pms.processpension.model.PensionDetail;
import com.pms.processpension.model.PensionerDetail;
import com.pms.processpension.model.ProcessPensionInput;
import com.pms.processpension.repository.PensionRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ProcessPension")
public class ProcessPensionController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PensionRepository repository;

	
	@RequestMapping(value="/{processPensionInput}", method=RequestMethod.GET)
	public PensionDetail processPentionByAadhar(
			@PathVariable("processPensionInput") ProcessPensionInput processPensionInput, HttpServletRequest request) {

		HttpHeaders headers = new HttpHeaders();
		final String authorizationHeader = request.getHeader("Authorization");
		String token = authorizationHeader.substring(7);
		headers.set("Authorization", "Bearer " + token);

		String aadharId = processPensionInput.getAadharId();
		PensionerDetail detail=new PensionerDetail();
		HttpEntity<PensionerDetail> requestEntity = new HttpEntity<>(detail,headers);

		PensionerDetail p = restTemplate.postForObject("http://pensioner-detail-service/PensionerDetailByAadhaar/" + aadharId,
				requestEntity, PensionerDetail.class);
		double pensionAmount = CalculatePension.calculatePension(p.getSelfOrFamily(), p.getLastSalary(),
				p.getAllowances());
		int bankServiceCharge = CalculatePension.calculateBankServiceCharge(p.getPublicOrPrivateBank());
		PensionDetail details = new PensionDetail(aadharId, pensionAmount, bankServiceCharge);
		repository.save(details);
		return details;

	}

}
