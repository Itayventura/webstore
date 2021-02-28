package com.itayventura;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itayventura.domain.Product;
import com.itayventura.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication implements CommandLineRunner {
	private final ProductRepository repository;

	@Value("${path.to.products.json}")
	private String pathToJson;

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
		this.repository.saveAll(getProductsFromJson(pathToJson));
		System.out.println(pathToJson);
	}

	private List<Product> getProducts() {
		return new ArrayList<>(Arrays.asList(
				new Product("Football",2L,30L, 30.0),
				new Product("Basketball",2L,30L, 30.0),
				new Product("Pen",3L,30L, 5.5),
				new Product("Pencil",3L,30L, 1.0),
				new Product("Rubber",3L,30L, 3.6),
				new Product("Notebook",3L,30L, 20.0),
				new Product("Knife",4L,30L,89.90),
				new Product("Fork",4L,30L, 10.00),
				new Product("Spoon",4L,30L, 8.00),
				new Product("Plate",4L,30L,15.00),
				new Product("Wine Glass",4L,30L,10.00),
				new Product("Beer Glass",4L,30L, 30.00),
				new Product("Coffee Glass",4L,30L,10.00),
				new Product("Shot Glass",4L,30L,9.90),
				new Product("Marvel Hasbro",5L,30L,15.00),
				new Product("Spy Ninjas",5L,30L,20.00),
				new Product("Bluey Family Home",5L,30L,15.9),
				new Product("Funko Pop",5L,30L,18.9),
				new Product("Sandbox Vehicle",5L,30L,40.0),
				new Product("Toy Story Woody",5L,30L,20.3),
				new Product("DC Comics Superman",5L,30L,90.3),
				new Product("Spider Man Hasbro Marvel",5L,30L,11.2)
				));
	}

	private List<Product> getProductsFromJson(String filePath) throws IOException {
		return new ObjectMapper().setVisibility(FIELD, ANY)
				.readValue(new FileInputStream(filePath), new TypeReference<>() {});


	}
}
