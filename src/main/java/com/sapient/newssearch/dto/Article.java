/**
 * 
 */
package com.sapient.newssearch.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Rajesh Engimoori
 * Created on Jan 11, 2023
 * Email: rajesh.em@gmail.com
 **/

public class Article {
	
	@JsonProperty("source")
	public Source getSource() {
		return this.source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	Source source;

	@JsonProperty("author")
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	String author;

	@JsonProperty("title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	String title;

	@JsonProperty("description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	String description;

	@JsonProperty("url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	String url;

	@JsonProperty("urlToImage")
	public String getUrlToImage() {
		return this.urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	String urlToImage;

	@JsonProperty("publishedAt")
	public Date getPublishedAt() {
		return this.publishedAt;
	}

	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	Date publishedAt;

	@JsonProperty("content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	String content;
}
