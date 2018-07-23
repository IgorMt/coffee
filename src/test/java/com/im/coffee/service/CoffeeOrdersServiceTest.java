package com.im.coffee.service;

import com.im.coffee.domain.Coffees;
import com.im.coffee.domain.Orders;
import com.im.coffee.repository.CoffeesRepository;
import com.im.coffee.repository.OrdersRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author imaltsev
 * @since 07/05/18
 * <p>
 * This class is the test of Service.
 * Here all test are ignored with Spring BOOT H2 specific to re-create DB on each test
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoffeeOrdersServiceTest {

    @MockBean
    private CoffeesRepository coffeesRepository;

    @MockBean
    private OrdersRepository ordersRepository;

    @Autowired
    private CoffeeOrdersService service;

    Orders order;
    List<Orders> orders;
    Coffees coffee;
    List<Coffees> coffees;

    @Before
    public void setup() {
        orders = new ArrayList<>();
        order = new Orders();
        order.setId(17L);
        order.setStatus("await");
        order.setCreated(LocalDateTime.parse("2018-05-07T10:11:30"));
        order.setUpdated(LocalDateTime.parse("2018-05-07T11:11:30"));
        orders.add(order);
        coffees = new ArrayList<>();
        coffee = new Coffees();
        coffee.setId(21L);
        coffee.setType("capuccino");
        coffee.setCreated(LocalDateTime.parse("2018-05-07T10:11:30"));
        coffee.setUpdated(LocalDateTime.parse("2018-05-07T11:11:30"));
        coffees.add(coffee);
    }

    @Test
    @Ignore
    public void testFetchAllOrders() {
        given(ordersRepository.findAll()).willReturn(orders);
        List<Orders> listOrders = service.fetchAllOrders();
        verify(ordersRepository, times(1)).findAll();
        Assert.assertTrue(listOrders.get(0).getId() == 17L);
    }

    @Test
    @Ignore
    public void testFetchOrderById() {

        given(ordersRepository.findById(1L)).willReturn(Optional.of(order));
        Orders resultOrder = service.fetchOrderById(1L);
        verify(ordersRepository, times(1)).findById(1L);
        Assert.assertTrue(resultOrder.getId() == 17L);
    }

    @Test
    @Ignore
    public void testFetchAllCoffees() {
        given(coffeesRepository.findAll()).willReturn(coffees);
        List<Coffees> listCoffees = service.fetchAllCoffees();
        verify(coffeesRepository, times(1)).findAll();
        Assert.assertTrue(listCoffees.get(0).getId() == 21L);
    }

    @Test
    @Ignore
    public void testFetchCoffeeById() {
        given(coffeesRepository.findById(1L)).willReturn(Optional.of(coffee));
        Coffees resultCoffee = service.fetchCoffeeById(1L);
        verify(coffeesRepository, times(1)).findById(1L);
        Assert.assertTrue(resultCoffee.getId() == 21L);
    }

}
