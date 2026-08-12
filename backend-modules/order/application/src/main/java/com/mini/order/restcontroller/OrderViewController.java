package com.mini.order.restcontroller;

import com.mini.order.dto.OrderDetailDTO;
import com.mini.order.exception.OrderNotFoundException;
import com.mini.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orderView")
public class OrderViewController {

    private final OrderService orderService;

    public OrderViewController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("{orderId}")
    public OrderDetailDTO getOrderView(@PathVariable Long orderId) throws OrderNotFoundException {
        return orderService.getOrderView(orderId);
    }
}
