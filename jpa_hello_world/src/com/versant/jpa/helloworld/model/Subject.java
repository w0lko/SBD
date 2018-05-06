/* Copyright (C) 2012-2015, Versant Software LLC. All rights reserved. http://www.versant.com */

package com.versant.jpa.helloworld.model;

import javax.persistence.*;

/**
 * a very simple JPA Entity for the jpa_hello_world example project
 */
@Entity
public class Subject {

    @Id
    private long id;

    public String SubjectName;
    public int ECTS;
    
    public Subject(String name, int ECTS) {
        this.SubjectName = name;
        this.ECTS=ECTS;
    }

    @SuppressWarnings("unused")
    private Subject(){
        // a no-args constructor is required, it may be private or protected
    }

    @Override
    public String toString() {
        return "Subject["+SubjectName+","+ECTS+"]";
    }


}
