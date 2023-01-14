//package com.sapient.newssearch;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.web.client.RestTemplate;
//
//import com.sapient.newssearch.dto.NewsData;
//import com.sapient.newssearch.service.NewsApiService;
//
///**
// * Rajesh Engimoori
// * Created on Jan 13, 2023
// * Email: rajesh.em@gmail.com
// **/
//
//public class NewsApiServiceTest extends NewsSearchApplicationTests{
//
//	@Value("${newsapi.endpoint}")
//	private String newsapiEndpoint;
//
//	@MockBean
//	private NewsApiService newsApiService;
//
//	@MockBean
//	RestTemplate restTemplate;
//
//	@BeforeEach
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void getNewsArticles() {
//		String keyword = "apple";
//		String publishedAt = "2022-06-03T21:22:38Z"; //
//		int interval = 12;
//		String toStr = "2022-06-04T09:22:38Z";
//		String xApiKey = "ccaf5d41cc5140c984818c344edcc14d";
//		String sortBy = "popularity";
//		NewsData newsData = new NewsData();
//		newsData.setStatus("ok");
//		Mockito.doReturn(newsData).when(restTemplate).getForObject("https://newsapi.org/v2/everything" + "?q= "
//				+ keyword + "&from=" + publishedAt + "&to=" + toStr + "&apiKey=" + xApiKey + "&sortBy=" + sortBy, NewsData.class);
//		newsApiService.getNewsArticles(keyword, publishedAt, interval, xApiKey, sortBy);
//
//	}
//
//}
