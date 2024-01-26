package org.gagu.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "product_order_item")
public class ProductOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_order_item_id")
    private Integer productOrderItemId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_order_id")
    private Integer productOrderId;

    @Column(name = "product_order_item_quantity")
    private Integer productOrderItemQuantity;

    @Column(name = "productOrder_item_price")
    private Integer productOrderItemPrice;

    @Column(name = "product_order_item_totalprice")
    private Integer productOrderItemTotalprice;

    @Column(name = "product_order_item_totalpriceaddedtax")
    private Integer productOrderItemTotalpriceaddedtax;

    @Column(name = "product_order_item_note")
    private String productOrderItemNote;
}
