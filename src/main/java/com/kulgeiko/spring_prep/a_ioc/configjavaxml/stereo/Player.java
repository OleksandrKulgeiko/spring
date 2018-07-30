package com.kulgeiko.spring_prep.a_ioc.configjavaxml.stereo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by akulgeiko on 12/12/2017.
 */

@Component
public class Player {

    @Autowired
    Disc disc;

    //public Player(Disc disc){
    //    this.disc = disc;
    //}

    public Disc getDisc() {
        return disc;
    }

    public void setDisc(Disc disc) {
        this.disc = disc;
    }

    public void play() {
        System.out.println("Playing music from " + this.disc.getName());
    }
}