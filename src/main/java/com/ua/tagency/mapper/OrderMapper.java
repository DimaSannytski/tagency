package com.ua.tagency.mapper;

import com.ua.tagency.dto.CreateOrderDto;
import com.ua.tagency.dto.OrderPageDto;
import com.ua.tagency.entity.RoomOrder;
import org.hibernate.criterion.Order;

public interface OrderMapper {
    RoomOrder map(CreateOrderDto dto);
    OrderPageDto map(RoomOrder roomOrder);

}
