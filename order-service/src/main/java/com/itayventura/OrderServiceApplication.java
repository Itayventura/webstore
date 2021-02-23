package com.itayventura;

import com.itayventura.domain.Order;
import com.itayventura.domain.OrderLine;
import com.itayventura.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceApplication implements CommandLineRunner {

	private final OrderRepository repository;

	@Autowired
	public OrderServiceApplication(OrderRepository repository){
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createOrders();
	}

	private void createOrders() {
		List<Order> orders = new ArrayList<>(Arrays.asList(
				new Order(1L, new Date()),
				new Order(2L, new Date())
		));
		orders.get(0).addOrderLine(new OrderLine(2, 14L));
		orders.get(0).addOrderLine(new OrderLine(3, 19L));
		orders.get(0).addOrderLine(new OrderLine(7, 18L));
		orders.get(1).addOrderLine(new OrderLine(1, 16L));
		orders.get(1).addOrderLine(new OrderLine(2, 14L));
		orders.get(1).addOrderLine(new OrderLine(3, 12L));
		orders.get(1).addOrderLine(new OrderLine(4, 10L));
		this.repository.saveAll(orders);
	}
}
