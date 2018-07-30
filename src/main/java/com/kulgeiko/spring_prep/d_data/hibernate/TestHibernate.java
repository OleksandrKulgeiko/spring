package com.kulgeiko.spring_prep.d_data.hibernate;

import com.kulgeiko.spring_prep.d_data.hibernate.dao.UserDAO;
import com.kulgeiko.spring_prep.d_data.hibernate.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * Created by akulgeiko on 1/8/2018.
 */
public class TestHibernate {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        // System.out.println(Arrays.asList(ctx.getBeanDefinitionNames()));

        UserDAO userDAOImpl = (UserDAO)ctx.getBean("userDAOImpl");
        List<User> empl = userDAOImpl.getAllUsers();

        for(User user : empl)
            System.out.println(user.getEmpno() + " " + user.getName() + " " + user.getEmail());
    }

}
