package com.example.InventoryManagement.Repository;

import com.example.InventoryManagement.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerEmail(String customerEmail);
    @Query("SELECT o FROM Order o WHERE o.id = :orderId AND o.status = 'ACTIVE'")
    Order findActiveOrder(@Param("orderId") Long orderId);

}
