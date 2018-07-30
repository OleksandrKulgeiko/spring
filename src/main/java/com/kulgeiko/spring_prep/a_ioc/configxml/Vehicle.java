package com.kulgeiko.spring_prep.a_ioc.configxml;

/**
 * Created by akulgeiko on 7/26/2018.
 */
public class Vehicle {

    private String producer;
    private boolean electricCar;

    public Vehicle(String producer, boolean electricCar){
        this.producer = producer;
        this.electricCar = electricCar;
    }

    @Override
    public String toString(){
        return "This is " + this.producer + "; Electro car = " + this.electricCar;
    }
}
