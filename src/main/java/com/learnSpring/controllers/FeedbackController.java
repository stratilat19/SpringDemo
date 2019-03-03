package com.learnSpring.controllers;

import com.learnSpring.db.entities.Feedback;
import com.learnSpring.db.repositories.FeedbackRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@Log4j2
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @PostMapping("/contacts")
    public String create(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String phone,
                           @RequestParam String message){
        log.info("FEEDBACK name = " + name + " email = " + email + " phone = " + phone + " message = " + message);

        Feedback feedback = new Feedback();
        feedback.setName(name);
        feedback.setEmail(email);
        feedback.setPhone(phone);
        feedback.setMessage(message);
        feedbackRepository.save(feedback);

        return "contacts";
    }

    @GetMapping("/feedback")
    public @ResponseBody
    Iterable<Feedback> getAll() {
        // This returns a JSON or XML with the feedback
        return feedbackRepository.findAll();
    }

    @GetMapping("/feedback/{id}")
    public @ResponseBody
    Optional<Feedback> getById(@PathVariable String id) {
        // This returns a JSON or XML with the feedback
        return feedbackRepository.findById(Integer.valueOf(id));
    }


    @GetMapping("/feedback/email/{email}")
    public @ResponseBody
    Iterable<Feedback> getByEmail(@PathVariable String email) {
        // This returns a JSON or XML with the feedback
        return feedbackRepository.findByEmail(email);
    }

    @GetMapping("/feedback/email_phone/{email}/{phone}")
    public @ResponseBody
    Iterable<Feedback> getByEmailAndPhone(@PathVariable String email,
                                                  @PathVariable String phone) {
        // This returns a JSON or XML with the feedback
        return feedbackRepository.findByEmailAndPhone(email, phone);
    }

    @GetMapping("/feedback/email_phonesnippet/{email}/{phoneSnippet}")
    public @ResponseBody
    Iterable<Feedback> getByEmailAndPhoneContaining(@PathVariable String email,
                                                            @PathVariable String phoneSnippet) {
        // This returns a JSON or XML with the feedback
        return feedbackRepository.findByEmailAndPhoneContaining(email, phoneSnippet);
    }

}
