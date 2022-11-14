package com.ua.tagency.service;

import com.ua.tagency.dto.CreateOrderDto;
import com.ua.tagency.dto.OrderPageDto;
import com.ua.tagency.entity.RoomOrder;

import java.util.List;

public interface OrderService {
    void createOrder(CreateOrderDto dto);
    void delete(Integer id);
    List<OrderPageDto> getAll();
    List<OrderPageDto> getByCreatorId(Integer id);
}
