package com.sms;

import java.util.*;
import java.sql.*;

public class StudentDAO {
	
	Connection con = DBUtil.createConnection(); // connection
	
	public void addStudent(Student s) {
		try {
			String q= "INSERT INTO students(name,age,grade) VALUES(?,?,?)";
			 
			// preparedStatement 
			
			PreparedStatement ps = con.prepareStatement(q); 
			ps.setString(1,s.name);
			ps.setInt(2,s.age);
			ps.setString(3,s.grade);
			
			ps.executeUpdate(); // updates the database.
			
			System.out.println("STUDENT ADDED SUCESSFULLY");
			
		}
		catch(Exception e) {
			System.out.println("Error while adding student: " + e.getMessage());
		}
	}
	
	public void displayAllStudents() {
		try {
			Statement st = con.createStatement();
			
			// ResultSet
			ResultSet rs = st.executeQuery("SELECT * FROM students");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+ " | " + rs.getString(2) + " | " + rs.getInt(3) + " | " + rs.getString(4));
			}
			
		}
		catch(Exception e ) {
			System.out.println(e);
		}
	}
	
	public void updateStudent(Student s) {
		try {
			String q ="UPDATE students SET name= ? , age=? ,grade=? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(q);
			
			ps.setString(1,s.name);
			ps.setInt(2,s.age);
			ps.setString(3, s.grade);
			ps.setInt(4,s.id);
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				System.out.println("STUDENT UPDATED SUCESSFULLY");
			}else {
				System.out.println("NO STUDENT FOUND WITH ID" + s.id);
			}
			
		}
		catch(Exception e) {
			System.out.println("ERROR UPDATING STUDENTS LIST: " +e.getMessage());
		}
	}
	
	public void deleteStudent(int id) {
		try {
			String q = "DELETE FROM students WHERE id = ? ";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1,id);
			
			int rows = ps.executeUpdate();
			if(rows > 0) {
				System.out.println("Student deleted sucessfully");
			}else {
				System.out.println("NO Student with ID: " + id);
			}
		}
		catch(Exception e) {
			System.out.println("Error deleting student : "+ e.getMessage());
		}
	}
}
