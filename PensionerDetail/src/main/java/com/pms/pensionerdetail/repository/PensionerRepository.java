package com.pms.pensionerdetail.repository;

import org.springframework.data.repository.CrudRepository;

import com.pms.pensionerdetail.model.PensionerDetail;

public interface PensionerRepository extends CrudRepository<PensionerDetail, String> {
	PensionerDetail findByAadharId(String aadharid);
}
