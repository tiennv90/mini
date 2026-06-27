package com.mini.order.infrastructure.jparepository;

import com.mini.order.infrastructure.entity.OrderTrackingViewEntity;

import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTrackingViewJpaRepository extends JpaRepository<@NonNull OrderTrackingViewEntity, @NonNull Long> {

    OrderTrackingViewEntity findFirstByOrderIdOrderByUpdatedAtDesc(@NonNull Long orderId);
}
