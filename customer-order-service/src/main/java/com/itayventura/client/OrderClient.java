package com.itayventura.client;

import com.itayventura.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("orderservices")
public interface OrderClient {

    @GetMapping(value = "orders")
    List<Order> getAllOrders();

    @GetMapping("orders/{id}")
    Order getOrder(@PathVariable("id")long id);
}
