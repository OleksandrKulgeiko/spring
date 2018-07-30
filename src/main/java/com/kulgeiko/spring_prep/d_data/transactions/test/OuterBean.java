package com.kulgeiko.spring_prep.d_data.transactions.test;

import com.kulgeiko.spring_prep.d_data.transactions.model.User;

public interface OuterBean {

	void testRequired(User user);
	
	void testRequiresNew(User user);

}
