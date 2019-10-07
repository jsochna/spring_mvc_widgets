package com.jsochna.cms.widget.examples;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AbstractWidgetWithMethod {
    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String hello () {
        return "hello world";
    }
}
