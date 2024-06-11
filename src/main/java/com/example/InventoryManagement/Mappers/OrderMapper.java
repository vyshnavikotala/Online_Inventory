package com.example.InventoryManagement.Mappers;

import com.example.InventoryManagement.Entity.Order;
import com.example.InventoryManagement.Entity.OrderItem;
import com.example.InventoryManagement.Repository.ProductRepository;
import com.example.InventoryManagement.dto.OrderDTO;
import com.example.InventoryManagement.dto.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {
    @Autowired
    private ProductRepository productRepository;

    public OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setCustomerName(order.getCustomerName());
        dto.setCustomerEmail(order.getCustomerEmail());

        List<OrderItemDTO> itemDTOs = new ArrayList<>();
        for (OrderItem item : order.getOrderItems()) {
            OrderItemDTO itemDTO = new OrderItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setProductId(item.getProduct().getId());
            itemDTO.setQuantity(item.getQuantity());
            itemDTOs.add(itemDTO);
        }
        dto.setOrderItems(itemDTOs);
        return dto;
    }

    public Order toEntity(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setCustomerName(dto.getCustomerName());
        order.setCustomerEmail(dto.getCustomerEmail());

        List<OrderItem> items = new ArrayList<>();
        for (OrderItemDTO itemDTO : dto.getOrderItems()) {
            OrderItem item = new OrderItem();
            item.setId(itemDTO.getId());
            item.setProduct(productRepository.findById(itemDTO.getProductId()).orElse(null));
            item.setQuantity(itemDTO.getQuantity());
            item.setOrder(order);
            items.add(item);
        }
        order.setOrderItems(items);
        return order;
    }
}