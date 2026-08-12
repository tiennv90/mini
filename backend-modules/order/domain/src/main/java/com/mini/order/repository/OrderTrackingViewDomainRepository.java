package com.mini.order.repository;

import com.mini.order.domain.OrderTrackingViewDomain;
import com.mini.order.exception.OrderNotFoundException;

public interface OrderTrackingViewDomainRepository {
    OrderTrackingViewDomain findOrderWithLatestStatus(Long orderId) throws OrderNotFoundException;
}
