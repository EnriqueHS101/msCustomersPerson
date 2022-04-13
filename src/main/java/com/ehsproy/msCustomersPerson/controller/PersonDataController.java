package com.ehsproy.msCustomersPerson.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehsproy.msCustomersPerson.client.model.AccountData;
import com.ehsproy.msCustomersPerson.client.model.CreditData;
import com.ehsproy.msCustomersPerson.model.PersonData;
import com.ehsproy.msCustomersPerson.service.IPersonDataService;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
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
	public ResponseEntity<Flux<PersonData>> findAll(){
		log.info("aqui en findAll");
		Flux<PersonData> person = service.findAll();
		
		if (person.count().equals(0)) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(person);
		}
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
	
	@GetMapping("/byDoc/{numDoc}")
	public Mono<PersonData> findByDocNumber(@PathVariable String numDoc){
		return service.findByDocNumber(numDoc);
	}
	
	@CircuitBreaker(name = "accountCP", fallbackMethod = "fallbackGetAccounts")
//	@RateLimiter(name = "accountCP")
//	@Bulkhead(name = "accountCP")
//	@Retry(name = "accountCP", fallbackMethod = "fallbackGetAccounts")
//	@TimeLimiter(name = "accountCP")
	@GetMapping("/accounts/{idCustomer}")
    public ResponseEntity<Flux<AccountData>> getAccounts(@PathVariable("idCustomer") String idCustomer) {
		log.info("Aqui en account de client");
        Mono<PersonData> client= service.findById(idCustomer);
        
        Flux<AccountData> account= service.getAccounts(idCustomer);
        return ResponseEntity.ok(account);
    }
	
	@CircuitBreaker(name = "creditCP", fallbackMethod = "fallbackGetCredits")
	@GetMapping("/credits/{idCustomer}")
    public ResponseEntity<Flux<CreditData>> getCredits(@PathVariable("idCustomer") String idCustomer) {
		log.info("Aqui en credit de client");
        Mono<PersonData> client= service.findById(idCustomer);
        
        Flux<CreditData> credit= service.getCredits(idCustomer);
        return ResponseEntity.ok(credit);
    }
	
//	@GetMapping("/getAll/{idCustomer}")
//    public ResponseEntity<Map<String, Object>> getCustomerProduct(@PathVariable("idCustomer") String idCustomer) {
//        Map<String, Object> result = service.getCustomerProduct(idCustomer);
//        return ResponseEntity.ok(result);
//    }

	private ResponseEntity<Flux<AccountData>> fallbackGetAccounts(@PathVariable("idCustomer") String idCustomer, RuntimeException e) {
		log.info("en el fallback de cuentas");
		return new ResponseEntity(Flux.just("No se tiene informacion"), HttpStatus.OK);
	}
	
	private ResponseEntity<Flux<AccountData>> fallbackGetCredits(@PathVariable("idCustomer") String idCustomer, RuntimeException e) {
		return new ResponseEntity("No se tiene información de Créditos", HttpStatus.OK);
	}
}
