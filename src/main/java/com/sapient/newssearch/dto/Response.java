package com.sapient.newssearch.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sapient.newssearch.exceptions.ErrorMessage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private Status status;
    private Object data;
    private Object errors;
    private String message;

    public static  Response badRequest() {
        Response response = new Response();
        response.setStatus(Status.BAD_REQUEST);
        return response;
    }

    public static  Response ok() {
        Response response = new Response();
        response.setStatus(Status.OK);
        return response;
    }

    public static  Response unauthorized() {
        Response response = new Response();
        response.setStatus(Status.UNAUTHORIZED);
        return response;
    }

    public static  Response validationException() {
        Response response = new Response();
        response.setStatus(Status.VALIDATION_EXCEPTION);
        return response;
    }

    public static  Response exception() {
        Response response = new Response();
        response.setStatus(Status.EXCEPTION);
        return response;
    }

    public static  Response notFound() {
        Response response = new Response();
        response.setStatus(Status.NOT_FOUND);
        return response;
    }

    public static  Response duplicateEntity() {
        Response response = new Response();
        response.setStatus(Status.DUPLICATE_ENTITY);
        return response;
    }

    public static  Response unProcessableEntity() {
        Response response = new Response();
        response.setStatus(Status.UNPROCESSABLE_ENTITY);
        return response;
    }
    
    public void addErrorMsgToResponse(String errorMsg, Exception ex) {
    	ErrorMessage error = new ErrorMessage();
    	error.setMessage(errorMsg);
        setErrors(error);
    }

    public enum Status {
        OK, BAD_REQUEST, UNAUTHORIZED, VALIDATION_EXCEPTION, EXCEPTION, WRONG_CREDENTIALS, ACCESS_DENIED, NOT_FOUND, DUPLICATE_ENTITY, UNPROCESSABLE_ENTITY
    }

}

