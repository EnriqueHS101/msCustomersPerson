package com.ehsproy.msCustomersPerson.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ehsproy.msCustomersPerson.model.PersonData;

import reactor.core.publisher.Mono;

public interface IPersonDataRepository extends ReactiveCrudRepository<PersonData, String> {

	
	Mono<PersonData> findByDocNumber(String numDoc);
}
