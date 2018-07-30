package com.kulgeiko.spring_prep.d_data.dataaccess;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

/**
 * Created by akulgeiko on 11/27/2017.
 */

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String email;

    public String toString(){
        return id + " " + name + " " + email;
    }
}