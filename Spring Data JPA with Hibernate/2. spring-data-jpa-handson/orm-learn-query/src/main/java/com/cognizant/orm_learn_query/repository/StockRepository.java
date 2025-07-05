package com.cognizant.orm_learn_query.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn_query.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findByCodeAndDateBetween(String code, Date start, Date end);

    List<Stock> findByCodeAndCloseGreaterThan(String code, double close);

    List<Stock> findByCodeAndVolumeLessThan(String code, long volume);
}
