package com.sms;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		StudentDAO dao = new StudentDAO();
		
		while(true) {
			System.out.println("\n==== Student Management System ====");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit ");
			System.out.println("Choose : ");
			
			int choice = sc .nextInt();
			
			switch(choice) {
			case 1 : 
				sc.nextLine();
				
				System.out.print("Enter Name: ");
				String name = sc.nextLine();
				
				System.out.print("Enter Age : ");
				int age = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Enter Grade : ");
				String grade = sc.nextLine();
				
				dao.addStudent(new Student (name, age, grade));
				break;
				
			case 2 :
				dao.displayAllStudents();
				break;
				
			case 3 :
				System.out.print("Enter ID of Student to Update: ");
				int uid = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Enter New Name");
				String uname = sc.nextLine();
				
				System.out.print("Enter New Age");
				int uage = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Enter New grade");
				String ugrade = sc.nextLine();
				
				dao.updateStudent(new Student(uid,uname,uage,ugrade));
				break;
				
			case 4 : 
				System.out.print("Enter ID of student to delete : ");
				int did = sc.nextInt();
				dao.deleteStudent(did);
				break;
				
			case 5 : 
				System.out.println("Exiting...");
				System.exit(0);
				
			default:
				System.out.println("Invalid choice! ");
				
			}
		}

	}

}
