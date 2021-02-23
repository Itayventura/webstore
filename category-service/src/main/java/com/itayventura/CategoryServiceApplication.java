package com.itayventura;

import com.itayventura.domain.Category;
import com.itayventura.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CategoryServiceApplication implements CommandLineRunner {
	private final CategoryRepository repository;

	@Autowired
	public CategoryServiceApplication(CategoryRepository repository){
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CategoryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createCategories();
	}

	private void createCategories() {
		List<Category> categories = new ArrayList<>(Arrays.asList(
				new Category("Clothes"),
				new Category("Sport"),
				new Category("Office Tools"),
				new Category("Kitchen"),
				new Category("Toys")));
		this.repository.saveAll(categories);
	}
}
