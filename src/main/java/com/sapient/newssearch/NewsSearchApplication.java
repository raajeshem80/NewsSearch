package com.sapient.newssearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewsSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsSearchApplication.class, args);
	}
	
//	@Bean
//	public ApplicationRunner buildIndex(HibernateSearchIndexer indexer) {
//		return (ApplicationArguments args) -> {
//			indexer.indexPersistedData("com.sapient.newssearch.model.News");
//		};
//	}
}
