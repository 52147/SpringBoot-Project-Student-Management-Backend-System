package com.example.demo.model;

import java.util.UUID;
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
