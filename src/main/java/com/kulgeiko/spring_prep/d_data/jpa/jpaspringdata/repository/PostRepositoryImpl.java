package com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.repository;

import com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.model.Post;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class PostRepositoryImpl implements PostRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  public List<Post> findRecent() {
    return findRecent(10);
  }

  public List<Post> findRecent(int count) {
    return (List<Post>) entityManager.createQuery("select s from Spittle s order by s.postedTime desc")
        .setMaxResults(count)
        .getResultList();
  }
  
}
