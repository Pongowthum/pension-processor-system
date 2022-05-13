package com.pms.processpension.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pms.processpension.controller.CalculatePension;

public class CalculatePensionTest {

	@Test
	public void testBankChargeForPublic() {
		assertEquals(500, CalculatePension.calculateBankServiceCharge("public"));
	}
	
	@Test
	public void testBankChargeForPrivate() {
		assertEquals(550, CalculatePension.calculateBankServiceCharge("private"));
	}
	
	@Test
	public void testBankChargeForWrongInput() {
		assertEquals(-1, CalculatePension.calculateBankServiceCharge("something"));
	}
	
	@Test
	public void testSelfPension() {
		double epsilon = 0.000001d;
		double expected = 0.8*29000+1200;
		double actual=CalculatePension.calculatePension("self", 29000, 1200);
		double difference = actual-expected;
		assertEquals(true, difference<epsilon);
	}
	
	@Test
	public void testfamilyPension() {
		double epsilon = 0.000001d;
		double expected = 0.5*29000+1200;
		double actual=CalculatePension.calculatePension("family", 29000, 1200);
		double difference = expected-actual;
		assertTrue(difference<epsilon);
	}
	
	@Test
	public void testOPension() {
		double v=0;
		assertEquals(0 , (int)CalculatePension.calculatePension("others", 29000, 1200));
	}


}
