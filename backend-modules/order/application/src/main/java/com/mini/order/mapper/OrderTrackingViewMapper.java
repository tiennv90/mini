package com.mini.order.mapper;

import com.mini.order.domain.OrderTrackingViewDomain;
import com.mini.order.dto.response.OrderTrackingViewResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderTrackingViewMapper {

    public OrderTrackingViewResponse toResponse(OrderTrackingViewDomain orderTrackingViewDomain) {
        return new OrderTrackingViewResponse(
                orderTrackingViewDomain.getOrderId(),
                orderTrackingViewDomain.getOrderStatus(),
                orderTrackingViewDomain.getEventId());
    }
}
