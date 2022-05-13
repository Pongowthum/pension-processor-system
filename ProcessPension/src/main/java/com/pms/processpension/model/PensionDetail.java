package com.pms.processpension.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
public class PensionDetail {

	@Id
	private String AadharId;
	private double pensionAmount;
	private int bankServiceCharge;

	public PensionDetail(String aadharId, double pensionAmount, int bankServiceCharge) {
		AadharId = aadharId;
		this.pensionAmount = pensionAmount;
		this.bankServiceCharge = bankServiceCharge;
	}

	public PensionDetail() {
	}
}