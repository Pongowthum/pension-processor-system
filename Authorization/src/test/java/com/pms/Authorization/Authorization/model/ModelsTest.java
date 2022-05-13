package com.pms.Authorization.Authorization.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pms.authorization.models.AuthenticationRequest;

public class ModelsTest {
	
	@Test
	public void authenticationRequest() {
		AuthenticationRequest request1=new AuthenticationRequest("admin","admin");
		AuthenticationRequest request2=new AuthenticationRequest();
		request2.setUsername("admin");
		request2.setPassword("admin");
		assertEquals(request1.getUsername(), request2.getUsername());
		assertEquals(request1.getPassword(), request2.getPassword());
		assertEquals(request1.toString(), request2.toString());
	}
	

	

}
