package com.kulgeiko.spring_prep.d_data.jpa.jpahibernate.db;

import java.util.List;
import com.kulgeiko.spring_prep.d_data.jpa.jpahibernate.domain.Post;

public interface PostRepository {
    long count();
    List<Post> findRecent();
    List<Post> findRecent(int count);
    Post findOne(long id);
    Post save(Post spittle);
    List<Post> findBySpitterId(long spitterId);
    void delete(long id);
}