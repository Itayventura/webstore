package com.itayventura.repository;

import com.itayventura.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Category", description = "The Product's Category API")

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByName(String name);
}
