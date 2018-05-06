/* Copyright (C) 2012-2015, Versant Software LLC. All rights reserved. http://www.versant.com */

package com.versant.jpa.helloworld.model;

import javax.persistence.*;

/**
 * a very simple JPA Entity for the jpa_hello_world example project
 */
@Entity
public class World {

    @Id
    private long id;

    private String name;

    public World(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    private World(){
        // a no-args constructor is required, it may be private or protected
    }

    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
