package com.itayventura;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itayventura.domain.Product;
import com.itayventura.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
	private final ProductRepository repository;

	@Autowired
	public ProductServiceApplication(ProductRepository repository){
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.repository.saveAll(getProducts());
		Path filePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "products.json");
		this.repository.saveAll(getProductsFromJson( filePath.toString()));

	}

	private List<Product> getProducts() {
		return new ArrayList<>(Arrays.asList(new Product("Football",2L,30L),
				new Product("Basketball",2L,30L)));
	}

	private List<Product> getProductsFromJson(String filePath) throws IOException {
		return new ObjectMapper().setVisibility(FIELD, ANY)
				.readValue(new FileInputStream(filePath), new TypeReference<>() {});


	}
}
