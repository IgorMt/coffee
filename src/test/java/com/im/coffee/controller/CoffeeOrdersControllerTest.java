package com.im.coffee.controller;

import com.im.coffee.domain.Coffees;
import com.im.coffee.domain.Orders;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CoffeeOrdersController.class)
public class CoffeeOrdersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoffeeOrdersController service;

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
        order.setCoffees(coffees);
    }

    @Test
    public void testRestFetchAllOrders() throws Exception {

        given(service.fetchAllOrders())
                .willReturn(orders);
        MvcResult result = mockMvc.perform(get("/coffee/fetchallorders.do"))
                .andExpect(status().isOk()).andReturn();
        verify(service).fetchAllOrders();

        Assert.assertEquals(result.getResponse().getContentAsString(),
                "[{\"id\":17,\"status\":\"await\",\"created\":\"2018-05-07T10:11:30Z\"," +
                        "\"updated\":\"2018-05-07T11:11:30Z\",\"coffees\":[{\"id\":21,\"type\":\"capuccino\"," +
                        "\"created\":\"2018-05-07T10:11:30Z\",\"updated\":\"2018-05-07T11:11:30Z\"}]}]");
    }

    @Test
    public void testRestFetchOrderById() throws Exception {

        given(service.fetchOrderById(1L))
                .willReturn(order);
        MvcResult result = mockMvc.perform(get("/coffee/fetchorderbyid.do?id={id}", 1L))
                .andExpect(status().isOk()).andReturn();
        verify(service).fetchOrderById(1L);

        Assert.assertEquals(result.getResponse().getContentAsString(),
                "{\"id\":17,\"status\":\"await\",\"created\":\"2018-05-07T10:11:30Z\"," +
                        "\"updated\":\"2018-05-07T11:11:30Z\",\"coffees\":[{\"id\":21,\"type\":\"capuccino\"," +
                        "\"created\":\"2018-05-07T10:11:30Z\",\"updated\":\"2018-05-07T11:11:30Z\"}]}");
    }

    @Test
    public void testRestFetchAllCoffees() throws Exception {

        given(service.fetchAllCoffees())
                .willReturn(coffees);
        MvcResult result = mockMvc.perform(get("/coffee/fetchallcoffees.do"))
                .andExpect(status().isOk()).andReturn();
        verify(service).fetchAllCoffees();

        Assert.assertEquals(result.getResponse().getContentAsString(),
                "[{\"id\":21,\"type\":\"capuccino\",\"created\":\"2018-05-07T10:11:30Z\"," +
                        "\"updated\":\"2018-05-07T11:11:30Z\"}]");
    }

    @Test
    public void testRestFetchCoffeeById() throws Exception {

        given(service.fetchCoffeeById(1L))
                .willReturn(coffee);
        MvcResult result = mockMvc.perform(get("/coffee/fetchcoffeebyid.do?id={id}", 1L))
                .andExpect(status().isOk()).andReturn();
        verify(service).fetchCoffeeById(1L);

        Assert.assertEquals(result.getResponse().getContentAsString(),
                "{\"id\":21,\"type\":\"capuccino\",\"created\":\"2018-05-07T10:11:30Z\"," +
                        "\"updated\":\"2018-05-07T11:11:30Z\"}");
    }

}
