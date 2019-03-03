package com.learnSpring.db.repositories;

import com.learnSpring.db.entities.Feedback;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {

    List<Feedback> findByEmail(String email);

    List<Feedback> findByEmailAndPhone(String email, String phone);

    List<Feedback> findByEmailAndPhoneContaining(String email, String phoneSnippet);

}
