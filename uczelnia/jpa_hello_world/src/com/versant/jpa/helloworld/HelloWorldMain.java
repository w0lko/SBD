/* Copyright (C) 2012-2015, Versant Software LLC. All rights reserved. http://www.versant.com */

package com.versant.jpa.helloworld;

import java.util.*;

import javax.persistence.*;

import com.versant.admin.*;
import com.versant.jpa.helloworld.model.*;

public class HelloWorldMain {

    private static final String PERSISTENCE_UNIT_NAME = "jpa_hello_world";
    private static final String DATABASE_URL = "jpa_hello_world@localhost";

    private EntityManagerFactory emf;

    private EntityManager em;

    public static void main(String[] args) {
        new HelloWorldMain().run();
    }

    private void run() {
        setUpDB();
        create();
        read();
        update();
        delete();
        tearDownDB();

        System.out.println("That's all folks.");
    }

    private void connect() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = emf.createEntityManager();
    }

    private void close() {
        em.close();
        emf.close();
    }

    private void create() {
        connect();
        em.getTransaction().begin();
        World world = new World("Earth");
        em.persist(world);
        
        Person p =new Person ("Adam", "Kowalski", 22);
        em.persist(p);
        
        
        em.getTransaction().commit();
        close();
        
        System.out.println("Created: " + world);
        System.out.println("Created: " + p);
        
        
    }

    private void read() {
        connect();
        em.getTransaction().begin();
        String jpql = "select w from World w where w.name='Earth'";
        TypedQuery<World> query = em.createQuery(jpql, World.class);
        List<World> resultList = query.getResultList();
        for (World world : resultList) {
            System.out.println("Hello from " + world);
        }
        em.getTransaction().rollback();
        close();
    }

    private void update() {
        connect();
        em.getTransaction().begin();
        String jpql = "select w from World w where w.name='Earth'";
        TypedQuery<World> query = em.createQuery(jpql, World.class);
        List<World> resultList = query.getResultList();
        for (World world : resultList) {
            world.setName("the blue planet");
            System.out.println("Hello from " + world);
        }
        em.getTransaction().commit();
        close();
    }

    private void delete() {
        connect();
        em.getTransaction().begin();
        String jpql = "select w from World w";
        TypedQuery<World> query = em.createQuery(jpql, World.class);
        List<World> resultList = query.getResultList();
        for (World world : resultList) {
            em.remove(world);
        }
        em.getTransaction().commit();
        close();
        System.out.println("All Worlds deleted");
    }

    private void tearDownDB() {
        System.out.print("Removing database...");
        ServerAdministration.removeDatabase(DATABASE_URL);
        System.out.println("database removed");
    }

    private void setUpDB() {
        System.out.print("Creating database...");
        try {
            ServerAdministration.removeDatabase(DATABASE_URL);
        } catch (Exception e) {
            // ignored for now
        }
        ServerAdministration.createDatabase(DATABASE_URL);
        System.out.println("database created");
    }
}