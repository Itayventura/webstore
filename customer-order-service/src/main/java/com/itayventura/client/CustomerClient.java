package com.itayventura.client;

import com.itayventura.domain.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("customerservices")
public interface CustomerClient {

    @GetMapping(value = "customers")
    List<Customer> getAllCustomers();

    @GetMapping("customers/{id}")
    Customer getCustomer(@PathVariable("id")long id);
}
