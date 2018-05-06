package com.versant.jpa.helloworld.model;

public abstract class Person {
	
	int age;
	String name, surname;
	
	abstract String setName(String name);
	abstract String setSurname(String surname);
	abstract int setAge(int age);
	abstract String getName();
	abstract String getSurname();
	abstract int getAge();
	
	Person(){}
	
}
