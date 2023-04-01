package com.repair.mart.root.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailUtils {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sentMessage(String to, String subject, String text, List<String> list) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ruwanliyanage2021@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setCc(list.toArray(new String[0]));
        javaMailSender.send(message);
    }
}
