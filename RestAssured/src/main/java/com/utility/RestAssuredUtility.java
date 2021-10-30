package com.utility;



import io.restassured.response.Response;



/*
	 * this class contain generic method pertaining to RestAssured
	 * @author Rakesh
	 */
public class RestAssuredUtility {
	public String getjsonData(Response res,String Jsonpath) {
		String value = res.jsonPath().get(Jsonpath);
		return value;

		
	}
}
