package com.ua.tagency.controller;

import com.ua.tagency.dto.CreateOrderDto;
import com.ua.tagency.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/orders")
    public String getOrders(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER, ROLE_ADMIN')")
    @GetMapping("/person/{personId}/orders")
    public String getPersonOrders(Model model, @PathVariable Integer personId) {
        model.addAttribute("orders", orderService.getByCreatorId(personId));
        return "person_orders";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("order/delete")
    public String deleteOrder(@RequestParam("orderId") Integer id) {
        orderService.delete(id);
        return "redirect:/orders";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER, ROLE_ADMIN')")
    @PostMapping("order/create")
    public String createOrder(@ModelAttribute("orderModel") @Valid CreateOrderDto orderDto) {
        orderService.createOrder(orderDto);
        return "redirect:/room/" + orderDto.getRoomId();
    }
}
