package com.pms.processpension.repository;

import org.springframework.data.repository.CrudRepository;

import com.pms.processpension.model.PensionDetail;

public interface PensionRepository extends CrudRepository<PensionDetail, String> {

}
