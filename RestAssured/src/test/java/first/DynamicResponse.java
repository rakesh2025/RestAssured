package first;

import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.response.Response;


import static io.restassured.RestAssured.*;


import java.util.List;

public class DynamicResponse {
	@Test
	public void DynamicResponse() {
		baseURI="http://localhost";
		port=8084;

		String expdata="TestYantra";

		//store the response
		Response res = when().get("/projects");		
		List<String> pname=res.jsonPath().get("projectName");

		for(String actdata:pname) {
			System.out.println(actdata);
			if(actdata.equalsIgnoreCase(expdata)) 
			{
				Assert.assertEquals(actdata, expdata);
				System.out.println(actdata + "data present");
				break;
			}
		}
		res.then().log().all();
	}

}
