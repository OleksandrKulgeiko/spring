package com.kulgeiko.spring_prep.d_data.jpa.jpahibernate.db;


import com.kulgeiko.spring_prep.d_data.jpa.jpahibernate.domain.Blogger;
import java.util.List;

public interface BloggerRepository {
    long count();
    Blogger save(Blogger Blogger);
    Blogger findOne(long id);
    Blogger findByUsername(String username);
    List<Blogger> findAll();
}