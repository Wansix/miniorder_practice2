package com.sparta.miniorder.order.dto;

import com.sparta.miniorder.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderRequest {

    private Long productId;

}
