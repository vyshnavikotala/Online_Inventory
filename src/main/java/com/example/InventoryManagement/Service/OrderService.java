package com.example.InventoryManagement.Service;

import com.example.InventoryManagement.Entity.Order;
import com.example.InventoryManagement.Mappers.OrderMapper;
import com.example.InventoryManagement.Repository.OrderRepository;
import com.example.InventoryManagement.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    public void cancelOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<OrderDTO> getOrdersByCustomerEmail(String customerEmail) {
        return orderRepository.findByCustomerEmail(customerEmail).stream().map(orderMapper::toDTO).collect(Collectors.toList());
    }

    public BigDecimal calculateTotalOrderAmount(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        return order.getOrderItems().stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}