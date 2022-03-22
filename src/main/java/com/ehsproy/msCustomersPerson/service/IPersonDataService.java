package com.ehsproy.msCustomersPerson.service;

import com.ehsproy.msCustomersPerson.model.PersonData;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonDataService {
	
	public Flux<PersonData> findAll();
	public Mono<PersonData> findById(String id);
	public Mono<PersonData> save(PersonData client);
	public Mono<Void> deleteById(String id);
	
	public Mono<PersonData> findByDocNumber(String numDoc);
	
}
