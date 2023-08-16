package com.infosys.dao;

import java.util.List;

import com.infosys.entity.Student;
import com.infosys.entity.Subject;

public interface SubjectDao {
	
	public boolean saveStudent(Student std);

	public List<Student> getStudents();
	
	public List<Subject> getSubjectList();
	
	public List<Subject> getSubjectListByStudent(int Id);
	
	public Subject getSubjectById(int id);
}
