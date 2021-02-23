package com.itayventura.repository;

import com.itayventura.domain.Customer;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Tag(name = "Customer", description = "The Customer API")
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
