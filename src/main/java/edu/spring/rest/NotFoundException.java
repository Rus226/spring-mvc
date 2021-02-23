package edu.spring.rest;

public class NotFoundException extends RuntimeException{

    public NotFoundException(Integer id) {
        super("Could not find person " + id);
    }
}
