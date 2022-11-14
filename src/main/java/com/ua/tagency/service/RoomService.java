package com.ua.tagency.service;

import com.ua.tagency.dto.BaseRoomDto;
import com.ua.tagency.dto.RoomReservedDatesDto;

import java.util.List;

public interface RoomService {
    void deleteById(Integer id);
    void updateRoom(BaseRoomDto dto);
    void createRoom(BaseRoomDto dto);
    BaseRoomDto getRoomForEdit(Integer id);
    List<RoomReservedDatesDto> getReservedDates(Integer id);
    BaseRoomDto getRoomForPage(Integer id);
}
