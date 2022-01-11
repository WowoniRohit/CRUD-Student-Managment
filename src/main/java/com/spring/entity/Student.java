package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(name = "std_name")
	@javax.validation.constraints.NotEmpty(message = "Please Type Name")
	String stdName;
	@Column(name = "roll_no")
	int rollNo;
	boolean attendence;

	public boolean isAttendence() {
		return attendence;
	}

	public void setAttendence(boolean attendence) {
		this.attendence = attendence;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

}
