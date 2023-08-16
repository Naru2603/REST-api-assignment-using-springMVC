package com.infosys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.dao.SubjectDao;
import com.infosys.entity.Student;
import com.infosys.entity.Subject;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	SubjectDao subjectDao;
	
	@Override
	public boolean saveStudent(Student std) {
		return subjectDao.saveStudent(std);
	}

	@Override
	public List<Student> getStudents() {
		
		return subjectDao.getStudents();
	}

	@Override
	public List<Subject> getSubjectList() {
		
		return subjectDao.getSubjectList();
	}

	@Override
	public List<Subject> getSubjectListByStudent(int Id) {
		// TODO Auto-generated method stub
		return subjectDao.getSubjectListByStudent(Id);
	}
	
	@Override
	public Subject getSubjectById(int id) {
		// TODO Auto-generated method stub
		return subjectDao.getSubjectById(id);
	}

	
}
