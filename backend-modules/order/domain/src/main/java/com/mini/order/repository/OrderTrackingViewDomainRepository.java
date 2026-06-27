package com.mini.order.repository;

import com.mini.order.domain.OrderTrackingViewDomain;

public interface OrderTrackingViewDomainRepository {
    OrderTrackingViewDomain findOrderWithLatestStatus(Long orderId);
}
