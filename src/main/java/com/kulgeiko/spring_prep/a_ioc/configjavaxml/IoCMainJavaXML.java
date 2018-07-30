package com.kulgeiko.spring_prep.a_ioc.configjavaxml;

import com.kulgeiko.spring_prep.a_ioc.configjavaxml.stereo.Player;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCMainJavaXML {

    public static void main(String[] args) {

    // ClassPathXmlApplicationContext
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:configJavaXML.xml");

    //Disc disc = context.getBean("disc", Disc.class);
    Player player = context.getBean("player", Player.class);
    player.play();

    // Current VM working directory
    System.out.println("Working Directory = " + System.getProperty("user.dir"));

    }
}

