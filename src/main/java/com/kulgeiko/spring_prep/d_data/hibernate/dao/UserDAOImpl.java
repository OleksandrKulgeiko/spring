package com.kulgeiko.spring_prep.d_data.hibernate.dao;

/**
 * Created by akulgeiko on 1/8/2018.
 */

import java.util.List;

import com.kulgeiko.spring_prep.d_data.hibernate.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    //@Transactional
    public List<User> getAllUsers() {
        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return listUser;
    }

}