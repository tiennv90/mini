package com.mini.order.service;

import com.mini.order.dto.response.OrderTrackingViewResponse;
import com.mini.order.exception.OrderNotFoundException;

public interface OrderTrackingViewService {

    OrderTrackingViewResponse getOrderTrackingView(Long orderId) throws OrderNotFoundException;
}
