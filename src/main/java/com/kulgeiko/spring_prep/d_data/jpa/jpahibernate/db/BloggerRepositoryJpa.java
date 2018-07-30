package com.kulgeiko.spring_prep.d_data.jpa.jpahibernate.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.kulgeiko.spring_prep.d_data.jpa.jpahibernate.domain.Blogger;
import org.springframework.stereotype.Repository;

@Repository
public class BloggerRepositoryJpa implements BloggerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public long count() {
        return findAll().size();
    }

    public Blogger save(Blogger Blogger) {
        entityManager.persist(Blogger);
        return Blogger;
    }

    public Blogger findOne(long id) {
        return entityManager.find(Blogger.class, id);
    }

    public Blogger findByUsername(String username) {
        return (Blogger) entityManager.createQuery("select s from Blogger s where s.username=?").setParameter(1, username).getSingleResult();
    }

    public List<Blogger> findAll() {
        return (List<Blogger>) entityManager.createQuery("select s from Blogger s").getResultList();
    }

}
