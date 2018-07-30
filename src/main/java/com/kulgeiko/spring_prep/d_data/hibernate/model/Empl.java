package com.kulgeiko.spring_prep.d_data.hibernate.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * Created by akulgeiko on 1/8/2018.
 */

@Entity
@Table(name = "EMP")
public class Empl {

    @Column(name = "EMPNO")
    private int empno;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }
}
