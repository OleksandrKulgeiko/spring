package com.kulgeiko.spring_prep.b_aspect.domain;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by akulgeiko on 11/22/2017.
 */

@Aspect
public class Audience {
    //@Pointcut("execution(* *(..))")
    //@Pointcut("execution(* com.kulgeiko.spring_prep.b_aspect.domain.Shapito.perform(..)) && execution(* com.kulgeiko.spring_prep.b_aspect.domain.Circus.perform(..))")
    // @Pointcut("execution(* com.kulgeiko.spring_prep.b_aspect.domain.Circus.perform(..))")
    @Pointcut("execution(* com.kulgeiko.spring_prep.b_aspect.domain.Circus.perform())")
    public void perf(){}

    @Before("perf()")
    private void silencePhones() {
        System.out.println("turning-OFF cell phones");
    }

    @After("perf()")
    private void deSilencePhones() {
        System.out.println("turning-ON cell phones");
    }
}
