package org.krams.tutorial.service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.krams.tutorial.domain.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("personService")
@Transactional
public class PersonService
{
    protected static Logger logger = Logger.getLogger("service");
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public List<Person> getAll()
    {
        logger.debug("Retrieving all Persons");

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM Person");

        return query.list();
    }

    public Person get(Integer id)
    {
        Session session = this.sessionFactory.getCurrentSession();

        Person person = (Person)session.get(Person.class, id);

        return person;
    }

    public void add(Person person)
    {
        logger.debug("Adding new person");

        Session session = this.sessionFactory.getCurrentSession();

        session.save(person);
    }

    public void edit(Person person)
    {
        logger.debug("Editing existing person");

        Session session = this.sessionFactory.getCurrentSession();

        Person existingPerson = (Person)session.get(Person.class, person.getId());

        existingPerson.setId(person.getId());
        existingPerson.setName(person.getName());
        existingPerson.setContact(person.getContact());
        existingPerson.setAddress(person.getAddress());
        existingPerson.setPlace(person.getPlace());
        existingPerson.setWhoishe(person.getWhoishe());
        existingPerson.setJoinDate(person.getJoinDate());

        session.update(existingPerson);
    }
}
