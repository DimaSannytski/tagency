package com.ua.tagency.dao.impl;

import com.ua.tagency.dao.OrderDao;
import com.ua.tagency.entity.RoomOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class OrderDaoImpl implements OrderDao {
    private final SessionFactory sessionFactory;

    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public RoomOrder findById(Integer id) {
        List<RoomOrder> roomOrders = sessionFactory.getCurrentSession().createQuery("from RoomOrder where id=?1")
                .setParameter(1, id)
                .list();
        if (roomOrders.isEmpty()) return null;
        return roomOrders.get(0);
    }

    @Override
    public void save(RoomOrder order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public void deleteById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete RoomOrder where id = ?1")
                .setParameter(1, id)
                .executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RoomOrder> findAll() {
        return (List<RoomOrder>) sessionFactory.getCurrentSession().createQuery("from RoomOrder").list();
    }

    @Override
    public void update(RoomOrder roomOrder) {
        sessionFactory.getCurrentSession().update(roomOrder);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RoomOrder> getByPersonId(Integer id) {
        return sessionFactory.getCurrentSession().createQuery("from RoomOrder where creator.id=?1")
                .setParameter(1, id)
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean invalidDates(Date startDate, Date endDate) {
        return sessionFactory.getCurrentSession().createQuery("from RoomOrder" +
                        " where startDate <= ?1 and endDate >= ?2 or " +
                        "startDate >= ?1 and endDate <= ?2 or " +
                        "startDate >= ?1 and endDate >= ?2 or " +
                        "startDate <= ?1 and endDate <= ?2 ")
                .setParameter(1, startDate)
                .setParameter(2, endDate)
                .list().isEmpty();
    }
}
