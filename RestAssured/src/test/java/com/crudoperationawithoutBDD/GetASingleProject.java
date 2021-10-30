package com.crudoperationawithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetASingleProject {
	@Test
	public void getASingleProject()  {
		Response response = RestAssured.get("http://localhost:8084/projects/TY_PROJ_001");
		System.out.println(response.getContentType());
		System.out.println(response.getTime());
		System.out.println(response.statusCode());
		
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType("application/json");
		validate.assertThat().statusCode(200);
		validate.log().all();
		response.prettyPrint();
	}

}
