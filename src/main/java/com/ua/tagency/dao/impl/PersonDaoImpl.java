package com.ua.tagency.dao.impl;

import com.ua.tagency.dao.PersonDao;
import com.ua.tagency.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class PersonDaoImpl implements PersonDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Person findPersonByEmail(String email) {
        List<Person> persons = sessionFactory.getCurrentSession().createQuery("from Person where email=?1")
                .setParameter(1, email)
                .list();
        if (persons.isEmpty()) return null;
        return persons.get(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Person findById(Integer id) {
        List<Person> persons = sessionFactory.getCurrentSession().createQuery("from Person where id=?1")
                .setParameter(1, id)
                .list();
        if (persons.isEmpty()) return null;
        return persons.get(0);
    }

    @Override
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    @Override
    public void deleteById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete Person where id = ?1")
                .setParameter(1, id)
                .executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> findAll() {
        return (List<Person>) sessionFactory.getCurrentSession().createQuery("from Person").list();
    }

    @Override
    public void update(Person person) {
        sessionFactory.getCurrentSession().update(person);
    }
}
