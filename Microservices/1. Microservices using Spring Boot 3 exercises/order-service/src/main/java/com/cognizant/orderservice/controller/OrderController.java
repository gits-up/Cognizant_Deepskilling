package com.cognizant.orderservice.controller;

import com.cognizant.orderservice.model.Order;
import com.cognizant.orderservice.model.User;
import com.cognizant.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}/user")
    public User getUserForOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) return null;

        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/users/" + order.getUserId())
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }
}
