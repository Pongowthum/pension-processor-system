package com.pms.authorization.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.authorization.models.AuthenticationRequest;
import com.pms.authorization.models.AuthenticationResponse;
import com.pms.authorization.services.MyUserDetailsService;
import com.pms.authorization.util.JwtUtil;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtilToken;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username/Password" + e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtilToken.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
