package com.crudoperationawithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteAResponse {
	@Test
	public void delete() {
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_803");
		ValidatableResponse validateres = response.then();
		validateres.assertThat().statusCode(204);
		validateres.assertThat().contentType("application/json");
		validateres.log().all();
	}

	}


