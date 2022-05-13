package com.pms.pensionerdetail.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;

import com.pms.pensionerdetail.model.PensionerDetail;
import com.pms.pensionerdetail.repository.PensionerRepository;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

//import List;
//import io.jsonwebtoken.lang.Arrays;

public class LoadPensionerServiceTest {
	
	@Autowired
    MockMvc mockMvc;
	
	@MockBean
	private static PensionerRepository repository;
	
	@Autowired
	private LoadPensionerService service;
	
//	PensionerDetail detail=new PensionerDetail("1", "Nabeel", "03-12-1999", "100", 29000, 1200, "self", "SBI", "1000", "private");
	@Test
	public void GetPensionerDetailByAadhar_IfValid() throws Exception {
		PensionerDetail detail=new PensionerDetail("1", "Nabeel", "03-12-1999", "100", 29000, 1200, "self", "SBI", "1000", "private");
		PensionerRepository r=mock(PensionerRepository.class);
		when(r.findByAadharId("1")).thenReturn(detail);
		when(r.existsById("1")).thenReturn(true);
		LoadPensionerService s=new LoadPensionerService(r);
		assertEquals("1", s.getPensionerDetailByAadhar("1").getAadharId());
	}
	
	@Test(expected=NullPointerException.class)
	public void GetPensionerDetailByAadhar_IfNotValid() throws Exception {
		PensionerDetail detail=new PensionerDetail("1", "Nabeel", "03-12-1999", "100", 29000, 1200, "self", "SBI", "1000", "private");
		PensionerRepository r=mock(PensionerRepository.class);
		when(r.findByAadharId("1")).thenReturn(detail);
		when(r.existsById("1")).thenReturn(false);
		LoadPensionerService s=new LoadPensionerService(r);
		assertEquals(null, s.getPensionerDetailByAadhar("1").getAadharId());
	}

	@Test
	public void test_CSVLoading() throws Exception {
	}
}
