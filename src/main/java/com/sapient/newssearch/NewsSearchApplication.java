package com.sapient.newssearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NewsSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsSearchApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
//	@Bean
//	public ApplicationRunner buildIndex(HibernateSearchIndexer indexer) {
//		return (ApplicationArguments args) -> {
//			indexer.indexPersistedData("com.sapient.newssearch.model.News");
//		};
//	}
}
