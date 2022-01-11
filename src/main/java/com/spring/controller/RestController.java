package com.spring.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.DTO.StudentDTO;
import com.spring.entity.Student;
import com.spring.service.StudentService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {

	@Autowired
	private StudentService service;

	@PostMapping("/create")
	public StudentDTO createStud(@RequestBody Student student) {
		StudentDTO std = service.createStudent(student);
		return std;
	}

//	@GetMapping("/all/{id}")
//	public Student getStd(@PathVariable long id) {
//		return service.getStudent(id);
//	}

	@GetMapping("/admin/all/{id}")
	public ResponseEntity<Student> getStd(@PathVariable long id) throws EntityNotFoundException {
		Student student = service.getStudent(id)
				.orElseThrow(() -> new EntityNotFoundException("User Not Found .......... Plz Check Id : " + id));
		return ResponseEntity.ok().body(student);
	}

	@PutMapping("/admin/update")
	public Student updatestud(@RequestBody Student student) {
		return service.updaStudent(student);
	}

	@DeleteMapping("/admin/delete/{id}")
	public String delete(@PathVariable long id) {
		service.deleteStudent(id);
		return "Deleted.............";
	}

	@DeleteMapping("/admin/delete/all")
	public String deleteAll() {
		service.deleteAll();
		return "All Data Deleted........";
	}

	@GetMapping("/admin/all")
	public List<StudentDTO> getAll() {
		List<StudentDTO> getAllReStudents = service.getAllStudents();
		return getAllReStudents;
	}

	@GetMapping("/admin/present")
	public List<Student> preseStudents() {
		List<Student> preStudents = service.presentStudents();
		return preStudents;
	}

}
