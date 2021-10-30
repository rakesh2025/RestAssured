package com.crudoperationawithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateAproject {
	@Test
	public void Update() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Rakesh");
		jobj.put("teamSize", 50);
		
		 RequestSpecification reqspe = RestAssured.given();
		 reqspe.contentType(ContentType.JSON);
		 reqspe.body(jobj);
		 
		Response response = reqspe.put("http://localhost:8084/projects/TY_PROJ_603");
		ValidatableResponse validateres = response.then();
		validateres.assertThat().statusCode(200);
		validateres.assertThat().contentType("application/json");
		validateres.log().all();
	}

}
