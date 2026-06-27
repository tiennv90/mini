package com.mini.order.infrastructure.persistence;

import com.mini.order.domain.OrderTrackingViewDomain;
import com.mini.order.infrastructure.jparepository.OrderTrackingViewJpaRepository;
import com.mini.order.infrastructure.mapper.OrderTrackingViewEntityMapper;
import com.mini.order.repository.OrderTrackingViewDomainRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderTrackingViewRepositoryImpl implements OrderTrackingViewDomainRepository {

    private final OrderTrackingViewJpaRepository orderTrackingViewJpaRepository;
    private final OrderTrackingViewEntityMapper mapper;

    public OrderTrackingViewRepositoryImpl(OrderTrackingViewJpaRepository orderTrackingViewJpaRepository,
                                           OrderTrackingViewEntityMapper mapper) {
        this.orderTrackingViewJpaRepository = orderTrackingViewJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public OrderTrackingViewDomain findOrderWithLatestStatus(Long orderId) {
        return mapper.toDomain(orderTrackingViewJpaRepository.findFirstByOrderIdOrderByUpdatedAtDesc(orderId)) ;
    }
}
