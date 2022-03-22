package com.ehsproy.msCustomersPerson.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("typeDocument")
public class TypeDocument {

	@Id
	private String id;
	@Indexed(unique = true)
	private String codeType;
	private String nameType;
	private String abrevia;
	private Integer lengthType;
}
