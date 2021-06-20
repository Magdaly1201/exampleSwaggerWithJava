package com.example.maggui.exceptions;

public class StudentNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -7499903121758189606L;
    private static final String exceptionCode = "Student not Found ";

    public StudentNotFoundException() {
	super(exceptionCode);
    }

}
