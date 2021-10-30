package EndToEnd;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utility.BaseApiClass;
import com.utility.Endpoints;


import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;
import projectControlerClass.ProjectControlerPOJO;

public class Createtheproject extends BaseApiClass {
	@Test
	public void createAProject() throws Throwable {
		String CREATEDBY = elib.getDataFromExcel("Sheet1",1,2);
		String PROJECTNAME = elib.getDataFromExcel("Sheet1", 2, 2);
		String STATUS = elib.getDataFromExcel("Sheet1", 2, 2);
		//create a project
		ProjectControlerPOJO pobj=new ProjectControlerPOJO(CREATEDBY+jlib.getRandoNo(), PROJECTNAME+jlib.getRandoNo(), STATUS, jlib.getRandoNo());
		
		  Response res = given()
		.contentType(ContentType.JSON)
		.body(pobj)
		.when()
		.post(Endpoints.addProject);
		res.then().log().all();
		  
		  
		  
		  //capture the expected data
		  String expdata=rlib.getjsonData(res, "projectName");
		  System.out.println(expdata);
		  //validate in db
		  String query="select * from project";
		  String actdata=dlib.exicuteQueryAndGetData(query, 4, expdata);
		  System.out.println("actual data   " +actdata);
		  
		  //validate
		  Assert.assertEquals(actdata, expdata);
			System.out.println("sucessful");
		  
		
	}

}
