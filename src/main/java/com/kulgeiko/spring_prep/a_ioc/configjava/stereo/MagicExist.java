package com.kulgeiko.spring_prep.a_ioc.configjava.stereo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExist implements Condition {
    public boolean matches(ConditionContext var1, AnnotatedTypeMetadata var2){
        return false;
    }
}
