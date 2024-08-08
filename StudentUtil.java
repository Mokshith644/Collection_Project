package DataBase;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentUtil extends Student {
	static int id=1;
	public void publicNote(Scanner sc) throws InterruptedException, MyException {
		System.out.println("Welcome to XYZ College");
		System.out.println("Initiating process.....");
		Thread.sleep(3000);
		System.out.println();
		System.out.println("Press 1 for new Student ");
		System.out.println("Press 2 for existing student ");
		System.out.println("Press 3 for administartion authorisation");
		
		int n=sc.nextInt();
		switch(n) {
		case 1:{
			try {
				this.addStudent(sc);
			} catch (InterruptedException | MyException e) {
				new MyException("!");
			}
			break;
		}
		case 2:{
			System.out.println("Press 1 to view your details and 2 to update your detalis");
			int choice=sc.nextInt();
			System.out.println("Enter your ID which was given during the admission");
			int id=sc.nextInt();
			switch(choice) {
			case 1:{
				try {
					getStudent(sc,id);
					
				} catch (MyException e) {
					new MyException("!");
				}
				break;
			}
			case 2:{
				try {
					updateStudent(sc,id);
				} catch (MyException e) {
					new MyException("!");
				}
				break;
				
			}
			default:{
				System.out.println("Invalid Choice");
				break;
			}
			}
			break;
		}
		case 3:{
			System.out.println("Enter admin password: ");
			String pw=sc.next();
			try {
				Admin.validation(pw);
			} catch (Exception e) {
				throw new MyException("Login Aborted!!!!");
			}
			System.out.println("Validation Successful");
			System.out.println("Press 1 if you want to view the student database");
			System.out.println("Press 2 to search student by name");
			System.out.println("Press 3 to modify the database");
			System.out.println("Press 4 to delete any entries in the database");
			int adchoice=sc.nextInt();
			switch(adchoice) {
			case 1:{
				for(int i=0;i<arr.size();i++) {
					System.out.println(arr.get(i).toString());
					System.out.println();
				}
				break;
			}
			case 2:{
				System.out.println("Enter the name of the student : ");
				String search=sc.next();
				for(int i=0;i<arr.size();i++) {
					if(arr.get(i).getName().equalsIgnoreCase(search)) {
						System.out.println("Student found");
						System.out.println(arr.get(i).toString());
						break;
					}
				}
				break;
			}
			case 3:{
				System.out.println("If you want to sort according to name press 1");
				System.out.println("Press 2 to sort according to their admission ID");
				int ch4=sc.nextInt();
				switch(ch4) {
				case 1:{
					Collections.sort(arr,new MyCmp());
					System.out.println("Processing...");
					Thread.sleep(1000);
					System.out.println("Database Modified");
					break;
				}
				case 2:{
					System.out.println("Processing...");
					Thread.sleep(1000);
					System.out.println("Database Modified");
					break;
				}
				default:{
					throw new MyException("Invalid Choice");
					
				}
				
				}
				break;
			}
			case 4:{
				System.out.println("Enter the ID of the student that need to be deleted");
				int ch5=sc.nextInt();
				for(int i=0;i<arr.size();i++) {
					if(arr.get(i).getId()==ch5) {
						arr.remove(i);
						break;
					}
				}
				System.out.println("Deletion Successful");
				System.out.println("Redirecting to main page");
				Thread.sleep(2000);
				break;
			}
			default:{
				throw new MyException("Invalid Choice");
			}
			}
			break;
		}
		default:{
			System.out.println("Invalid Choice");
			break;
		}
		
	}
	}
	public void addStudent(Scanner sc) throws InterruptedException, MyException {
		Map<Integer, String> courses=new HashMap<>();
		System.out.println("Enter your name: ");
		String name=sc.next();
		System.out.println("Enter the branch");
		Thread.sleep(1500);
		System.out.println("Enter 1 for CSE and 2 for ECE");
		int choice=sc.nextInt();
		String branch;
		switch(choice) {
		case 1:{
			branch="CSE";
			CSE.putCourse();
			CSE.getCourse();
			break;
		}
		case 2:{
			branch="ECE";
			ECE.putCourse();
			ECE.getCourse();
			break;
		}
		default:{
			String msg="Invalid Branch Choice";
			throw new MyException(msg);
		}
		}
		System.out.println("Select Minimum of 6 courses");
		System.out.println("From the below courses enter the course id of the subjects that you are opting: ");
		
		for(int i=0;i<6;i++) {
			System.out.println("Enter ID of course "+(i+1));
			int n=sc.nextInt();
			System.out.println("Processing...");
			String course=Courses.arr.get(n);
			if(courses.get(n)==null)courses.put(n, course);
			else {
				String msg="Course already selected, retry again with valid course";
				throw new MyException(msg);
			}
			Thread.sleep(2000);
			
		}
		Student obj=new Student(id++,name,branch,courses);
		System.out.println(obj.toString());
		System.out.println("Student details successfully saved in the database");
		System.out.println("Keep ID for future use");
		
		
		
	}
	public void getStudent(Scanner sc,int n) throws MyException {
		
		Student obj;
		try {
			obj=arr.get(n-1);
		}catch(Exception e){
			String msg="Student data not found";
			throw new MyException(msg);
		}
		System.out.println("Yor details found in our database is as follows:");
		System.out.println("ID: "+obj.getId());
		System.out.println("Name: "+obj.getName());
		System.out.println("Course List: "+obj.getCourse());
	}
	public void updateStudent(Scanner sc,int n) throws MyException {
		System.out.println();
		System.out.println("-----------------------------------------");
		try {
			getStudent(sc,n);
		} catch (MyException e) {
			throw new MyException("!");
		}
		System.out.println("If you wish to modify your data press 1 else press any other key");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:{
			System.out.println("To update name press 1");
			System.out.println("To update course press 2");
			int ch2=sc.nextInt();
			switch(ch2) {
			case 1:{
				System.out.println("Enter the name: ");
				String name=sc.next();
				Student obj=arr.get(n-1);
				if(obj.getName().equals(name)) {
					String msg="New name cannot be same as the old one ";
					throw new MyException(msg);
				}
				else {
					obj.setName(name);
					break;
				}
			}
			case 2:{
				System.out.println("You have registered for the below courses");
				Student obj=arr.get(n-1);
				System.out.println(obj.getCourse());
				System.out.println("Enter the course Id that you want to delete");
				int cid=sc.nextInt();
				try {
					obj.removecourse(cid);
				}catch(Exception e) {
					String msg="Course ID not found";
					throw new MyException(msg);
				}
				if(obj.getBranch().equals("ECE")) {
					ECE.getCourse();
					ECE.putCourse();
					System.out.println("Select the course ID that you want to select");
					int ch3=sc.nextInt();
					String course=ECE.arr.get(ch3);
					obj.getCourse().put(ch3, course);
				}
				if(obj.getBranch().equals("CSE")) {
					CSE.getCourse();
					CSE.putCourse();
					System.out.println("Select the course ID that you want to select");
					int ch3=sc.nextInt();
					String course=CSE.arr.get(ch3);
					obj.getCourse().put(ch3, course);
				}
				break;
				
			}
			default:{
				System.out.println("You didn't change anything");
				break;
			}
			}
			break;
		}
		default:{
			System.out.println("You didn't change anything");
		}
		}
		System.out.println();
		System.out.println("-----------------------------------");
		getStudent(sc,n);
		
	}
}
