package com.practice.pizzeria.services.exceptions;

public class EmailAPIException extends RuntimeException{
    public EmailAPIException(){
        super("Error sending email...");
    }
}
