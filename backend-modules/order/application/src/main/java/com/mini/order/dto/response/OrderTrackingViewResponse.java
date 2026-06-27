package com.mini.order.dto.response;

import com.mini.order.domain.OrderStatusDomain;

public record OrderTrackingViewResponse(
        Long orderId,
        OrderStatusDomain orderStatus,
        String eventId
) {
}
