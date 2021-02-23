package com.itayventura.repository;

import com.itayventura.domain.Order;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Tag(name = "Order", description = "The Order API")
public interface OrderRepository extends CrudRepository<Order, Long> {
}
