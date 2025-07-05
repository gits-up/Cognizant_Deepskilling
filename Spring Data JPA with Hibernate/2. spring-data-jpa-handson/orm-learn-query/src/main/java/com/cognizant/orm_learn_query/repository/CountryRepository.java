package com.cognizant.orm_learn_query.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn_query.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findByNameContainingIgnoreCase(String text);

    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String text);

    List<Country> findByNameStartingWith(String prefix);
}
