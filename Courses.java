package DataBase;

import java.util.HashMap;
import java.util.Map;

public class Courses {
	
	static Map<Integer,String> arr=new HashMap<>();
	
}
class CSE extends Courses{
	public static void  putCourse() {
		arr.put(1,"System Design");
		arr.put(2,"OOP");
		arr.put(3,"Frontend");
		arr.put(4,"DBMS");
		arr.put(5,"DSA");
		arr.put(6,"English");
		arr.put(7, "Constitution");
		arr.put(8, "Human Psychology");
	}
	public static void getCourse(){
		for(Map.Entry<Integer, String> entry: arr.entrySet()) {
			System.out.println(entry.getKey()+"  "+entry.getValue());
		}
	}
}
class ECE extends Courses{
	public static void  putCourse() {
		arr.put(1,"Embedded System Design");
		arr.put(2,"Control System Design");
		arr.put(3,"Microcontroller");
		arr.put(4,"Microprocessor");
		arr.put(5,"Digital Electronics");
		arr.put(6,"English");
		arr.put(7, "Constitution");
		arr.put(8, "Human Psychology");
	}
	public static void getCourse(){
		for(Map.Entry<Integer, String> entry: arr.entrySet()) {
			System.out.println(entry.getKey()+"  "+entry.getValue());
		}
	}
}
