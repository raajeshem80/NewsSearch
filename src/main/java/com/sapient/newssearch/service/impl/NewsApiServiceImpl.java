/**
 * 
 */
package com.sapient.newssearch.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.newssearch.dto.NewsData;
//import com.sapient.newssearch.repository.NewsRepository;
import com.sapient.newssearch.service.NewsApiService;
import com.sapient.newssearch.utils.NewsApiUtility;

import lombok.extern.slf4j.Slf4j;

/**
 * Rajesh Engimoori
 * Created on Jan 12, 2023
 * Email: rajesh.em@gmail.com
 **/

@Slf4j
@Service
public class NewsApiServiceImpl implements NewsApiService {

	//@Autowired
	//private NewsRepository newsRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${newsapi.endpoint}")
	private String newsapiEndpoint;
	
	private static final List<String> SEARCHABLE_FIELDS = Arrays.asList("title", "description", "content");

	@Override
	public NewsData getNewsArticles(String q, String publishedFrom, int interval,
			String xApiKey, String sortBy) {

		StringBuffer sb = new StringBuffer();
		sb.append(newsapiEndpoint);
		sb.append("?q="+q);
		if(publishedFrom != null && !publishedFrom.equals("")) {
			log.info(">>>>>>>>>>>>>>>> "+publishedFrom);
			String publishedTo = NewsApiUtility.FormatDateTime(publishedFrom, interval);
			sb.append("&from=" + publishedFrom);
			sb.append("&to=" + publishedTo);
		}
		
		if(sortBy != null && !sortBy.equals("")) {
			sb.append("&sortBy="+sortBy);
		} else {
			sb.append("&sortBy="+sortBy);
		}
		sb.append("&apiKey="+xApiKey);

		log.info(">>>>>>>>>>>>>>>> "+sb.toString());
		NewsData newsData = restTemplate.getForObject(sb.toString(), NewsData.class);
		return newsData;
	}
	

//	public List<News> fuzzySearch(String searchTerm) {
//
//
//	        return this.newsRepository.searchBy(
//	        		searchTerm, 10, SEARCHABLE_FIELDS.toArray(new String[0]));
//	}

}
