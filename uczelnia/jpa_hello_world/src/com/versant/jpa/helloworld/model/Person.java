/* Copyright (C) 2012-2015, Versant Software LLC. All rights reserved. http://www.versant.com */

package com.versant.jpa.helloworld.model;

import javax.persistence.*;

/**
 * a very simple JPA Entity for the jpa_hello_world example project
 */
@Entity
public class Person {

    @Id
    private long id;

    private String name, surname;
    int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age=age;
    }

    @SuppressWarnings("unused")
    private Person(){
        // a no-args constructor is required, it may be private or protected
    }

    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(int age) {
        this.age = age;
    }

}
