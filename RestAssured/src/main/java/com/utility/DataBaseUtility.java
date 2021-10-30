package com.utility;
/*
 * @author Rakesh
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import com.mysql.cj.jdbc.Driver;


public class DataBaseUtility {
	
	public Connection con;
	public ResultSet result;
	
	/*
	 * This method used to create a cnnection to DB
	 */
	public void connectToDB() throws Throwable
	{
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		con=DriverManager.getConnection(IpathConstant.dburl, IpathConstant.dbusername, IpathConstant.dbpassword);
	}
	
	/*
	 * This method will exicute a query with col Index
	 */
	public String exicuteQueryAndGetData(String query,int columnIndex,String expData) throws Throwable {
		Boolean flag=false;
		result = con.createStatement().executeQuery(query);
		while(result.next()) {
			String actdata=result.getString(columnIndex);
			if(actdata.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expData+" data verified sucessfully");
			return expData;
		}
		else {
			System.out.println(expData+" data not verified in db");
			return "";
		}
	}
	/*
	 * This method is used to close the connection to DB
	 */
	public void closeDB() throws Throwable {
		con.close();
	}

}
