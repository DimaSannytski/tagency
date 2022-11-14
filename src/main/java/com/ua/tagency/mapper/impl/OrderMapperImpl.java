package com.ua.tagency.mapper.impl;

import com.ua.tagency.dto.CreateOrderDto;
import com.ua.tagency.dto.OrderPageDto;
import com.ua.tagency.entity.RoomOrder;
import com.ua.tagency.mapper.OrderMapper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public RoomOrder map(CreateOrderDto dto) {
        RoomOrder order = new RoomOrder();
        order.setStartDate(dto.getStartDate());
        order.setEndDate(dto.getEndDate());
        return order;
    }

    @Override
    public OrderPageDto map(RoomOrder roomOrder) {
        OrderPageDto dto = new OrderPageDto();
        dto.setId(roomOrder.getId());
        dto.setCreatorName(String.join(" ", roomOrder.getCreator().getFirstName(),
                roomOrder.getCreator().getLastName()));
        dto.setCreatorId(roomOrder.getCreator().getId());
        dto.setRoomId(roomOrder.getRoom().getId());
        dto.setStartDate(roomOrder.getStartDate());
        dto.setEndDate(roomOrder.getEndDate());
        dto.setRoomName(roomOrder.getRoom().getName());
        dto.setHotelName(roomOrder.getRoom().getHotel().getName());
        return dto;
    }
}
