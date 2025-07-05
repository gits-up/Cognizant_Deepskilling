package com.cognizant.orm_learn_query.repository;

import com.cognizant.orm_learn_query.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
