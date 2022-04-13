package com.ehsproy.msCustomersPerson.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ehsproy.msCustomersPerson.client.model.AccountData;
import com.ehsproy.msCustomersPerson.client.model.CreditData;
import com.ehsproy.msCustomersPerson.model.PersonData;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonDataService {
	
	public Flux<PersonData> findAll();
	public Mono<PersonData> findById(String id);
	public Mono<PersonData> save(PersonData client);
	public Mono<Void> deleteById(String id);
	
	public Mono<PersonData> findByDocNumber(String numDoc);
	
	public Flux<AccountData> getAccounts(String idCustomer);
//	
	public Flux<CreditData> getCredits(String idCustomer);

	public Map<String, Object> getCustomerProduct(String idCustomer);

}
