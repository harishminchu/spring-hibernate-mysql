package org.krams.tutorial.service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.krams.tutorial.domain.Person;
import org.krams.tutorial.domain.Uttara;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("uttaraService")
@Transactional
public class UttaraService
{
    protected static Logger logger = Logger.getLogger("service");
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public List<Uttara> getAll(Integer personId)
    {
        logger.debug("Retrieving all uttara ");

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM  Uttara WHERE person.id=" + personId);

        return query.list();
    }

    public List<Uttara> getAllImportant(Integer personId)
    {
        logger.debug("Retrieving all uttara ");

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM  Uttara WHERE person.id=" + personId + " AND important=" + "important");

        return query.list();
    }

    public List<Uttara> getAll()
    {
        logger.debug("Retrieving all uttara ");

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM  Uttara");

        return query.list();
    }

    public Uttara get(Integer id)
    {
        Session session = this.sessionFactory.getCurrentSession();

        Uttara uttara = (Uttara)session.get(Uttara.class, id);

        return uttara;
    }

    public void add(Integer personId, Uttara uttara)
    {
        logger.debug("Adding new uttara card");

        Session session = this.sessionFactory.getCurrentSession();

        Person existingPerson = (Person)session.get(Person.class, personId);

        uttara.setPerson(existingPerson);

        session.save(uttara);
    }

    public void delete(Integer id)
    {
        logger.debug("Deleting existing uttara card");

        Session session = this.sessionFactory.getCurrentSession();

        Uttara uttara = (Uttara)session.get(Uttara.class, id);

        session.delete(uttara);
    }

    public void deleteAll(Integer personId)
    {
        logger.debug("Deleting existing uttara  based on person's id");

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery("DELETE FROM Uttara WHERE person.id=" + personId);

        query.executeUpdate();
    }

    public void edit(Uttara uttara)
    {
        logger.debug("Editing existing uttara");

        Session session = this.sessionFactory.getCurrentSession();

        Uttara existingUttara = (Uttara)session.get(Uttara.class, uttara.getId());

        existingUttara.setUttaraDate(uttara.getUttaraDate());
        existingUttara.setUttaraVishaya(uttara.getUttaraVishaya());
        existingUttara.setImportant(uttara.getImportant());

        session.save(existingUttara);
    }
}
