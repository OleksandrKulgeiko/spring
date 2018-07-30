package com.kulgeiko.spring_prep.a_ioc.configxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.kulgeiko.spring_prep.a_ioc.configxml.stereo.Player;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by akulgeiko on 12/16/2017.
 */
public class IoCMainXML {

    public static void main(String[] args) {


        // ClassPathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config.xml");

        // FileSystemXmlApplicationContext
        // FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/config.xml");
        // FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("file:C:\\Users\\AKulgeiko\\Desktop\\config\\Spring_folders\\folder1\\config.xml");

        // FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("classpath:C:/Users/AKulgeiko/Desktop/config/Spring/src/main/resources/config.xml");
        //FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("file:F:\\1_Certefications\\3_Spring\\Test_preparation_2\\Spring\\src\\main\\resources");


        // GetBean
        // Player player = context.getBean("player", Player.class);
        // Player player = (Player) context.getBean("player");
        Player player = (Player) context.getBean("player", new Player());
        player.play();

        Vehicle vehicle = context.getBean("vehicle", Vehicle.class);
        System.out.println(vehicle);


        // Current VM working directory
        System.out.println("Working Directory = " + System.getProperty("user.dir"));


    }
}