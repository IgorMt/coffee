package com.im.coffee.repository;

import com.im.coffee.domain.Orders;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrdersRepositoryTest {


    @Autowired
    private OrdersRepository repository;

    @Test
    public void testOrdersFindAll() {
        List<Orders> orders = repository.findAll();
        Assert.assertTrue("Orders list  not null.", orders != null);
        Assert.assertTrue("Orders size > 0", orders.size() > 0);
        Orders order_1 = orders.stream().filter(p -> p.getId() == 1).findAny()                                      // If 'findAny' then return found
                .orElse(null);
        Assert.assertTrue(order_1 != null);
        Assert.assertTrue("Coffees list in Order is not null.", order_1.getCoffees() != null);
        Assert.assertTrue("Coffees list in Order size > 0.", order_1.getCoffees().size() > 0);
    }

    @Test
    public void testOrdersFindByID() {
        Orders order = repository.findById(Long.valueOf(2)).get();
        Assert.assertTrue("Result is not null", order != null);
        Assert.assertEquals(order.getId(), Long.valueOf(2));
        Assert.assertTrue("Coffees list in Order is not null.", order.getCoffees() != null);
        Assert.assertTrue("Coffees list in Order size > 0.", order.getCoffees().size() > 0);
    }

}
