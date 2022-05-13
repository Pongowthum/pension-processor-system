package com.pms.processpension.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModelsTest {

	@Test
	public void testPensionerDetailPositive() {
		PensionerDetail detail1=new PensionerDetail();
		PensionerDetail detail2=new PensionerDetail("1", "Nabeel", "03-12-1999", "100", 29000, 1200, "self", "SBI", "1000", "private");
		PensionerDetail detail3=new PensionerDetail();
		detail3.setAadharId("1");
		detail3.setPensionerName("Nabeel");
		detail3.setDateOfBirth("03-12-1999");
		detail3.setPanNumber("100");
		detail3.setLastSalary(29000);
		detail3.setAllowances(1200);
		detail3.setSelfOrFamily("self");
		detail3.setBankName("SBI");
		detail3.setAccountNumber("1000");
		detail3.setPublicOrPrivateBank("private");
		assertEquals(detail2.toString(), detail3.toString());
		assertEquals(detail2.getAadharId(), detail3.getAadharId());
		assertEquals(detail2.getPanNumber(), detail3.getPanNumber());
		assertEquals(detail2.getAccountNumber(), detail3.getAccountNumber());
		assertEquals(detail2.getAllowances(), detail3.getAllowances());
		assertEquals(detail2.getBankName(), detail3.getBankName());
		assertEquals(detail2.getDateOfBirth(), detail3.getDateOfBirth());
		assertEquals(detail2.getLastSalary(), detail3.getLastSalary());
		assertEquals(detail2.getPensionerName(), detail3.getPensionerName());
		assertEquals(detail2.getPublicOrPrivateBank(), detail3.getPublicOrPrivateBank());
		assertEquals(detail2.getSelfOrFamily(), detail3.getSelfOrFamily());
	}
	
	@Test
	public void testPensionerDetailNegative() {
		PensionerDetail detail2=new PensionerDetail("1", "Nabeel", "03-12-1999", "100", 29000, 1200, "self", "SBI", "1000", "private");
		PensionerDetail detail3=new PensionerDetail();
		detail3.setAadharId("2");
		detail3.setPensionerName("Nabeel1");
		detail3.setDateOfBirth("03-11-1999");
		detail3.setPanNumber("1001");
		detail3.setLastSalary(29001);
		detail3.setAllowances(1201);
		detail3.setSelfOrFamily("family");
		detail3.setBankName("ICICI");
		detail3.setAccountNumber("2000");
		detail3.setPublicOrPrivateBank("public");
		assertNotEquals(detail2, detail3);
		assertNotEquals(detail2.toString(), detail3.toString());
		assertNotEquals(detail2.hashCode(), detail3.hashCode());
		assertNotEquals(detail2.getAadharId(), detail3.getAadharId());
		assertNotEquals(detail2.getPanNumber(), detail3.getPanNumber());
		assertNotEquals(detail2.getAccountNumber(), detail3.getAccountNumber());
		assertNotEquals(detail2.getAllowances(), detail3.getAllowances());
		assertNotEquals(detail2.getBankName(), detail3.getBankName());
		assertNotEquals(detail2.getDateOfBirth(), detail3.getDateOfBirth());
		assertNotEquals(detail2.getLastSalary(), detail3.getLastSalary());
		assertNotEquals(detail2.getPensionerName(), detail3.getPensionerName());
		assertNotEquals(detail2.getPublicOrPrivateBank(), detail3.getPublicOrPrivateBank());
		assertNotEquals(detail2.getSelfOrFamily(), detail3.getSelfOrFamily());
		assertNotEquals(detail2.hashCode(), detail3.hashCode());
		assertFalse(detail2.equals(detail3));
	}
	
	@Test
	public void testPensionDetailPositive() {
		PensionDetail detail1=new PensionDetail();
		PensionDetail detail2=new PensionDetail("1",2000.0,100);
		PensionDetail detail3=new PensionDetail();
		detail3.setAadharId("1");
		detail3.setPensionAmount(2000.0);
		detail3.setBankServiceCharge(100);		
		assertEquals(detail2.getAadharId(), detail3.getAadharId());
		assertEquals(detail2.getBankServiceCharge(), detail3.getBankServiceCharge());
		assertEquals(String.valueOf(detail2.getPensionAmount()), String.valueOf(detail3.getPensionAmount()));
		assertEquals(detail2.getClass(), detail3.getClass());
		assertEquals(detail2.toString(), detail3.toString());	
		
	}
	
	@Test
	public void testPensionDetailNegative() {
		
	}
	

	

}
