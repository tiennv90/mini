package com.mini.order.restcontroller;

import com.mini.order.domain.OrderTrackingViewDomain;
import com.mini.order.dto.response.OrderTrackingViewResponse;
import com.mini.order.service.OrderTrackingViewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shipping.mini.kernal.exception.EntityNotfoundException;

@RestController
@RequestMapping("/v1/orderTracking")
public class OrderTrackingViewRestController {


    private final OrderTrackingViewService orderTrackingViewService;

    public OrderTrackingViewRestController(OrderTrackingViewService orderTrackingViewService) {
        this.orderTrackingViewService = orderTrackingViewService;
    }

    @GetMapping("/{orderId}")
    public OrderTrackingViewResponse getOrderTrackingView(@PathVariable Long orderId) throws EntityNotfoundException {
        return orderTrackingViewService.getOrderTrackingView(orderId);
    }
}
