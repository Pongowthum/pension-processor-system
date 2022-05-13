package com.pms.authorization.services;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.pms.authorization.models.AuthenticationRequest;
import com.pms.authorization.repository.AuthenticationRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService, CommandLineRunner {
	
	@Autowired
	private AuthenticationRepository repositoty;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new User(username,getUserPassword(username),new ArrayList<>());
	}
	
	static List<AuthenticationRequest> csv_objectList=new ArrayList<AuthenticationRequest>();
	
	public static String getUserPassword(String username) {
	
		for(AuthenticationRequest p:csv_objectList){
			if(username.equals(p.getUsername())){
				log.info(username+" logged in");
				return p.getPassword();				
			}
		}
		return "Not Found";
	}
	


	@Override
	public void run(String... args) throws Exception {
		try {
			CSVReader reader = new CSVReaderBuilder(new FileReader("src/main/resources/userCredentials.csv")).build();
			    csv_objectList = reader.readAll().stream().map(data -> {
			    AuthenticationRequest c = new AuthenticationRequest();
			    c.setUsername(data[0]);
			    c.setPassword(data[1]);
			    repositoty.save(c);
			    log.info(c.toString());
				return c;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
