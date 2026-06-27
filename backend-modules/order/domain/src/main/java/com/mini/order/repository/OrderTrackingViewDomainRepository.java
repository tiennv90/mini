package com.mini.order.repository;

import com.mini.order.domain.OrderTrackingViewDomain;
import shipping.mini.kernal.exception.EntityNotfoundException;

public interface OrderTrackingViewDomainRepository {
    OrderTrackingViewDomain findOrderWithLatestStatus(Long orderId) throws EntityNotfoundException;
}
