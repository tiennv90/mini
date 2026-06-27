package com.mini.order.infrastructure.persistence;

import com.mini.order.domain.OrderTrackingViewDomain;
import com.mini.order.infrastructure.entity.OrderTrackingViewEntity;
import com.mini.order.infrastructure.jparepository.OrderTrackingViewJpaRepository;
import com.mini.order.infrastructure.mapper.OrderTrackingViewEntityMapper;
import com.mini.order.repository.OrderTrackingViewDomainRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Repository;
import shipping.mini.kernal.exception.EntityNotfoundException;

import java.util.Optional;

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
    public OrderTrackingViewDomain findOrderWithLatestStatus(Long orderId) throws EntityNotfoundException {
        Optional<OrderTrackingViewEntity> optional = orderTrackingViewJpaRepository.findFirstByOrderIdOrderByUpdatedAtDesc(orderId);
        if (optional.isEmpty()) {
            throw new EntityNotfoundException("Order Tracking View not found");
        }
        return mapper.toDomain(optional.get()) ;
    }
}
