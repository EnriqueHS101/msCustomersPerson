package com.ehsproy.msCustomersPerson.service;

import com.ehsproy.msCustomersPerson.model.TypeDocument;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITypeDocumentService {

	public Flux<TypeDocument> findAll();
	public Mono<TypeDocument> findById(String id);
	public Mono<TypeDocument> save(TypeDocument typeDoc);
	
}
