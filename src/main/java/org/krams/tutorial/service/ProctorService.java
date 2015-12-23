package org.krams.tutorial.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.krams.tutorial.domain.Proctor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Persons
 * 
 */
@Service("proctorService")
@Transactional
public class ProctorService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * Retrieves all persons
	 * 
	 * @return a list of persons
	 */
	public List<Proctor> getAll() {
		logger.debug("Retrieving all Proctors");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Proctor");

		// Retrieve all
		return query.list();
	}

	/**
	 * Retrieves a single person
	 */
	public Proctor get(Integer id) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing person first
		Proctor proctor = (Proctor) session.get(Proctor.class, id);

		return proctor;
	}

	public Proctor get(String username, String password) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		String qry = "FROM Proctor WHERE name=:name AND password=:password";

		Query query = session.createQuery(qry);

		query.setParameter("name", username);
		query.setParameter("password", password);

		List<Proctor> list = query.list();

		logger.debug(list.isEmpty() + query.getQueryString());

		if (list.isEmpty()) {

			return new Proctor();
		}

		return list.get(0);
	}

	/**
	 * Adds a new person
	 */
	public void add(Proctor proctor) {
		logger.debug("Adding new person");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Save
		session.save(proctor);
	}

	/**
	 * Deletes an existing person
	 * 
	 * @param id
	 *            the id of the existing person
	 */
	public void delete(Integer id) {

		logger.debug("Deleting existing person");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing person first
		Proctor proctor = (Proctor) session.get(Proctor.class, id);

		// Delete
		session.delete(proctor);
	}

	/**
	 * Edits an existing person
	 */
	public void edit(Proctor proctor) {
		logger.debug("Editing existing person");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		Proctor existingProctor = (Proctor) session.get(Proctor.class,
				proctor.getId());

		existingProctor.setId(proctor.getId());
		existingProctor.setContact(proctor.getContact());
		existingProctor.setDeparment(proctor.getDeparment());
		existingProctor.setEmail(proctor.getEmail());
		existingProctor.setName(proctor.getName());
		existingProctor.setPassword(proctor.getPassword());
		session.update(existingProctor);

	}
}
