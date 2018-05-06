/* Copyright (C) 2012-2015, Versant Software LLC. All rights reserved. http://www.versant.com */

package com.versant.jpa.helloworld.model;

import javax.persistence.*;

/**
 * a very simple JPA Entity for the jpa_hello_world example project
 */
@Entity
public class Teacher extends Person{

	public int CardNumber;
    
	@Id
    private long id;

    @SuppressWarnings("unused")
	public Teacher()
    {
    	
    }
    public Teacher(String name, String surname, int age, int CardNumber){
    
    	this.name = name;
        this.surname = surname;
        this.age=age;
        this.CardNumber=CardNumber;
    }

    @Override
    public String toString() {
        return "Teacher["+name+","+surname+","+age+","+CardNumber+"]";
    }
	@Override
	String setName(String name) {
		this.name=name;
		return this.name;
	}
	@Override
	String setSurname(String surname) {
		this.surname=surname;
		return this.surname;
	}
	@Override
	int setAge(int age) {
		this.age=age;
		return this.age;
	}
	@Override
	String getName() {
		return this.name;
	}
	@Override
	String getSurname() {
		return this.surname;
	}
	@Override
	int getAge() {
		return this.age;
	}
}
