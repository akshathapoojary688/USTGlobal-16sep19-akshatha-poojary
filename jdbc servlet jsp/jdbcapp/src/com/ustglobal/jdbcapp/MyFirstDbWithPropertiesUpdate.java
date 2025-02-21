package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class MyFirstDbWithPropertiesUpdate {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		FileReader reader = null;


		//here we are not taking resultset object as we are not using select query over here

		try {
			
			reader = new FileReader("db.properties");
			Properties prop = new Properties();
			prop.load(reader);
			
			//step 1 load the driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			//step2 get the connection
			String url = prop.getProperty("url");
			conn = DriverManager.getConnection(url,prop);

			//step3 issue sql query
			String sql = "update employee_info set name ='surya' ,salary = 800000, gender = 'M' where id = 3 ";
			stmt = conn.createStatement();
			int count = stmt.executeUpdate(sql);

			//step4 read the result set
			System.out.println("rows updated "+count);


		}catch(Exception e) {
			e.printStackTrace();
		}

		//step5 close the jdbc objects

		finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(reader!=null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}


}

	
	

