package com.mugishap.templates.springboot.v1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendResetPasswordMail(String toEmail, String names, String activationCodes) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("precieuxmugisha@gmail.com");
        message.setTo(toEmail);
        message.setText("Dear " + names + "!\n" +
                "\n" +
                "You've requested to reset password to NE Springboot Template, " +
                "your verification code is " + activationCodes + ". \n" +
                "\n" +
                "This code expires in 5 minutes.\n" +
                "\n" +
                "If you have any questions, send us an email precieuxmugisha@gmail.com.\n" +
                "\n" +
                "We’re glad you’re here!\n" +
                "\n");
        message.setSubject("NE SPRINGBOOT TEMPLATE VERIFICATION CODE");
        mailSender.send(message);
    }
}