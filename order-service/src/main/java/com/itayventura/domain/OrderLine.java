package com.itayventura.domain;

import javax.persistence.*;

@Entity
@Table(name = "order_lines")
public class OrderLine {
    @Id
    @GeneratedValue
    private Long orderLineId;

    @Column
    private int quantity;

    @Column
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    public OrderLine(int quantity, Long productId){
        this.quantity = quantity;
        this.productId = productId;
    }

    protected OrderLine(){};

    public long getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(long orderLineId) {
        this.orderLineId = orderLineId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
