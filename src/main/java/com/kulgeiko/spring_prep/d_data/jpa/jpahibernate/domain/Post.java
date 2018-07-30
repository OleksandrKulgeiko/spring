package com.kulgeiko.spring_prep.d_data.jpa.jpahibernate.domain;

/**
 * Created by akulgeiko on 7/20/2018.
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Post {

    private Post() {}

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="blogger")
    private Blogger blogger;

    @Column
    private String message;

    @Column
    private Date postedTime;

    public Post(Long id, Blogger blogger, String message, Date postedTime) {
        this.id = id;
        this.blogger = blogger;
        this.message = message;
        this.postedTime = postedTime;
    }

    public Long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public Date getPostedTime() {
        return this.postedTime;
    }

    public Blogger getBlogger() {
        return this.blogger;
    }

}
