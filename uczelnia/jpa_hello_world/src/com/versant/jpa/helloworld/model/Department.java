/* Copyright (C) 2012-2015, Versant Software LLC. All rights reserved. http://www.versant.com */

package com.versant.jpa.helloworld.model;

import java.util.Collection;

import javax.persistence.*;

/**
 * a very simple JPA Entity for the jpa_hello_world example project
 */
@Entity
public class Department {

    @Id
    private long id;
    @OneToMany(cascade=CascadeType.PERSIST)
    private Collection<Student> students;
    private Collection<Teacher> teachers;
    

    public String DepartmentName;

    public Department(String name) {
        this.DepartmentName = name;
    }

    @SuppressWarnings("unused")
    private Department(){
        // a no-args constructor is required, it may be private or protected
    }

    @Override
    public String toString() {
        return "Department["+DepartmentName+"]";
    }

    public void setName(String name) {
        this.DepartmentName = name;
    }

}
