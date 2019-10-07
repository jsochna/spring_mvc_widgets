package com.jsochna.cms.widget.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Widget {
    @AliasFor(annotation = Component.class, attribute = "value")
    String name();
}