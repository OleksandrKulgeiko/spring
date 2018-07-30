package com.kulgeiko.spring_prep.d_data.jpa.jpaspringdata.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Blogger {

    private Blogger() {}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="fullname")
    private String fullName;

    @Column(name="email")
    private String email;

    @Column(name="updateByEmail")
    private boolean updateByEmail;

    @Column(name="status")
    private String status;

    @OneToMany(targetEntity=Post.class, fetch=FetchType.EAGER, mappedBy="spitter")
    private List<Post> posts;

    public Blogger(Long id, String username, String password, String fullName,
                   String email, boolean updateByEmail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.updateByEmail = updateByEmail;
        this.status = "Newbie";
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isUpdateByEmail() {
        return updateByEmail;
    }

    public String getStatus() {
        return status;
    }
    public List<Post> getPosts() {
        return posts;
    }
}
