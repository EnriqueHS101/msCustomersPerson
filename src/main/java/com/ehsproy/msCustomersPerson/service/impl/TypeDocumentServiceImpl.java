package com.ehsproy.msCustomersPerson.service.impl;

import org.springframework.stereotype.Service;

import com.ehsproy.msCustomersPerson.model.TypeDocument;
import com.ehsproy.msCustomersPerson.repository.ITypeDocumentRepository;
import com.ehsproy.msCustomersPerson.service.ITypeDocumentService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TypeDocumentServiceImpl implements ITypeDocumentService {
	
	private final ITypeDocumentRepository typeDocRepo;

	@Override
	public Flux<TypeDocument> findAll() {
		return typeDocRepo.findAll();
	}

	@Override
	public Mono<TypeDocument> findById(String id) {
		return typeDocRepo.findById(id);
	}

	@Override
	public Mono<TypeDocument> save(TypeDocument typeDoc) {
		return typeDocRepo.save(typeDoc);
	}

	
}
