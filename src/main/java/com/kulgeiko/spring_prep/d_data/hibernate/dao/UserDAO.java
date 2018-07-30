package com.kulgeiko.spring_prep.d_data.hibernate.dao;

/**
 * Created by akulgeiko on 1/8/2018.
 */
import com.kulgeiko.spring_prep.d_data.hibernate.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDAO {

    @Transactional
    List<User> getAllUsers();
}
