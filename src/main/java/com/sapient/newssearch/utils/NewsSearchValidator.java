package com.sapient.newssearch.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsSearchValidator {

	public static List<String> ValidateQueryParams(Map<String, String> queryMap) {
		List<String> invalidList = new ArrayList<>();
		Map<String, String> modifiedMap = new HashMap<>();
		if(!queryMap.isEmpty() && queryMap.size() > 0) {
			for (Map.Entry<String, String> entry : queryMap.entrySet()) {
				String trimmed = entry.getKey().trim();
				modifiedMap.put(trimmed, entry.getValue());
			}
		}

		StringBuilder queryParamBuffer = new StringBuilder();
		StringBuilder queryParamValueBuffer = new StringBuilder();
		boolean isValid = true;
		
		if(modifiedMap != null && !modifiedMap.isEmpty()) {
			for(Map.Entry<String, String> entry: modifiedMap.entrySet()) {
				String key = entry.getKey();
				if(!NewsAPIConstants.QUERY_VALID_PARAMS.contains(key)) {
					if(queryParamBuffer.toString().isEmpty()) {
						queryParamBuffer.append("Invalid Input params - ");
					} else {
						queryParamBuffer.append(", ");
					}
					queryParamBuffer.append(key);
					isValid = false;
				} else {
					
				}
			}
		} else {
			queryParamBuffer.append("Valid input params are "+ NewsAPIConstants.PARAM_QUERY + ", " + NewsAPIConstants.PARAM_X_API_KEY + ", " + NewsAPIConstants.PARAM_PUBLISH_DT + " and " + NewsAPIConstants.PARAM_INTERVAL); 
		}
		
		if(!isValid) {
			if(queryParamBuffer.toString().length() > 0)
				invalidList.add(queryParamBuffer.toString());
			if(queryParamValueBuffer.toString().length() > 0)
				invalidList.add(queryParamValueBuffer.toString());
		}
		return invalidList;
	}

}
