package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.Student;
import com.infosys.entity.Subject;
import com.infosys.service.SubjectService;

@RestController
public class StudentSubjectController {

	@Autowired
	SubjectService subjectService;

	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student std) {

		System.out.println("request received to create student  : " + std);
		if (subjectService.saveStudent(std))

			return std;

		else
			return std;

	}

	@GetMapping("/students")
	public List<Student> getAllStudents() {

		System.out.println("Request received to get all student ");

		return subjectService.getStudents();

	}

	@GetMapping("/subjects")
	public List<Subject> getAllSubjects() {
		System.out.println("request received to get all subject");

		return subjectService.getSubjectList();
	}

	@GetMapping("/students/{id}/subjects")
	public List<Subject> getSubjects(@PathVariable("id") int id) {
		System.out.println("request received to get subjects of Particular Student of Id : " + id);

		return	subjectService.getSubjectListByStudent(id);

	}

	@GetMapping("/student/{id}/subjects/{id}")
	public Subject getSubjectById(@PathVariable("id") int id) {

		System.out.println("request received to get subject of id: " + id);

		Subject retreivedSubject = subjectService.getSubjectById(id);

		return retreivedSubject;
	}
}
