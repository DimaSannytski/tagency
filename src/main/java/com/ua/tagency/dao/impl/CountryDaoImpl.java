package com.ua.tagency.dao.impl;

import com.ua.tagency.dao.CountryDao;
import com.ua.tagency.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CountryDaoImpl implements CountryDao {

    private final SessionFactory factory;

    @Autowired
    public CountryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Country findById(Integer id) {
        List<Country> countries = factory.getCurrentSession().createQuery("from Country where id=?1")
                .setParameter(1, id)
                .list();
        if (countries.isEmpty()) return null;
        return countries.get(0);
    }

    @Override
    public void save(Country country) {
        factory.getCurrentSession().save(country);
    }

    @Override
    public void deleteById(Integer id) {
        Session session = factory.getCurrentSession();
        session.createQuery("delete Country where id = ?1")
                .setParameter(1, id)
                .executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Country> findAll() {
        return (List<Country>) factory.getCurrentSession().createQuery("from Country").list();
    }

    @Override
    public void update(Country country) {
        factory.getCurrentSession().update(country);
    }
}
