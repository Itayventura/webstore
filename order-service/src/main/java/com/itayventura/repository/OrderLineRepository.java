package com.itayventura.repository;

import com.itayventura.domain.OrderLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface OrderLineRepository extends CrudRepository<OrderLine, Long> {
}
