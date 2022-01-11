package com.spring.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.DTO.StudentDTO;
import com.spring.entity.Student;
import com.spring.repository.StudentRepository;
import com.spring.service.StudentService;

@Service
public class SreviceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	ModelMapper modelMapper;

	final static Logger logger = LogManager.getLogger(SreviceImpl.class);

	@Override
	public StudentDTO createStudent(Student student) {
		logger.info("User Acess Create Student Method");
		Student stdStudent = studentRepository.save(student);
		StudentDTO studentDTO = modelMapper.map(stdStudent, StudentDTO.class);
		logger.info("Student Sucessecully Created");
		return studentDTO;
	}

	@Override
	public Optional<Student> getStudent(long id) {
		Optional<Student> getOptional = studentRepository.findById(id);
		return getOptional;
	}

	@Override
	public void deleteStudent(long id) {
		try {
			studentRepository.deleteById(id);
		} catch (Exception e) {
			logger.error("ID Not Found...........");
		}

	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student> list = new ArrayList<>();
		list = studentRepository.findAll();
		List<StudentDTO> responseDto = list.stream().map(student -> modelMapper.map(student, StudentDTO.class))
				.collect(Collectors.toList());

		return responseDto;
	}

	@Override
	public void deleteAll() {
		studentRepository.deleteAll();

	}

	@Override
	public Student updaStudent(Student student) {
		long id = student.getId();
		Student upaStudent = studentRepository.findById(id).get();
		upaStudent.setStdName(student.getStdName());
		upaStudent.setRollNo(student.getRollNo());
		return studentRepository.save(upaStudent);
	}

	@Override
	public List<Student> presentStudents() {
		List<Student> students = studentRepository.findByAttendence(true);
		return students;
	}

}
