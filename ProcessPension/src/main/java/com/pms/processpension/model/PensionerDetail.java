package com.pms.processpension.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PensionerDetail {

	private String aadharId;
	private String pensionerName;
	private String dateOfBirth;
	private String panNumber;
	private int lastSalary;
	private int allowances;
	private String selfOrFamily;
	private String bankName;
	private String accountNumber;
	private String publicOrPrivateBank;

	public PensionerDetail() {
	}

	public PensionerDetail(String aadharId, String pensionerName, String dateOfBirth, String panNumber, int lastSalary,
			int allowances, String selfOrFamily, String bankName, String accountNumber, String publicOrPrivateBank) {
		this.aadharId = aadharId;
		this.pensionerName = pensionerName;
		this.dateOfBirth = dateOfBirth;
		this.panNumber = panNumber;
		this.lastSalary = lastSalary;
		this.allowances = allowances;
		this.selfOrFamily = selfOrFamily;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.publicOrPrivateBank = publicOrPrivateBank;
	}

}