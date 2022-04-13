package com.ehsproy.msCustomersPerson.client.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;

@Data
public class AccountData {

	private String id;
	private String idProduct;
	private String idCustomer;
	private String numAccount;
	private LocalDate dateOpening;
	private String amount;
	private Double balance;
	private Integer maxMovements;
	private Integer numMovements;
	private String numTarget;
	
}
