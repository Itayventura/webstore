package com.itayventura.repository;

import com.itayventura.domain.Product;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Tag(name = "Product", description = "The Product API")
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    Page<Product> findByCategoryId(Long categoryId, Pageable pageable);

}
