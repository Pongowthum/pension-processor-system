package com.pms.processpension.controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculatePension {

	public static int calculateBankServiceCharge(String sectorOfBank) {
		int charge = -1;
		if (sectorOfBank.equals("public")) {
			charge = 500;
		} else if (sectorOfBank.equals("private")) {
			charge = 550;
		} else {
			log.info("Data Mismatch! Back must be public/private");
		}
		return charge;
	}

	public static double calculatePension(String selfOrFamily, int salery, int allowence) {
		double amount = 0;
		if (selfOrFamily.equals("self")) {
			amount = 0.8 * (salery) + allowence;
		} else if (selfOrFamily.equals("family")) {
			amount = 0.5 * (salery) + allowence;
		} else {
			log.info("Data Mismatch! Only Self/Family member allowed");
		}
		return amount;
	}
}
