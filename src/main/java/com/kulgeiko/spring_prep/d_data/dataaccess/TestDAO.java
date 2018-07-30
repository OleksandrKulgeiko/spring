package com.kulgeiko.spring_prep.d_data.dataaccess;

/**
 * Created by akulgeiko on 11/27/2017.
 */
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDAO {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        EmployeeDao dao = (EmployeeDao)ctx.getBean(EmployeeDao.class);
        List<Employee> list = dao.getAllEmployeesRowMapper();

        for(Employee e:list)
            System.out.println(e);
    }
}
