package com.sapient.newssearch.utils;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

public class NewsApiUtility {

    public static Map<String, String> GetQueryParameters(HttpServletRequest request) throws UnsupportedEncodingException {
    	Map<String, String> queryMap = new HashMap<>();    	
    	Map<String, String[]> requestParams = Collections.list(request.getParameterNames()).stream().collect(Collectors.toMap(parameterName -> parameterName, request::getParameterValues));
    	for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
            String[] values = entry.getValue();
            for (String value : values) {
				queryMap.put(entry.getKey(), value);
			}
        }
    	return queryMap;
    }
    
	public static String FormatDateTime(String dateValue, int interval) {

		DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
		System.out.println(">>>>>>>>>>> Before");
		LocalDateTime date = LocalDateTime.parse(dateValue, DATE_TIME_FORMATTER);
		System.out.println(">>>>>>>>>>> After");
		LocalDateTime toDate = date.plusHours(interval);
		ZonedDateTime atZone = toDate.atZone(ZoneOffset.UTC);
		return DateTimeFormatter.ISO_DATE_TIME.format(atZone);

	}
	
	public boolean verifyDateFormat(String dateValue) {
		try {
			DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
			LocalDateTime.parse(dateValue, DATE_TIME_FORMATTER);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
