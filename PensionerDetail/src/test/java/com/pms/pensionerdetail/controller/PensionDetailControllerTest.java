//package com.pms.pensionerdetail.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.pms.pensionerdetail.model.PensionerDetail;
//import com.pms.pensionerdetail.service.LoadPensionerService;
//
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import lombok.extern.slf4j.Slf4j;
//import java.util.Arrays;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.skyscreamer.jsonassert.JSONAssert;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//@Slf4j
//@RestController
//@RequestMapping("/PensionerDetailByAadhaar")
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = PensionDetailController.class)
////@WithMockUser
//class PensionDetailControllerTest {
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@MockBean
//	private LoadPensionerService service;
//
//	
//}