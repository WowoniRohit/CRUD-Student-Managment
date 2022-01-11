package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.spring.DTO.StudentDTO;
import com.spring.entity.Student;

@Component
public interface StudentService {

	public StudentDTO createStudent(Student student);

	public Optional<Student> getStudent(long id);

	public Student updaStudent(Student student);

	public void deleteStudent(long id);

	public void deleteAll();

	public List<StudentDTO> getAllStudents();

	public List<Student> presentStudents();

}
