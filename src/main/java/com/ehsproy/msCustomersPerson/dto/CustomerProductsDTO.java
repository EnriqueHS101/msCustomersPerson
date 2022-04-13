package com.ehsproy.msCustomersPerson.dto;

import java.util.List;

import com.ehsproy.msCustomersPerson.client.model.AccountData;
import com.ehsproy.msCustomersPerson.client.model.CreditData;

import lombok.Data;

@Data
public class CustomerProductsDTO {

	private String docNumber;
	private String descripcion;
	private List<AccountData> account;
	private List<CreditData> credit;
	
}
