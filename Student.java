package DataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
	private int id;
	private String name;
	private String branch;
	protected Map<Integer,String> course=new HashMap<>();
	static ArrayList<Student>arr=new ArrayList<>();
	public Student() {
		
	}
	@Override
	public String toString() {
		return "ID=" + id + "\n"+"name=" + name + "\n"+ "branch=" + branch + "\n"+ "course=" + course;
	}
	
	
	public Student(int id, String name,String branch, Map<Integer,String> course) {
		super();
		this.id = id;
		this.name = name;
		this.branch=branch;
		this.course = course;
		arr.add(this);
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Integer,String> getCourse() {
		return course;
	}
	public void removecourse(int n) {
		course.remove(n);
	}
}
