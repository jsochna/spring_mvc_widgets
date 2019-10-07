package com.jsochna.cms.widget.examples;

import com.jsochna.cms.widget.annotation.Widget;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Widget(name = "hello")
public class HelloWorldWidget {

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String hello () {
        return "hello world";
    }
}
