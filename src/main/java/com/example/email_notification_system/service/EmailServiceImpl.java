package com.example.email_notification_system.service;

import com.example.email_notification_system.model.EmailRequest;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender emailSender;

    @Override
    @Async("taskExecutor")
    public void sendEmail(EmailRequest request) {

        try{

            System.out.println("Thread Name : " + Thread.currentThread().getName() + " is processing email address " + request.getTo());
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setTo(request.getTo());
            helper.setSubject(request.getSubject());
            helper.setText(request.getBody());
            emailSender.send(message);
            Thread.sleep(5000);
            System.out.println("Email send to - " + Thread.currentThread().getName() + "finished email to " + request.getTo());
        }catch (Exception e){
            System.out.println("Email failed by this message" + e.getMessage());
        }
    }
}
