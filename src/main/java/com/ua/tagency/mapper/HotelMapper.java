package com.ua.tagency.mapper;

import com.ua.tagency.dto.*;
import com.ua.tagency.entity.Hotel;
import com.ua.tagency.entity.Room;

import java.util.List;
import java.util.Set;

public interface HotelMapper {
    HotelDto map(Hotel hotel);
    Hotel map(CreateHotelDto dto);
    HotelPageDto map(Hotel hotel, List<RoomDto> rooms);
    Hotel map(EditHotelDto dto, Hotel hotel);
    EditHotelDto mapForEdit(Hotel hotel);
}
