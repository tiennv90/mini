package com.mini.order.service;

import com.mini.order.dto.response.OrderTrackingViewResponse;

public interface OrderTrackingViewService {

    OrderTrackingViewResponse getOrderTrackingView(Long orderId);
}
