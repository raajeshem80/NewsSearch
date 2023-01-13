///**
// * 
// */
//package com.sapient.newssearch.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sapient.newssearch.model.News;
//import com.sapient.newssearch.repository.NewsRepository;
//import com.sapient.newssearch.service.NewsApiService;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * Rajesh Engimoori
// * Created on Jan 11, 2023
// * Email: rajesh.em@gmail.com
// **/
//
//@Slf4j
//@RestController
//public class NewsApiController {
//
//	@Autowired
//	private NewsApiService newsApiService;
//	
//	@Autowired
//	private NewsRepository newsRepository;
//	
//    @PostMapping(value = "/news", produces = "application/json")
//    public News addNews(@Valid @RequestBody News news) {
//        News response = newsRepository.save(news);
//        log.info("Created News with Id: {} and title : {}", response.getId(), response.getTitle());
//        return response;
//    }
////    
////    @GetMapping("/search")
////    public List<News> searchPlants(@RequestParam String query) {
////
////        log.info("Request for news search received with data : " + query);
////
////        return newsApiService.fuzzySearch(query);
////    }
//	
//}
