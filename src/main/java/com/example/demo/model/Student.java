package com.example.demo.model;

import java.util.UUID;
// UUID: A UUID represents a 128-bit value. It is used for for creating random file names, session id in web application, transaction id etc

// Student class: student data store in the database
public class Student {

	private UUID id;

	private String name;

	public Student(UUID id, String name) {

		this.id = id;
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
