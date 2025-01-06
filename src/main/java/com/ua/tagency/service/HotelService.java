package com.ua.tagency.service;

import com.ua.tagency.dto.*;
import com.ua.tagency.entity.Hotel;

import java.util.List;

public interface HotelService {
    void createHotel(CreateHotelDto dto);
    void deleteById(Integer id);
    void createRooms(CreateRoomsDto dto);
    void updateHotel(EditHotelDto dto);
    HotelPageDto getHotelPage(Integer hotelId);
    List<HotelDto> getHotels();
    EditHotelDto getEditDto(Integer id);
}
