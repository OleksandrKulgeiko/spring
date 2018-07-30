package com.kulgeiko.spring_prep.b_aspect;

import com.kulgeiko.spring_prep.b_aspect.config.AspectConfig;
import com.kulgeiko.spring_prep.b_aspect.domain.Circus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by akulgeiko on 11/22/2017.
 */
public class RunPerformance {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);

        // Print Context content
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName + " : " + context.getBean(beanName).getClass().toString());
        }



        Circus circus = context.getBean("getCircus",Circus.class);
        circus.perform();

        //Shapito shapito = context.getBean(Shapito.class);
        //shapito.perform();


        /*
        BasicConfigurator.configure();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/knight.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
        */
    }
}
