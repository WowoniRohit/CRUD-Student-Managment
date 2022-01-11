package com.spring.DTO;

public class StudentDTO {
	
	long id;
	String stdName;
	int rollNo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public StudentDTO(long id, String stdName, int rollNo) {
		super();
		this.id = id;
		this.stdName = stdName;
		this.rollNo = rollNo;
	}
	public StudentDTO() {
		super();
		
	}
	
	
	

}
