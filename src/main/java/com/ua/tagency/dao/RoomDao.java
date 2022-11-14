package com.ua.tagency.dao;

import com.ua.tagency.dto.RoomDto;
import com.ua.tagency.dto.RoomReservedDatesDto;
import com.ua.tagency.entity.Room;
import com.ua.tagency.entity.RoomOrder;

import java.util.List;

public interface RoomDao extends BaseDao<Room, Integer>{
    List<RoomDto> getRoomsByHotelId(Integer id);
    List<RoomOrder> getReservedDates(Integer id);
}
