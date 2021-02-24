package com.itayventura.client;

import com.itayventura.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient("PRODUCTSERVICES")
public interface ProductClient {

        @GetMapping(value = "products")
        List<Product> getAllProducts();

        @GetMapping("products/{id}")
        Product getProduct(@PathVariable("id")long id);
}
