package com.im.coffee.repository;

import com.im.coffee.domain.Coffees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeesRepository extends JpaRepository<Coffees, Long> {
}
