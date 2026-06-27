package com.mini.order.service;

import com.mini.order.dto.response.OrderTrackingViewResponse;
import com.mini.order.mapper.OrderTrackingViewMapper;
import com.mini.order.repository.OrderTrackingViewDomainRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderTrackingViewServiceImpl implements OrderTrackingViewService {

    private final OrderTrackingViewDomainRepository orderTrackingViewDomainRepository;
    private final OrderTrackingViewMapper orderTrackingViewMapper;

    public OrderTrackingViewServiceImpl(OrderTrackingViewDomainRepository orderTrackingViewDomainRepository,
                                        OrderTrackingViewMapper orderTrackingViewMapper                            ) {
        this.orderTrackingViewDomainRepository = orderTrackingViewDomainRepository;
        this.orderTrackingViewMapper = orderTrackingViewMapper;
    }

    @Override
    public OrderTrackingViewResponse getOrderTrackingView(Long orderId) {
        return orderTrackingViewMapper.toResponse(
                orderTrackingViewDomainRepository.findOrderWithLatestStatus(orderId));
    }
}
