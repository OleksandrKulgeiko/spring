package com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.repository;

import com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.model.Post;

import java.util.List;


public interface PostRepositoryCustom {

  List<Post> findRecent();

  List<Post> findRecent(int count);

}