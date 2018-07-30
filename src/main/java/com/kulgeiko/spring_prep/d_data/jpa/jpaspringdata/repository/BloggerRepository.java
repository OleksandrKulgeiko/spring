package com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.repository;

/**
 * Created by akulgeiko on 7/20/2018.
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.model.Blogger;

/**
 * Repository interface with operations for {@link Blogger} persistence.
 * @author habuma
 */
public interface BloggerRepository extends JpaRepository<Blogger, Long>, BloggerSweeper {

    Blogger findByUsername(String username);

    List<Blogger> findByUsernameOrFullNameLike(String username, String fullName);
}
