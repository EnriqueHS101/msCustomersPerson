package com.ehsproy.msCustomersPerson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehsproy.msCustomersPerson.model.TypeDocument;
import com.ehsproy.msCustomersPerson.service.ITypeDocumentService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/typeDocument")
@RequiredArgsConstructor
public class TypeDocumentController {

	private final ITypeDocumentService typeDocService;

	@GetMapping
	public Flux<TypeDocument> findAll(){
		return typeDocService.findAll();
	}

	@PostMapping
	public Mono<TypeDocument> save(@RequestBody TypeDocument typeDoc) {
		return typeDocService.save(typeDoc);
	}

}
