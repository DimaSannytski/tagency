package com.ua.tagency.service.impl;

import com.ua.tagency.dao.HotelDao;
import com.ua.tagency.dao.RoomDao;
import com.ua.tagency.dto.BaseRoomDto;
import com.ua.tagency.dto.RoomReservedDatesDto;
import com.ua.tagency.entity.Hotel;
import com.ua.tagency.entity.Room;
import com.ua.tagency.mapper.RoomMapper;
import com.ua.tagency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomDao roomDao;
    private final HotelDao hotelDao;
    private final RoomMapper mapper;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao, HotelDao hotelDao, RoomMapper mapper) {
        this.roomDao = roomDao;
        this.hotelDao = hotelDao;
        this.mapper = mapper;
    }

    @Override
    public void deleteById(Integer id) {
        roomDao.deleteById(id);
    }

    @Override
    public void updateRoom(BaseRoomDto dto) {
        Room room = roomDao.findById(dto.getId());
        if (room == null) return;
        room.setName(dto.getName());
        roomDao.update(room);
    }

    @Override
    public void createRoom(BaseRoomDto dto) {
        Hotel hotel = hotelDao.findById(dto.getHotelId());
        if (hotel == null) return;
        Room room = mapper.map(dto);
        room.setHotel(hotel);
        roomDao.save(room);
    }

    @Override
    public BaseRoomDto getRoomForEdit(Integer id) {
        return mapper.mapBaseDto(roomDao.findById(id));
    }

    @Override
    public List<RoomReservedDatesDto> getReservedDates(Integer id) {
        return roomDao.getReservedDates(id).stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public BaseRoomDto getRoomForPage(Integer id) {
        return mapper.mapBaseDto(roomDao.findById(id));
    }
}
