package com.cognizant.orm_learn_query.service;

import com.cognizant.orm_learn_query.model.Attempt;
import com.cognizant.orm_learn_query.repository.AttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptService {

    @Autowired
    private AttemptRepository attemptRepository;

    public Attempt getAttempt(int userId, int attemptId) {
        return attemptRepository.getAttempt(userId, attemptId);
    }
}
