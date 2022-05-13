package com.pms.processpension.security;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.pms.processpension.model.AuthenticationRequest;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new User(username,getUserPassword(username),new ArrayList<>());
	}
	
	public static String getUserPassword(String username) {
		List<AuthenticationRequest> userlist=parse();
		for(AuthenticationRequest p:userlist){
			if(username.equals(p.getUsername())){
				return p.getPassword();
			}
		}
		return "Not Found";
	}
	
	public static List<AuthenticationRequest> parse() {
		List<AuthenticationRequest> csv_objectList=new ArrayList<AuthenticationRequest>();
		try {
			CSVReader reader = new CSVReaderBuilder(new FileReader("src/main/resources/userCredentials.csv")).build();
			    csv_objectList = reader.readAll().stream().map(data -> {
			    AuthenticationRequest c = new AuthenticationRequest();
			    c.setUsername(data[0]);
			    c.setPassword(data[1]);
				return c;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return csv_objectList;
	}

}
