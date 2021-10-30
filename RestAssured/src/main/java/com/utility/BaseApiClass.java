package com.utility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

/*
 * @author Rakesh
 */
public class BaseApiClass {
	public DataBaseUtility dlib =new DataBaseUtility();
	public JavaUtility jlib =new JavaUtility();
	public RestAssuredUtility rlib =new RestAssuredUtility();
	public ExcelFileUti elib=new ExcelFileUti();
	
	@BeforeSuite
	public void dbConfig() throws Throwable {
		dlib.connectToDB();
		baseURI="http://localhost";
		port=8084;
	}
	@AfterSuite
	public void dbClose() throws Throwable {
		dlib.closeDB();
	}

}
