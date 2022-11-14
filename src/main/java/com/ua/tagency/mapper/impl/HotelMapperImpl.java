package com.ua.tagency.mapper.impl;

import com.ua.tagency.dto.*;
import com.ua.tagency.entity.Hotel;
import com.ua.tagency.mapper.HotelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelMapperImpl implements HotelMapper {

    @Override
    public HotelDto map(Hotel hotel) {
        HotelDto hotelDto = new HotelDto();
        hotelDto.setName(hotel.getName());
        hotelDto.setAddress(hotel.getAddress());
        hotelDto.setCountryName(hotel.getCountry().getName());
        hotelDto.setId(hotel.getId());
        hotelDto.setDescription(hotel.getDescription());
        return hotelDto;
    }

    @Override
    public Hotel map(CreateHotelDto dto) {
        Hotel hotel = new Hotel();
        hotel.setName(dto.getName());
        hotel.setAddress(dto.getAddress());
        hotel.setDescription(dto.getDescription());
        return hotel;
    }

    @Override
    public HotelPageDto map(Hotel hotel, List<RoomDto> rooms) {
        HotelPageDto pageDto = new HotelPageDto();
        pageDto.setName(hotel.getName());
        pageDto.setId(hotel.getId());
        pageDto.setAddress(hotel.getAddress());
        pageDto.setCountryName(hotel.getCountry().getName());
        pageDto.setRooms(rooms);
        pageDto.setDescription(hotel.getDescription());
        return pageDto;
    }

    @Override
    public Hotel map(EditHotelDto dto, Hotel hotel) {
        hotel.setName(dto.getName());
        hotel.setAddress(dto.getAddress());
        hotel.setDescription(dto.getDescription());
        return hotel;
    }

    @Override
    public EditHotelDto mapForEdit(Hotel hotel) {
        EditHotelDto dto = new EditHotelDto();
        dto.setAddress(hotel.getAddress());
        dto.setDescription(hotel.getDescription());
        dto.setId(hotel.getId());
        dto.setName(hotel.getName());
        dto.setCountryId(hotel.getCountry().getId());
        return dto;
    }
}
