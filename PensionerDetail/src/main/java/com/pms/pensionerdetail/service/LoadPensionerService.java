package com.pms.pensionerdetail.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.pms.pensionerdetail.model.PensionerDetail;
import com.pms.pensionerdetail.repository.PensionerRepository;

import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoadPensionerService implements CommandLineRunner {
	
	@Autowired
	private PensionerRepository repository;

	static List<PensionerDetail> pensionerDetail = new ArrayList<PensionerDetail>();
	
	LoadPensionerService(PensionerRepository repository){
		this.repository=repository;		
	}
	LoadPensionerService(){
	}

	
	
	public PensionerDetail getPensionerDetailByAadhar(String aadharid) {
		PensionerDetail detail = new PensionerDetail();
		if(repository.existsById(aadharid)){
			detail = repository.findByAadharId(aadharid);
			log.info("Pensioner details found for "+aadharid);
		}
		else{
			log.info("No details found for "+aadharid);
			return null;
		}
		return detail;
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			CSVReader reader = new CSVReaderBuilder(new FileReader("src/main/resources/PensionerDetail.csv")).build();
			log.info("Reading Pensionors data");
			pensionerDetail = reader.readAll().stream().map(data -> {
				PensionerDetail c = new PensionerDetail();
				c.setAadharId(data[0]);
				c.setPensionerName(data[1]);
				c.setDateOfBirth(data[2]);
				c.setPanNumber(data[3]);
				c.setLastSalary(Integer.parseInt(data[4]));
				c.setAllowances(Integer.parseInt(data[5]));
				c.setSelfOrFamily(data[6]);
				c.setBankName(data[7]);
				c.setAccountNumber(data[8]);
				c.setPublicOrPrivateBank(data[9]);
				log.info(c.toString());
				repository.save(c);
				return c;
			}).collect(Collectors.toList());
			log.info("Pensionors data loaded into memory");
		} catch (IOException e) {
			log.info("Failed to load Pensioner data into memory");
			e.printStackTrace();
		}		
	}
}