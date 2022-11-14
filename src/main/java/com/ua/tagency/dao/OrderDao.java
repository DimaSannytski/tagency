package com.ua.tagency.dao;

import com.ua.tagency.entity.RoomOrder;

import java.util.Date;
import java.util.List;

public interface OrderDao extends BaseDao<RoomOrder, Integer> {
    List<RoomOrder> getByPersonId(Integer id);
    boolean invalidDates(Date startDate, Date endDate);
}
