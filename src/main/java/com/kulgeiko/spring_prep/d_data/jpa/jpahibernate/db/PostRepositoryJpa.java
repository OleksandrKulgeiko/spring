package com.kulgeiko.spring_prep.d_data.jpa.jpahibernate.db;

/**
 * Created by akulgeiko on 7/20/2018.
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.kulgeiko.spring_prep.d_data.jpa.jpahibernate.domain.Post;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryJpa implements PostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public long count() {
        return findAll().size();
    }

    public List<Post> findRecent() {
        return findRecent(10);
    }

    public List<Post> findRecent(int count) {
        return (List<Post>) entityManager.createQuery("select s from Post s order by s.postedTime desc")
                .setMaxResults(count)
                .getResultList();
    }

    public Post findOne(long id) {
        return entityManager.find(Post.class, id);
    }

    public Post save(Post spittle) {
        entityManager.persist(spittle);
        return spittle;
    }

    public List<Post> findBySpitterId(long spitterId) {
        return (List<Post>) entityManager.createQuery("select s from Post s, Blogger sp where s.blogger = sp and sp.id=? order by s.postedTime desc")
                .setParameter(1, spitterId)
                .getResultList();
    }

    public void delete(long id) {
        entityManager.remove(findOne(id));
    }

    public List<Post> findAll() {
        return (List<Post>) entityManager.createQuery("select s from Post s").getResultList();
    }

}

