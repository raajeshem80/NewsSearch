/**
 * 
 */
package com.sapient.newssearch.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * Rajesh Engimoori
 * Created on Jan 12, 2023
 * Email: rajesh.em@gmail.com
 **/
@Getter
@Setter
public class NewsApiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1497800588636664494L;
	
	private String message;
    private int code;
    
    /**
	 * @param string
	 * @param e
	 */
	public NewsApiException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
	}
	
	public NewsApiException(String message) {
        super(message);
        this.message = message;
	}
}
