package org.krams.tutorial.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.krams.tutorial.domain.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing students
 * 
 */
@Service("studentService")
@Transactional
public class StudentService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all students
	 * 
	 * @return a list of students
	 */
	public List<Student> getAll() {
		logger.debug("Retrieving all students");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Student");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves a single student
	 */
	public Student get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing student first
		Student student = (Student) session.get(Student.class, id);
		
		return student;
	}
	/**
	 * Adds a new student
	 */
	public void add(Student student) {
		logger.debug("Adding new student");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(student);
	}
	
	/**
	 * Deletes an existing student
	 * @param id the id of the existing student
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing student");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing student first
		Student student = (Student) session.get(Student.class, id);
		
		// Delete 
		session.delete(student);
	}
	
	/**
	 * Edits an existing student
	 */
	public void edit(Student student) {
		logger.debug("Editing existing student");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing student via id
		Student existingstudent = (Student) session.get(Student.class, student.getId());
		
		// Assign updated values to this student
		
		existingstudent.setContact(student.getContact());
		existingstudent.setEmail(student.getEmail());
		existingstudent.setId(student.getId());
		existingstudent.setNAME(student.getNAME());
		existingstudent.setUsnNumber(student.getUsnNumber());
		existingstudent.setSemister(student.getSemister());
		existingstudent.setInternal(student.getInternal());
		existingstudent.setPercentageoaattendanceforsubject1(student.getPercentageoaattendanceforsubject1());
		existingstudent.setPercentageoaattendanceforsubject2(student.getPercentageoaattendanceforsubject2());
		existingstudent.setPercentageoaattendanceforsubject3(student.getPercentageoaattendanceforsubject3());
		existingstudent.setPercentageoaattendanceforsubject4(student.getPercentageoaattendanceforsubject4());
		existingstudent.setPercentageoaattendanceforsubject5(student.getPercentageoaattendanceforsubject5());
		existingstudent.setPercentageoaattendanceforsubject6(student.getPercentageoaattendanceforsubject6());
		existingstudent.setPercentageoaattendanceforsubject7(student.getPercentageoaattendanceforsubject7());
		existingstudent.setPercentageoaattendanceforsubject8(student.getPercentageoaattendanceforsubject8());
		existingstudent.setMark1(student.getMark1());
		existingstudent.setMark2(student.getMark2());
		existingstudent.setMark3(student.getMark3());
		existingstudent.setMark4(student.getMark4());
		existingstudent.setMark5(student.getMark5());
		existingstudent.setMark6(student.getMark6());
		existingstudent.setMark7(student.getMark7());
		existingstudent.setMark8(student.getMark8());
		
		// Save updates
		session.save(existingstudent);
	}
}
