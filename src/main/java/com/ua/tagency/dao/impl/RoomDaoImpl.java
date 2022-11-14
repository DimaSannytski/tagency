package com.ua.tagency.dao.impl;

import com.ua.tagency.dao.RoomDao;
import com.ua.tagency.dto.RoomDto;
import com.ua.tagency.dto.RoomReservedDatesDto;
import com.ua.tagency.entity.Room;
import com.ua.tagency.entity.RoomOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class RoomDaoImpl implements RoomDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public RoomDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Room findById(Integer id) {
        List<Room> rooms = sessionFactory.getCurrentSession().createQuery("from Room where id=?1")
                .setParameter(1, id)
                .list();
        if (rooms.isEmpty()) return null;
        return rooms.get(0);
    }

    @Override
    public void save(Room room) {
        sessionFactory.getCurrentSession().save(room);
    }

    @Override
    public void deleteById(Integer id) {
        sessionFactory.getCurrentSession().createQuery("delete Room where id = ?1")
                .setParameter(1, id)
                .executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Room> findAll() {
        return (List<Room>) sessionFactory.getCurrentSession().createQuery("from Room ").list();
    }

    @Override
    public void update(Room room) {
        sessionFactory.getCurrentSession().update(room);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RoomDto> getRoomsByHotelId(Integer id) {
        return sessionFactory.getCurrentSession().createQuery("from Room where hotel.id = ?1")
                .setParameter(1, id).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RoomOrder> getReservedDates(Integer id) {
        return sessionFactory.getCurrentSession().createQuery("from RoomOrder where room.id = ?1 and " +
                "CURRENT_TIMESTAMP < endDate").setParameter(1,id).list();
    }
}
