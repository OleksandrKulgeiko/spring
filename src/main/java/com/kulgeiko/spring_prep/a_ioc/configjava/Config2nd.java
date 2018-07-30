package com.kulgeiko.spring_prep.a_ioc.configjava;


import com.kulgeiko.spring_prep.a_ioc.configjava.stereo.Disc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2nd {

    @Bean(name = "disc2")
    public Disc getDisc(){
        Disc disc = new Disc();
        disc.setName("Aqua");
        return disc;
    }
}
