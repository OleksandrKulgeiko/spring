package com.kulgeiko.spring_prep.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MailMain {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigMail.class);
        EmailServiceImpl emailService = context.getBean("emailServiceImpl", EmailServiceImpl.class);

        String to = "akulgeiko@gmail.com";
        String subject = "Test";
        String text = "Test";

        emailService.sendSimpleMessage(to, subject, text);


    }


}
