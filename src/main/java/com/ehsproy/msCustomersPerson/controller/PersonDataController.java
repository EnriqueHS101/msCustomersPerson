package com.ehsproy.msCustomersPerson.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ehsproy.msCustomersPerson.model.PersonData;
import com.ehsproy.msCustomersPerson.service.IPersonDataService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/customerp")
@RequiredArgsConstructor
public class PersonDataController {
	
	private final IPersonDataService service;
	
	@GetMapping
	public Flux<PersonData> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<PersonData> findById(@PathVariable String id){
		return service.findById(id);
	}
	
	@PostMapping
	public Mono<PersonData> save(@RequestBody PersonData client){
		log.info("grabado");
		return service.save(client);
	}
	
	@PutMapping
	public Mono<PersonData> put(@RequestBody PersonData client){
		return service.save(client);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> deleteById(@PathVariable String id){
		return service.deleteById(id);
	}
	
	@GetMapping("/find/{numDoc}")
	public Mono<PersonData> findByDocNumber(@PathVariable String numDoc){
		return service.findByDocNumber(numDoc);
	}
}
