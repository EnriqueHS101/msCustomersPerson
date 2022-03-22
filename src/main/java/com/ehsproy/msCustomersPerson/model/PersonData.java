package com.ehsproy.msCustomersPerson.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("PersonData")
public class PersonData {

	@Id
	private String id;
	@Indexed
	private String docNumber;
	private String firstName;
	private String lastName;
	private String telephoneNumber;
	private String address;
	private String email;

}
