package com.ua.tagency.mapper.impl;

import com.ua.tagency.dto.BaseRoomDto;
import com.ua.tagency.dto.RoomDto;
import com.ua.tagency.dto.RoomReservedDatesDto;
import com.ua.tagency.entity.Room;
import com.ua.tagency.entity.RoomOrder;
import com.ua.tagency.mapper.RoomMapper;
import com.ua.tagency.utils.Constants;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class RoomMapperImpl implements RoomMapper {
    @Override
    public RoomDto map(Room room) {
        return null;
    }

    @Override
    public Room map(BaseRoomDto dto) {
        Room room = new Room();
        room.setName(dto.getName());
        room.setId(dto.getId());
        return room;
    }

    @Override
    public BaseRoomDto mapBaseDto(Room room) {
        BaseRoomDto dto = new BaseRoomDto();
        dto.setName(room.getName());
        dto.setId(room.getId());
        dto.setHotelId(room.getHotel().getId());
        return dto;
    }

    @Override
    public RoomReservedDatesDto map(RoomOrder order) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_PATTERN);
        RoomReservedDatesDto dto = new RoomReservedDatesDto();
        dto.setEndDate(order.getEndDate());
        dto.setStartDate(order.getStartDate());
        dto.setStartDateStr(simpleDateFormat.format(order.getStartDate()));
        dto.setEndDateStr(simpleDateFormat.format(order.getEndDate()));
        return dto;
    }
}
