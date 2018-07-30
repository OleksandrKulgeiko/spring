package com.kulgeiko.spring_prep.a_ioc.configjava;

import com.kulgeiko.spring_prep.a_ioc.configjava.stereo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * Created by akulgeiko on 12/12/2017.
 */


@Configuration
@PropertySource("classpath:appl.properties")
public class Config {

    @Autowired
    Environment env;

    @Autowired
    @Qualifier("musicFan1")
    MusicFan musicFan;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "disc")
    public Disc getDisc(){
        Disc disc = new Disc();
        //disc.setName("Okean elzy");
        //disc.setFormat("MP3");

        //disc.setName(env.getProperty("disc.name"));
        //disc.setFormat(env.getProperty("disc.format"));

        return disc;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    Player getPlayer(){
        return new Player(getDisc());
    }

    @Bean
    @Scope("singleton")
    MusicFan musicFan1(){
        return new MusicFan();
    }

    @Bean
    @Lazy
    MusicFan musicFan2(){
        return new MusicFan();
    }


    @Bean
    @Conditional(MagicExist.class)
    MagicConditionalBean conditionalBean(){
        return new MagicConditionalBean();
    }


}
