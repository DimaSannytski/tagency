package com.ua.tagency.service.impl;

import com.ua.tagency.dao.OrderDao;
import com.ua.tagency.dao.PersonDao;
import com.ua.tagency.dao.RoomDao;
import com.ua.tagency.dto.CreateOrderDto;
import com.ua.tagency.dto.OrderPageDto;
import com.ua.tagency.entity.Person;
import com.ua.tagency.entity.Room;
import com.ua.tagency.entity.RoomOrder;
import com.ua.tagency.mapper.OrderMapper;
import com.ua.tagency.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper mapper;
    private final OrderDao orderDao;
    private final PersonDao personDao;
    private final RoomDao roomDao;

    @Autowired
    public OrderServiceImpl(OrderMapper mapper, OrderDao orderDao, PersonDao personDao, RoomDao roomDao) {
        this.mapper = mapper;
        this.orderDao = orderDao;
        this.personDao = personDao;
        this.roomDao = roomDao;
    }

    @Override
    public void createOrder(CreateOrderDto dto) {
        RoomOrder order = mapper.map(dto);
        Person creator = personDao.findById(dto.getPersonId());
        Room room = roomDao.findById(dto.getRoomId());
        order.setCreator(creator);
        order.setRoom(room);
        orderDao.save(order);
    }

    @Override
    public void delete(Integer id) {
        orderDao.deleteById(id);
    }

    @Override
    public List<OrderPageDto> getAll() {
        return orderDao.findAll().stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public List<OrderPageDto> getByCreatorId(Integer id) {
        return orderDao.getByPersonId(id).stream().map(mapper::map).collect(Collectors.toList());
    }
}
