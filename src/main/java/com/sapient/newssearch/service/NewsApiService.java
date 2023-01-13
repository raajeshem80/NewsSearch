/**
 * 
 */
package com.sapient.newssearch.service;

import com.sapient.newssearch.dto.NewsData;

//import com.sapient.newssearch.model.News;

/**
 * Rajesh Engimoori
 * Created on Jan 12, 2023
 * Email: rajesh.em@gmail.com
 **/

public interface NewsApiService {

	//List<News> fuzzySearch(String searchTerm);
	
	NewsData getNewsArticles(String q, String publishedFrom, int interval, String xApiKey, String sortBy);
}
