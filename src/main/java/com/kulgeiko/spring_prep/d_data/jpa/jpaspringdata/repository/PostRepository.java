package com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.repository;

import java.util.List;

import com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {

  List<Post> findByBloggerId(long spitterId);
}
