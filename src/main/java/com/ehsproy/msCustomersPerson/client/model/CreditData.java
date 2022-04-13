package com.ehsproy.msCustomersPerson.client.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CreditData {

	private String id;
	private String idProduct;
	private String idCustomer;
	private String numAccount;
	private LocalDate dateOpening;
	private String amount;
	private Double balance;
	private String numTarget;
	
}
