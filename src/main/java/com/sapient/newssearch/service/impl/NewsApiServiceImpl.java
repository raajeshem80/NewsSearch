/**
 * 
 */
package com.sapient.newssearch.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.sapient.newssearch.repository.NewsRepository;
import com.sapient.newssearch.service.NewsApiService;

/**
 * Rajesh Engimoori
 * Created on Jan 12, 2023
 * Email: rajesh.em@gmail.com
 **/

@Service
public class NewsApiServiceImpl implements NewsApiService {

	@Autowired
	//private NewsRepository newsRepository;
	
	private static final List<String> SEARCHABLE_FIELDS = Arrays.asList("headline", "author", "title", "description");
	

//	public List<News> fuzzySearch(String searchTerm) {
//
//
//	        return this.newsRepository.searchBy(
//	        		searchTerm, 10, SEARCHABLE_FIELDS.toArray(new String[0]));
//	}

}
