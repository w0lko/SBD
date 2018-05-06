/* Copyright (C) 2012-2015, Versant Software LLC. All rights reserved. http://www.versant.com */

package com.versant.jpa.helloworld.model;

import javax.persistence.*;

/**
 * a very simple JPA Entity for the jpa_hello_world example project
 */
@Entity
public class StudyProgram {

    @Id
    private long id;

    public String ProgramName;
    boolean ProgramType;
    public StudyProgram(String ProgramName, boolean ProgramType) {
        this.ProgramName = ProgramName;
        this.ProgramType=ProgramType;
    }

    @SuppressWarnings("unused")
    private StudyProgram(){
        // a no-args constructor is required, it may be private or protected
    }
    
    @Override
    public String toString() {
        return "StudyProgram["+ProgramName+","+ProgramType+"]";
    }
}
