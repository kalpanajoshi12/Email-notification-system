package com.example.email_notification_system.controller;

import com.example.email_notification_system.model.EmailRequest;
import com.example.email_notification_system.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/email")
@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;


    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        emailService.sendEmail(request);
      return   ResponseEntity.ok("Email sending started...");
    }
}
