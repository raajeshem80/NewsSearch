/**
 * 
 */
package com.sapient.newssearch.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Rajesh Engimoori
 * Created on Jan 11, 2023
 * Email: rajesh.em@gmail.com
 **/

public class NewsData {
	String status;
	int totalResults;
	List<Article> articles;

	@JsonProperty("status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("totalResults")
	public int getTotalResults() {
		return this.totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	@JsonProperty("articles")
	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

}
