package com.im.coffee.repository;

import com.im.coffee.domain.Coffees;
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
public class CoffeesRepositoryTest {

    @Autowired
    private CoffeesRepository repository;

    @Test
    public void testCoffeesFindAll() {
        List<Coffees> coffees = repository.findAll();
        Assert.assertTrue("Coffees list  not null.", coffees != null);
        Assert.assertTrue("Coffees size > 0", coffees.size() > 0);
        Coffees coffee_1 = coffees.stream().filter(p -> p.getId() == 1).findAny()                                      // If 'findAny' then return found
                .orElse(null);
        Assert.assertTrue(coffee_1 != null);
    }

    @Test
    public void testCoffeesFindByID() {
        Coffees coffee = repository.findById(Long.valueOf(2)).get();
        Assert.assertTrue("Result is not null", coffee != null);
        Assert.assertEquals(coffee.getId(), Long.valueOf(2));
    }

}
