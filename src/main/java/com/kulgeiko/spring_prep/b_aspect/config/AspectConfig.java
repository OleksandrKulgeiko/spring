package com.kulgeiko.spring_prep.b_aspect.config;

import com.kulgeiko.spring_prep.b_aspect.domain.Audience;
import com.kulgeiko.spring_prep.b_aspect.domain.Circus;
import com.kulgeiko.spring_prep.b_aspect.domain.Shapito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by akulgeiko on 11/22/2017.
 */




@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AspectConfig {

    @Bean
    public Audience getAudience(){
        return new Audience();
    }

    @Bean
    public Circus getCircus(){
        Circus c = new Circus();
        return c;
    }

    @Bean
    public Shapito getShapito(){
        Shapito s = new Shapito();
        return s;
    }

}
