package com.kulgeiko.spring_prep.d_data.transactions.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kulgeiko.spring_prep.d_data.transactions.dao.TestDAO;
import com.kulgeiko.spring_prep.d_data.transactions.model.User;

@Service
public class TestDAOImpl implements TestDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

}
