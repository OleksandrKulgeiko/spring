package com.kulgeiko.spring_prep.d_data.transactions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kulgeiko.spring_prep.d_data.transactions.model.User;
import com.kulgeiko.spring_prep.d_data.transactions.test.OuterBean;

public class Main 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("transactions/spring.xml");
    	OuterBean testBean = (OuterBean)ctx.getBean("outerBeanImpl");

    	User user = new User();
    	user.setUsername("johndoe");
    	user.setName("John Doe");
    	
    	try{
    		testBean.testRequired(user);
    	} catch(Exception e){
    		// catch exception raised from transaction rollback
    	}
    	
    	testBean.testRequiresNew(user);

    }
}
