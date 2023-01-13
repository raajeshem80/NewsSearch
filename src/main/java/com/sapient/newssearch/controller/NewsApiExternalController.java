/**
 * 
 */
package com.sapient.newssearch.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sapient.newssearch.dto.NewsData;
import com.sapient.newssearch.dto.Response;
import com.sapient.newssearch.service.NewsApiService;
import com.sapient.newssearch.utils.NewsAPIConstants;
import com.sapient.newssearch.utils.NewsApiUtility;
import com.sapient.newssearch.utils.NewsSearchValidator;

import static com.sapient.newssearch.utils.NewsAPIConstants.VERSION;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * Rajesh Engimoori
 * Created on Jan 11, 2023
 * Email: rajesh.em@gmail.com
 **/

@Slf4j
@RequestMapping(value= VERSION)
@Tag(name = "NewsApiService", description = "API")
@RestController
public class NewsApiExternalController {

	@Autowired
	private NewsApiService newsApiService;
	
    @Operation(summary = "API to fetch News Info.")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = NewsData.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid Request", content = @Content), 
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content) })
	@GetMapping("/getNewsInfo")
	public ResponseEntity<Response> getNewsInfo(@RequestParam(value = "q") String query, 
			@RequestParam(value = "publishDT", required = false) String publishedAt,
			@RequestParam(value = "interval", required = false, defaultValue = "12") int interval,
			@RequestHeader(value = "X-Api-Key") String apiKey, 
			@RequestHeader(value = "sortBy", required = false) String sortBy,
			HttpServletRequest httpRequest) throws UnsupportedEncodingException {

		Map<String, String> queryMap =  NewsApiUtility.GetQueryParameters(httpRequest);
		List<String> errorMessage = NewsSearchValidator.ValidateQueryParams(queryMap);
    	if(errorMessage != null && !errorMessage.isEmpty()) {
    		log.error(NewsAPIConstants.BAD_REQUEST);
    		return this.handleResponse(Response.badRequest().setErrors(errorMessage), HttpStatus.BAD_REQUEST);
    	}
    	
		NewsData data = this.newsApiService.getNewsArticles(query, publishedAt, interval, apiKey, sortBy);

    	if(data.getArticles() == null || data.getArticles().isEmpty()) {
    		log.warn(NewsAPIConstants.NO_DATA_FOUND);
    		return this.handleResponse(Response.notFound().setErrors(NewsAPIConstants.NO_DATA_FOUND), HttpStatus.NOT_FOUND);
    	}
    	log.info(NewsAPIConstants.SEARCH_END);
		return this.handleResponse(Response.ok().setData(data), HttpStatus.OK);
	}
	
	public ResponseEntity<Response> handleResponse(Response response, HttpStatus status) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);    
		return new ResponseEntity<Response>(response, headers, status);
	}
}
