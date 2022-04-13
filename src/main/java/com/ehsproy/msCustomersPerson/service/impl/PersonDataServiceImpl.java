package com.ehsproy.msCustomersPerson.service.impl;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ehsproy.msCustomersPerson.client.model.AccountData;
import com.ehsproy.msCustomersPerson.client.model.CreditData;
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
	
	@Autowired
	private WebClient webClient;
	

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

	//--> Comunicacion con msAccount y msCredit
	
	public Flux<AccountData> getAccounts(String idCustomer) {
		
		return webClient.get().uri("/account/bycustomer/{idCustomer}",idCustomer)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(AccountData.class);
	}
	

	public Flux<CreditData> getCredits(String idCustomer) {
		return webClient.get().uri("/credit/bycustomer/{idCustomer}",idCustomer)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(CreditData.class);
	}
//
//	@Override
	public Map<String, Object> getCustomerProduct(String idCustomer) {
//		Map<String, Object> result = new HashMap<>();
//        Mono<PersonData> customer = repository.findById(idCustomer);
//        if(customer == null) {
//            result.put("Mensaje", "no existe el Cliente");
//            return result;
//        }
//        result.put("Customer", customer);
//        System.out.println(customer);
//        Flux<AccountData> accounts =  accountFeign.findByIdCustomer(idCustomer);
//        if(accounts.count().equals(0))
//            result.put("Cuentas", "el Cliente no tiene cuentas en el banco");
//        else
//            result.put("Cuentas", accounts);
//        Flux<CreditData> credit = creditFeign.findByIdCustomer(idCustomer);
//        
//        if(credit.count().equals(0))
//            result.put("Creditos", "El cliente no tiene creditos en el banco");
//        else
//            result.put("Creditos", credit);
        return null;
	}

}
