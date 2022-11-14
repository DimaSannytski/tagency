package com.ua.tagency.mapper;

import com.ua.tagency.dto.BaseRoomDto;
import com.ua.tagency.dto.RoomDto;
import com.ua.tagency.dto.RoomReservedDatesDto;
import com.ua.tagency.entity.Room;
import com.ua.tagency.entity.RoomOrder;

public interface RoomMapper {
    RoomDto map(Room room);
    Room map(BaseRoomDto dto);
    BaseRoomDto mapBaseDto(Room room);
    RoomReservedDatesDto map(RoomOrder order);
}
