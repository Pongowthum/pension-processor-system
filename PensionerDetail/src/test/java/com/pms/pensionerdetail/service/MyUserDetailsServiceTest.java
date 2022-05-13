package com.pms.pensionerdetail.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.pms.pensionerdetail.model.AuthenticationRequest;

@Service
public class MyUserDetailsServiceTest {
	
	@Test
	public void test_getUserPassword() {
		MyUserDetailsService u= new MyUserDetailsService();
		
		assertEquals("admin", u.getUserPassword("admin"));
		
	}
	
	@Test
	public void test_getUserPassword2() {
		MyUserDetailsService u= new MyUserDetailsService();
		
		assertEquals("Not Found", u.getUserPassword("admi"));
		
	}
	
//	@Test
//	public void test_loadUserByUsername(String username) throws UsernameNotFoundException {
//		User expected = new User("admin", "admin", new ArrayList<>());
//		MyUserDetailsService s= new MyUserDetailsService();
//				
//				assertEquals(expected, s.loadUserByUsername("admin"));
//	}
	

	

}