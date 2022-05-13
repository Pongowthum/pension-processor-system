package com.pms.authorization.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class AuthenticationRequest implements Serializable {

	@Id
	private String username;
	private String password;

	public AuthenticationRequest() {
	}

	public AuthenticationRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
}