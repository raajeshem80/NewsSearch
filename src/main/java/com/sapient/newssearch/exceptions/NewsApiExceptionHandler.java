/**
 * 
 */
package com.sapient.newssearch.exceptions;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sapient.newssearch.dto.Response;

/**
 * Rajesh Engimoori
 * Created on Jan 12, 2023
 * Email: rajesh.em@gmail.com
 **/

@ControllerAdvice
@RestController
public class NewsApiExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> exceptionHandler(Exception ex) {
        Response response = Response.unProcessableEntity();
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;

        if (ex instanceof NewsApiException) {
            response = Response.unProcessableEntity();
            response.addErrorMsgToResponse(ex.getMessage(), ex);
        } else if (ex instanceof HttpMessageNotReadableException) {
            String error = "Malformed JSON request";
            response = Response.badRequest();
            response.addErrorMsgToResponse(error, ex);
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
        	response = Response.exception();
            response.addErrorMsgToResponse(ex.getLocalizedMessage(), ex);
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return this.handleResponse(response, httpStatus);
    }
    
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        Response response = Response.badRequest();
        response.addErrorMsgToResponse(error, ex);
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
    
    @Override
    public ResponseEntity handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Specified path not found on this server";
        Response response = Response.badRequest();
        response.addErrorMsgToResponse(error, ex);
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
    
    
    @Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
    	Response response = Response.badRequest();
        response.addErrorMsgToResponse(ex.getMessage(), ex);
        
		return handleExceptionInternal(ex, response, headers, HttpStatus.BAD_REQUEST, request);
	}
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex, HttpHeaders headers, 
        HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", status.value());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    
	protected ResponseEntity<Response> handleResponse(Response response, HttpStatus status) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);    
		return new ResponseEntity<Response>(response, headers, status);
	}
	
}
