package com.pms.authorization.repository;

import org.springframework.data.repository.CrudRepository;

import com.pms.authorization.models.AuthenticationRequest;

public interface AuthenticationRepository extends CrudRepository<AuthenticationRequest, String> {

}
