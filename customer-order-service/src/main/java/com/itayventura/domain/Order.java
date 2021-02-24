package com.itayventura.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Long customerId;
    List<OrderLine> orderLines;
    private Date date;

    public Order(Long customerId, Date date){
        this.customerId = customerId;
        this.date = date;
        this.orderLines = new ArrayList<>();
    }

    protected Order(){}

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return (customerId + " " + date );
    }
}
