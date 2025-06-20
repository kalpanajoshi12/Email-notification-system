package com.example.email_notification_system.service;

import com.example.email_notification_system.model.EmailRequest;

public interface  EmailService {
    void sendEmail(EmailRequest request);
}
