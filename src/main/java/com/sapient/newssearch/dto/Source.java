/**
 * 
 */
package com.sapient.newssearch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Rajesh Engimoori
 * Created on Jan 11, 2023
 * Email: rajesh.em@gmail.com
 **/

public class Source {

	Object id;
	String name;
	
    @JsonProperty("id") 
    public Object getId() { 
		 return this.id; } 
    public void setId(Object id) { 
		 this.id = id; } 
    
    @JsonProperty("name") 
    public String getName() { 
		 return this.name; } 
    public void setName(String name) { 
		 this.name = name; } 
    
}
