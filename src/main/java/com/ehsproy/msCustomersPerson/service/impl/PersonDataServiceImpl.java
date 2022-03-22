package com.ehsproy.msCustomersPerson.service.impl;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ehsproy.msCustomersPerson.model.PersonData;
import com.ehsproy.msCustomersPerson.repository.IPersonDataRepository;
import com.ehsproy.msCustomersPerson.service.IPersonDataService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonDataServiceImpl implements IPersonDataService {

	private final IPersonDataRepository repository;
	
	public Flux<PersonData> findAll(){
		return repository.findAll();
	}
	
	public Mono<PersonData> findById(String id){
		return repository.findById(id);
	}
	
	public Mono<PersonData> save(PersonData client){
		return repository.save(client);
	}
	
	public Mono<Void> deleteById(String id){
		return repository.deleteById(id);
	}

	
	public Mono<PersonData> findByDocNumber(String numDoc) {
		return repository.findByDocNumber(numDoc);
	}

}
