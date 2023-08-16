package com.infosys.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Student;
import com.infosys.entity.Subject;

@Repository
public class SubjectDaoImpl implements SubjectDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean saveStudent(Student std) {
		
		boolean result = false;
		try {

			Session session = sessionFactory.openSession();
			Transaction trx = session.beginTransaction();

			session.save(std);
			trx.commit();

			session.close();

			result = true;
		}

		catch (Exception e) {
			System.out.println("Error occured while storing the student :" + e.getMessage());
		}

		return result;
	}

	@Override
	public List<Student> getStudents() {
		Session session = sessionFactory.openSession();
		Transaction txn = null;
		
		List<Student> stdList = null;
		try {
			txn = session.beginTransaction();
			Query<Student> query = session.createQuery("from Student");
			stdList =query.list();
			txn.commit();
		}
		catch(HibernateException ex) {
			System.out.println("Exception : "+ ex.getMessage());
			ex.printStackTrace(System.err);
		}
		finally {
			session.close();
			return stdList;
		}
	}

	@Override
	public List<Subject> getSubjectList() {
		Session session = sessionFactory.openSession();
		Transaction txn = null;
		
		List<Subject> subjectList = null;
		
		try {
			txn = session.beginTransaction();
			Query<Subject> query = session.createQuery("from Subject");
			subjectList =query.list();
			txn.commit();
		}
		catch(HibernateException ex) {
			System.out.println("Exception : "+ ex.getMessage());
			ex.printStackTrace(System.err);
		}
		finally {
			session.close();
			return subjectList;
		}
	}
	
	

	@Override
	public List<Subject> getSubjectListByStudent(int Id) {
		Student std = null;

		List<Subject> subList = null; 
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();

		std = session.get(Student.class, Id);

		txn.commit();
		session.close();

		return std.getSubject();
	}

	@Override
	public Subject getSubjectById(int id) {
		
		Subject sub = null;

		Session Session = sessionFactory.openSession();

		Transaction trx = Session.beginTransaction();

		sub = Session.get(Subject.class, id);

		trx.commit();
		Session.close();

		return sub;
	}
	
	
}
