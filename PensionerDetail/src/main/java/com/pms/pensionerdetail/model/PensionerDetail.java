package com.pms.pensionerdetail.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Data
@ApiModel(description="Details about the pensioner")
public class PensionerDetail {

	@Id
	@ApiModelProperty(notes="Aadhar ID number of pensioner")
	private String aadharId;
	@ApiModelProperty(notes="First and Last name of the pensioner")
	private String pensionerName;
	@ApiModelProperty(notes="Pensioner's Date of birth")
	private String dateOfBirth;
	@ApiModelProperty(notes="Pensioner's Permanent account number")
	private String panNumber;
	@ApiModelProperty(notes="Pensioner's last earned salery")
	private int lastSalary;
	@ApiModelProperty(notes="Pensioner's Allowances")
	private int allowances;
	@ApiModelProperty(notes="Whether the receiver is Pernsioner and Pensioner's family member")
	private String selfOrFamily;
	@ApiModelProperty(notes="Pensioner's active bank partner")
	private String bankName;
	@ApiModelProperty(notes="Pensioner's bank account number")
	private String accountNumber;
	@ApiModelProperty(notes="Pensioner's bank's sector")
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