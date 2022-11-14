package com.ua.tagency.service.impl;

import com.ua.tagency.dao.CountryDao;
import com.ua.tagency.dao.HotelDao;
import com.ua.tagency.dao.RoomDao;
import com.ua.tagency.dto.*;
import com.ua.tagency.entity.Hotel;
import com.ua.tagency.entity.Room;
import com.ua.tagency.mapper.HotelMapper;
import com.ua.tagency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelDao hotelDao;
    private final HotelMapper mapper;
    private final CountryDao countryDao;
    private final RoomDao roomDao;

    @Autowired
    public HotelServiceImpl(HotelDao hotelDao, HotelMapper mapper, CountryDao countryDao, RoomDao roomDao) {
        this.hotelDao = hotelDao;
        this.mapper = mapper;
        this.countryDao = countryDao;
        this.roomDao = roomDao;
    }

    @Override
    public List<HotelDto> getHotels() {
        return hotelDao.findAll().stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public EditHotelDto getEditDto(Integer id) {
        Hotel hotel = hotelDao.findById(id);
        return mapper.mapForEdit(hotel);
    }

    @Override
    public void createHotel(CreateHotelDto dto) {
        Hotel hotel = mapper.map(dto);
        hotel.setCountry(countryDao.findById(dto.getCountryId()));
        hotelDao.save(hotel);
    }

    @Override
    public void deleteById(Integer id) {
        hotelDao.deleteById(id);
    }

    @Override
    public void createRooms(CreateRoomsDto dto) {
        Hotel hotel = hotelDao.findById(dto.getHotelId());
        if (hotel == null) throw new EntityNotFoundException();
        getRoomsForCreate(dto, hotel).forEach(roomDao::save);
    }

    @Override
    public void updateHotel(EditHotelDto dto) {
        Hotel hotel = hotelDao.findById(dto.getId());
        hotelDao.update(mapper.map(dto, hotel));
    }

    @Override
    public HotelPageDto getHotelPage(Integer hotelId) {
        return mapper.map(hotelDao.findById(hotelId), roomDao.getRoomsByHotelId(hotelId));
    }

    private List<Room> getRoomsForCreate(CreateRoomsDto dto, Hotel hotel) {
        List<Room> rooms = new ArrayList<>();
        int endIndex = dto.getStartIndex() + dto.getAmountOfRooms();
        for (int i = dto.getStartIndex(); i < endIndex; i++) {
            rooms.add(
                    new Room(hotel, String.join(dto.getDelimiter(), dto.getPrefix(), "" + i, dto.getSuffix()))
            );
        }
        return rooms;
    }
}
