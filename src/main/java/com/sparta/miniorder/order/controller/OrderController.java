package com.sparta.miniorder.order.controller;

import com.sparta.miniorder.order.dto.OrderRequest;
import com.sparta.miniorder.order.dto.OrderResponse;
import com.sparta.miniorder.order.entity.Order;
import com.sparta.miniorder.order.respository.OrderRepository;
import com.sparta.miniorder.order.service.OrderService;
import com.sparta.miniorder.product.entity.Product;
import com.sparta.miniorder.product.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @Transactional
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }
}
