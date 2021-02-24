package com.itayventura.web;

import com.itayventura.client.CustomerClient;
import com.itayventura.client.OrderClient;
import com.itayventura.client.ProductClient;
import com.itayventura.domain.Customer;
import com.itayventura.domain.CustomerOrder;
import com.itayventura.domain.Order;
import com.itayventura.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("customer-order")
public class CustomerOrderWebService {
    private final OrderClient orderClient;
    private final CustomerClient customerClient;
    private final ProductClient productClient;

    @Autowired
    public CustomerOrderWebService (OrderClient orderClient, CustomerClient customerClient, ProductClient productClient){
        this.orderClient = orderClient;
        this.customerClient = customerClient;
        this.productClient = productClient;
    }

    @GetMapping("/{id}")
    public CustomerOrder getCustomerOrder(@PathVariable("id")Long id) {
        Order order = this.orderClient.getOrder(id);
        CustomerOrder customerOrder = new CustomerOrder();
        updateOrder(order, customerOrder);
        Customer customer = this.customerClient.getCustomer(order.getCustomerId());
        updateCustomer(customer, customerOrder);
        return customerOrder;
    }

    private void updateCustomer(Customer customer, CustomerOrder customerOrder) {
        customerOrder.setAddress(customer.getAddress());
        customerOrder.setEmail(customer.getEmail());
        customerOrder.setFirstName(customer.getFirstName());
        customerOrder.setLastName(customer.getLastName());
    }

    private void updateOrder(Order order, CustomerOrder customerOrder) {

        order.getOrderLines().forEach(orderLine -> {
            Product product = this.productClient.getProduct(orderLine.getProductId());
            product.setQuantity(orderLine.getQuantity());
            customerOrder.addProduct(product);
        });
        customerOrder.setDate(order.getDate());
        customerOrder.setCustomerId(order.getCustomerId());
    }

}
