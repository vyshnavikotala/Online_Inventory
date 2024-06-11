package com.example.InventoryManagement.Controller;

import com.example.InventoryManagement.Entity.Order;
import com.example.InventoryManagement.Service.OrderService;
import com.example.InventoryManagement.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @DeleteMapping("/{id}")
    public void cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
    }

    @GetMapping("/customer")
    public List<OrderDTO> getOrdersByCustomerEmail(@RequestParam String customerEmail) {
        return orderService.getOrdersByCustomerEmail(customerEmail);
    }

    @GetMapping("/total/{orderId}")
    public BigDecimal calculateTotalOrderAmount(@PathVariable Long orderId) {
        return orderService.calculateTotalOrderAmount(orderId);
    }
}