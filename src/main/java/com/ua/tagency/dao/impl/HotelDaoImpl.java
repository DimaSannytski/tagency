package com.ua.tagency.dao.impl;

import com.ua.tagency.dao.HotelDao;
import com.ua.tagency.entity.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HotelDaoImpl implements HotelDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public HotelDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Hotel findById(Integer id) {
        List<Hotel> hotels = sessionFactory.getCurrentSession().createQuery("from Hotel where id=?1")
                .setParameter(1, id)
                .list();
        if (hotels.isEmpty()) return null;
        return hotels.get(0);
    }

    @Override
    public void save(Hotel hotel) {
        sessionFactory.getCurrentSession().save(hotel);
    }

    @Override
    public void deleteById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete Hotel where id = ?1")
                .setParameter(1, id)
                .executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Hotel> findAll() {
        return (List<Hotel>) sessionFactory.getCurrentSession().createQuery("from Hotel").list();
    }

    @Override
    public void update(Hotel hotel) {
        sessionFactory.getCurrentSession().update(hotel);
    }
}
