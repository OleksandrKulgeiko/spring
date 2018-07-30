package com.kulgeiko.spring_prep.a_ioc.configjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.kulgeiko.spring_prep.a_ioc.configjava.stereo.Disc;
import com.kulgeiko.spring_prep.a_ioc.configjava.stereo.Player;

/**
 * Created by akulgeiko on 12/12/2017.
 */
public class IoCMain {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Player player = context.getBean("getPlayer",Player.class);

        Disc disc = player.getDisc();

        System.out.println(disc.getName());
        System.out.println(disc.getFormat());


        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName + " : " + context.getBean(beanName).getClass().toString());
        }
    }
}
