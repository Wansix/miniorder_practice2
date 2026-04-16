package com.sparta.miniorder.order.dto;

import com.sparta.miniorder.order.entity.Order;
import com.sparta.miniorder.product.entity.Product;
import lombok.Getter;

@Getter
public class OrderResponse {

    private final Long orderId;
    private final Product product;

    public OrderResponse(Order order){
        orderId = order.getId();
        product = order.getProduct();
    }
}
