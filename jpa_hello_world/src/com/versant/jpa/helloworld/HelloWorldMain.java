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
        query("select d from Department d", "Department");
        query("select s from Subject s where s.ECTS=3", "Subject");
        query("select sp from StudyProgram sp order by sp.ProgramName", "StudyProgram");
        delete();
        tearDownDB();

       // System.out.println("That's all folks.");
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
        

        Department d1 = new Department("Cybernetyka");
        em.persist(d1);
        System.out.println("@VERSANT_SERVER:: Object created - "+d1);
        Department d2 = new Department("Elektronika");
        em.persist(d2);
        System.out.println("@VERSANT_SERVER:: Object created - "+d2);
        Department d3 = new Department("Logistyka");
        em.persist(d3);
        System.out.println("@VERSANT_SERVER:: Object created - "+d3);
        Department d4 = new Department("Mechanika");
        em.persist(d4);
        System.out.println("@VERSANT_SERVER:: Object created - "+d4);
        Department d5 = new Department("Optoelektronika");
        em.persist(d5);
        System.out.println("@VERSANT_SERVER:: Object created - "+d5);
        
        StudyProgram sp1 = new StudyProgram("Informatyka",false);
        em.persist(sp1);
        System.out.println("@VERSANT_SERVER:: Object created - "+sp1);
        StudyProgram sp2 = new StudyProgram("Kryptologia",false);
        em.persist(sp2);
        System.out.println("@VERSANT_SERVER:: Object created - "+sp2);
        StudyProgram sp3 = new StudyProgram("Informatyka w medycynie",true);
        em.persist(sp3);
        System.out.println("@VERSANT_SERVER:: Object created - "+sp3);
        StudyProgram sp4 = new StudyProgram("Logistyka",false);
        em.persist(sp4);
        System.out.println("@VERSANT_SERVER:: Object created - "+sp4);
        StudyProgram sp5 = new StudyProgram("Budownictwo",false);
        em.persist(sp5);
        System.out.println("@VERSANT_SERVER:: Object created - "+sp5);
        StudyProgram sp6 = new StudyProgram("Ekonomia",false);
        em.persist(sp6);
        System.out.println("@VERSANT_SERVER:: Object created - "+sp6);
        StudyProgram sp7 = new StudyProgram("Ekonometria",false);
        em.persist(sp7);
        System.out.println("@VERSANT_SERVER:: Object created - "+sp7);
        StudyProgram sp8 = new StudyProgram("In¿ynieria œrodowiska",false);
        em.persist(sp8);
        System.out.println("@VERSANT_SERVER:: Object created - "+sp8);
        StudyProgram sp9 = new StudyProgram("Geodezja",false);
        em.persist(sp9);
        System.out.println("@VERSANT_SERVER:: Object created - "+sp9);
        StudyProgram sp10 = new StudyProgram("Bezpieczeñstwo publiczne",false);
        em.persist(sp9);
        System.out.println("@VERSANT_SERVER:: Object created - "+sp9);

        Subject s1 = new Subject("Analiza matematyczna",5);
        em.persist(s1);
        System.out.println("@VERSANT_SERVER:: Object created - "+s1);
        Subject s2 = new Subject("Algebra liniowa",4);
        em.persist(s2);
        System.out.println("@VERSANT_SERVER:: Object created - "+s2);
        Subject s3 = new Subject("Statystyka",3);
        em.persist(s3);
        System.out.println("@VERSANT_SERVER:: Object created - "+s3);
        Subject s4 = new Subject("Programowanie obiektowe",2);
        em.persist(s4);
        System.out.println("@VERSANT_SERVER:: Object created - "+s4);
        Subject s5 = new Subject("Rachunek prawdopodobieñstwa",3);
        em.persist(s5);
        System.out.println("@VERSANT_SERVER:: Object created - "+s5);
        
        Person pt1 = new Teacher("Krzysztof2", "Kowalski2", 65, 100000);
        em.persist(pt1);
        System.out.println("@VERSANT_SERVER:: Object created - "+pt1);
        
        Person ps1 = new Student("Jan", "Jankowski", 19,0);
        em.persist(ps1);
        System.out.println("@VERSANT_SERVER:: Object created - "+ps1);
        Person ps2 = new Student("Konrad", "Kowalewski", 20,1);
        em.persist(ps2);
        System.out.println("@VERSANT_SERVER:: Object created - "+ps2);
        Person ps3 = new Student("Adam", "Król", 19,2);
        em.persist(ps3);
        System.out.println("@VERSANT_SERVER:: Object created - "+ps3);
        Person ps4 = new Student("Tomasz", "Wiœniewski", 22,3);
        em.persist(ps4);
        System.out.println("@VERSANT_SERVER:: Object created - "+ps4);
        Person ps5 = new Student("Alojzy", "Normalny", 21,4);
        em.persist(ps5);
        System.out.println("@VERSANT_SERVER:: Object created - "+ps5);
        Person ps6 = new Student("Albert", "Jach", 22,5);
        em.persist(ps6);
        System.out.println("@VERSANT_SERVER:: Object created - "+ps6);
        Person ps7 = new Student("Bartosz", "Martyniuk", 23,6);
        em.persist(ps7);
        System.out.println("@VERSANT_SERVER:: Object created - "+ps7);
        Person ps8 = new Student("B³a¿ej", "Jurkowski", 24,7);
        em.persist(ps8);
        System.out.println("@VERSANT_SERVER:: Object created - "+ps8);
        Person ps9 = new Student("Bart³omiej", "Skiba", 25,8);
        em.persist(ps9);
        System.out.println("@VERSANT_SERVER:: Object created - "+ps9);
        Person ps10 = new Student("Czes³aw", "Kot", 26,9);
        em.persist(ps10);
        System.out.println("@VERSANT_SERVER:: Object created - "+ps10);

        em.getTransaction().commit();
        close();
    }

    private void query(String jpq2, String classType) {
        connect();
        em.getTransaction().begin();
        if(classType=="Department")
        {
	        TypedQuery<Department> query2 = em.createQuery(jpq2, Department.class);
	        List<Department> resultList2 = query2.getResultList();
	        int nDep=1;
	        System.out.println("@VERSANT_SERVER:: Runing query: "+jpq2);
	        for (Department dep : resultList2) {
	            System.out.println(nDep+". "+ dep);
	            nDep++;
	        }
        }
        else if(classType=="Subject")
        {
	        TypedQuery<Subject> query2 = em.createQuery(jpq2, Subject.class);
	        List<Subject> resultList2 = query2.getResultList();
	        int n=1;
	        System.out.println("@VERSANT_SERVER:: Runing query: "+jpq2);
	        for (Subject sub : resultList2) {
	            System.out.println(n+". "+ sub);
	            n++;
	        }
        }
        else if(classType=="StudyProgram")
        {
	        TypedQuery<StudyProgram> query2 = em.createQuery(jpq2, StudyProgram.class);
	        List<StudyProgram> resultList2 = query2.getResultList();
	        int n=1;
	        System.out.println("@VERSANT_SERVER:: Runing query: "+jpq2);
	        for (StudyProgram sp : resultList2) {
	            System.out.println(n+". "+ sp);
	            n++;
	        }
        }
        em.getTransaction().rollback();
        
        
        close();
    }

    private void delete() {
        connect();
        em.getTransaction().begin();
        String jpql = "select d from Department d";
        TypedQuery<Department> query = em.createQuery(jpql, Department.class);
        List<Department> resultList = query.getResultList();
        for (Department dep : resultList) {
            em.remove(dep);
        }
        em.getTransaction().commit();
        close();
        System.out.println("@VERSANT_SERVER:: Delete all rows from Department");
    }

    private void tearDownDB() {
    	System.out.println("----------------------------------------");
        System.out.println("@VERSANT_SERVER:: Removing database...");
        ServerAdministration.removeDatabase(DATABASE_URL);
        System.out.println("@VERSANT_SERVER:: Database removed");
    }

    private void setUpDB() {
        System.out.println("@VERSANT_SERVER:: Creating database...");
        try {
            ServerAdministration.removeDatabase(DATABASE_URL);
        } catch (Exception e) {
            // ignored for now
        }
        ServerAdministration.createDatabase(DATABASE_URL);
        System.out.println("@VERSANT_SERVER:: Database created");
        System.out.println("----------------------------------------");
    }
}