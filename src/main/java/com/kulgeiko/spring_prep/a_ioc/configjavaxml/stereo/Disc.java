package com.kulgeiko.spring_prep.a_ioc.configjavaxml.stereo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by akulgeiko on 12/12/2017.
 */

//@PropertySource("classpath:appl.properties")

@Component
public class Disc {

    //@Value("${disc.name}")
    //@Value("#{'disc.name'}")
    private String name;

    //@Value("${disc.format}")
    //@Value("#{'disc.format'}")
    private String format;

    @PostConstruct
    public void initDisc(){
        System.out.println("I'm quite round disc");
        this.name = "Okean Elzy";
        this.format = "MP3";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
