package com.kulgeiko.spring_prep.a_ioc.configjava.stereo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by akulgeiko on 12/12/2017.
 */

@PropertySource("classpath:appl.properties")
public class Disc {

    //@Value("${disc.name:Aqua}")
    //@Value("#{'disc.name'}")
    private String name;

    @Value("${disc.format}")
    //@Value("#{'disc.format'}")
    private String format;


    private void reviewDisc(){
        System.out.print("I'm quite round disc");
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
