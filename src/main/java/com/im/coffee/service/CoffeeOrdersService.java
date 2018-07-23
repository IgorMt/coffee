package com.im.coffee.service;

import com.im.coffee.domain.Coffees;
import com.im.coffee.domain.Orders;
import com.im.coffee.repository.CoffeesRepository;
import com.im.coffee.repository.OrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeOrdersService {

    private static final Logger log = LoggerFactory.getLogger(CoffeeOrdersService.class);

    @Autowired
    private CoffeesRepository coffeesRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> fetchAllOrders() {
        List<Orders> orders = ordersRepository.findAll();
        log.info("{} orders is fetched for fetchAllOrders request.", orders.size());
        return orders;
    }

    public Orders fetchOrderById(Long id) {
        Optional<Orders> order = ordersRepository.findById(id);
        if (order.isPresent()) {
            Orders result = order.get();
            log.info("This order is fetched by ID: " + result);
            return result;
        }
        return null;
    }

    public List<Coffees> fetchAllCoffees() {
        List<Coffees> coffees = coffeesRepository.findAll();
        log.info("{} coffees is fetched for fetchAllCoffees request.", coffees.size());
        return coffees;
    }

    public Coffees fetchCoffeeById(Long id) {
        Optional<Coffees> coffee = coffeesRepository.findById(id);
        if (coffee.isPresent()) {
            Coffees result = coffee.get();
            log.info("This coffee is fetched by ID: " + result);
            return result;
        }
        return null;
    }

    public Long saveOrder(Orders order) {
      return ordersRepository.saveAndFlush(order).getId();
    }

}
