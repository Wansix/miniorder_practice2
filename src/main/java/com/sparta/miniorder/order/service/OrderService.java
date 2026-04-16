package com.sparta.miniorder.order.service;

import com.sparta.miniorder.order.dto.OrderRequest;
import com.sparta.miniorder.order.dto.OrderResponse;
import com.sparta.miniorder.order.entity.Order;
import com.sparta.miniorder.order.respository.OrderRepository;
import com.sparta.miniorder.product.entity.Product;
import com.sparta.miniorder.product.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public ResponseEntity<OrderResponse> createOrder(@Valid OrderRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "해당 상품이 존재하지 않습니다. id=" + request.getProductId()));

        Order order = new Order(product);
        Order saved = orderRepository.save(order);
        OrderResponse response = new OrderResponse(saved);

        return ResponseEntity.created(URI.create("/api/orders/" + response.getOrderId())).body(response);
    }

    public ResponseEntity<OrderResponse> getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "해당 주문이 존재하지 않습니다. id=" + id));

        return ResponseEntity.ok(new OrderResponse(order));
    }
}
