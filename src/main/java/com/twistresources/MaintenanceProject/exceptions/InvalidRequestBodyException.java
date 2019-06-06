package com.twistresources.MaintenanceProject.exceptions;

public class InvalidRequestBodyException extends RuntimeException{

    public InvalidRequestBodyException(String message) {
        super(message);
    }

}