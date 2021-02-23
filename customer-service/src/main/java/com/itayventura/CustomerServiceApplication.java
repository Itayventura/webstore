package com.itayventura;

import com.itayventura.domain.Customer;
import com.itayventura.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerServiceApplication implements CommandLineRunner {
	private final CustomerRepository repository;

	@Autowired
	public CustomerServiceApplication(CustomerRepository repository){
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Customer> customers = new ArrayList<>(Arrays.asList(
				new Customer("David", "Levi", "David.Levi@gmail.com", "Tel Aviv Dizingof 1"),
				new Customer("Moshe", "Cohen", "Moshe.Cohen@gmail.com", "Tel Aviv Dizingof 2")
		));
		this.repository.saveAll(customers);

	}
}
