package com.kulgeiko.spring_prep.a_ioc.configxml.stereo;

/**
 * Created by akulgeiko on 12/12/2017.
 */

public class Player {
    private Disc disc;

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