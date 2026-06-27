package com.mini.order.service;

import com.mini.order.dto.response.OrderTrackingViewResponse;
import shipping.mini.kernal.exception.EntityNotfoundException;

public interface OrderTrackingViewService {

    OrderTrackingViewResponse getOrderTrackingView(Long orderId) throws EntityNotfoundException;
}
