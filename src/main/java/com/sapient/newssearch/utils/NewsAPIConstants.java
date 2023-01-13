package com.sapient.newssearch.utils;

import java.util.Arrays;
import java.util.List;

public class NewsAPIConstants {

	public static final String VERSION = "/api/1.0/";
	
    public static final String PARAM_QUERY = "q";
    public static final String PARAM_X_API_KEY = "X-Api-Key";
    public static final String PARAM_PUBLISH_DT = "publishDT";
    public static final String PARAM_INTERVAL = "interval"; 
    public static final String PARAM_SORT_BY = "sortBy";
    public static final List<String> QUERY_VALID_PARAMS = Arrays.asList(PARAM_QUERY, PARAM_X_API_KEY, PARAM_PUBLISH_DT, PARAM_INTERVAL, PARAM_SORT_BY);
    
    public static final String NO_DATA_FOUND = "No data found based on search query";
    public static final String SEARCH_END= "Search End : ";
    public static final String SEARCH_START= "Search Start : ";
    public static final String BAD_REQUEST = "Bad Request : ";
    

    public static final String SORT_BY_RELEVANCY = "relevancy";
    public static final String SORT_BY_POPULARITY = "popularity";
    public static final String SORT_BY_PUBLISHED_AT = "publishedAt";
    public static final String DEFAULT_SORT_BY = SORT_BY_PUBLISHED_AT;
    
    public static final List<String> SORT_BY_VALUES = Arrays.asList(SORT_BY_RELEVANCY, SORT_BY_POPULARITY, SORT_BY_PUBLISHED_AT);
}
