package com.im.coffee.controller;

import com.im.coffee.domain.Coffees;
import com.im.coffee.domain.Orders;
import com.im.coffee.service.CoffeeOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author imaltsev
 * @since 06/05/18
 * <p>
 * This class is the Server Rest Controller, returns serialized JSON responses.
 */
@RestController
@RequestMapping("/coffee")
public class CoffeeOrdersController {

    @Autowired
    private CoffeeOrdersService coffeeOrdersService;

    /**
     * Rest server method, get request and return all coffees
     *
     * @return List<Coffees>
     */
    @RequestMapping(value = "/fetchallcoffees.do", method = RequestMethod.GET)
    public List<Coffees> fetchAllCoffees() {
        return coffeeOrdersService.fetchAllCoffees();
    }

    /**
     * Rest server method, get request and return one coffee by id
     *
     * @return Coffees
     */
    @RequestMapping(value = "/fetchcoffeebyid.do", method = RequestMethod.GET)
    public Coffees fetchCoffeeById(@RequestParam(value = "id") long id) {
        return coffeeOrdersService.fetchCoffeeById(id);
    }

    /**
     * Rest server method, get request and return all orders
     *
     * @return List<Orders>
     */
    @RequestMapping(value = "/fetchallorders.do", method = RequestMethod.GET)
    public List<Orders> fetchAllOrders() {
        return coffeeOrdersService.fetchAllOrders();
    }

    /**
     * Rest server method, get request and return one order by id
     *
     * @return Orders
     */
    @RequestMapping(value = "/fetchorderbyid.do", method = RequestMethod.GET)
    public Orders fetchOrderById(@RequestParam(value = "id") long id) {
        return coffeeOrdersService.fetchOrderById(id);
    }

    /**
     * Rest server method, save order
     *
     * @param request POST request body parameter
     * @return Long id
     */
    @RequestMapping(value = "/saveorder.do", method = RequestMethod.POST)
    public Long saveOrder(@RequestBody final Orders request) {
        return coffeeOrdersService.saveOrder(request);
    }

}
