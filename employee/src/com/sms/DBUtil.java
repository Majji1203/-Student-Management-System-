package com.sms;
import java.sql.*;

public class DBUtil {
	 
	 static Connection con;
	 
	 public static Connection createConnection() {
		 try {
			 
			 // 1. Load the MySQL JDBC Driver
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 
			 // Connect to the MySQL database
			 con = DriverManager.getConnection(
					 "jdbc:mysql://localhost:3307/student_db","root","12345");
		 }
		 catch(Exception e){
			 System.out.println("Database Connection failed : "+ e.getMessage());
		 }
		 return con;
	 }
}
