package com.cognizant.orm_learn_query.repository;

import com.cognizant.orm_learn_query.model.Attempt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AttemptRepository extends CrudRepository<Attempt, Integer> {

    @Query("SELECT a FROM Attempt a " +
           "JOIN FETCH a.user u " +
           "JOIN FETCH a.questions aq " +
           "JOIN FETCH aq.question q " +
           "JOIN FETCH aq.attemptOptions ao " +
           "JOIN FETCH ao.option o " +
           "WHERE a.id = :attemptId AND u.id = :userId")
    Attempt getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
