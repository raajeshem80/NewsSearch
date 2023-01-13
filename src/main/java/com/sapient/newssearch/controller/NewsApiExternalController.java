/**
 * 
 */
package com.sapient.newssearch.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sapient.newssearch.dto.NewsData;

/**
 * Rajesh Engimoori
 * Created on Jan 11, 2023
 * Email: rajesh.em@gmail.com
 **/

@RestController
public class NewsApiExternalController {

	@GetMapping("/getnews")
	public ResponseEntity<NewsData> sayHello(@RequestParam String query, @RequestParam String apiKey) {
		RestTemplate restTemplate = new RestTemplate();
		NewsData data = restTemplate.getForObject("https://newsapi.org/v2/everything?q="+query+"&apiKey="+apiKey, NewsData.class);
		return ResponseEntity.ok(data);
	}
	
}
