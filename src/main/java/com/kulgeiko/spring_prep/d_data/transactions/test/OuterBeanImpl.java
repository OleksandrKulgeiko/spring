package com.kulgeiko.spring_prep.d_data.transactions.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kulgeiko.spring_prep.d_data.transactions.dao.TestDAO;
import com.kulgeiko.spring_prep.d_data.transactions.model.User;
import com.kulgeiko.spring_prep.d_data.transactions.test.InnerBean;
import com.kulgeiko.spring_prep.d_data.transactions.test.OuterBean;

@Service
public class OuterBeanImpl implements OuterBean {

	@Autowired
	private TestDAO testDAO;
	
	@Autowired
	private InnerBean innerBean;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void testRequired(User user) {
		testDAO.insertUser(user);
		try{
			innerBean.testRequired();
		} catch(RuntimeException e){
			// handle exception
		}
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void testRequiresNew(User user) {
		testDAO.insertUser(user);
		try{
			innerBean.testRequiresNew();
		} catch(Exception e){
			// handle exception
		}
	}

}
