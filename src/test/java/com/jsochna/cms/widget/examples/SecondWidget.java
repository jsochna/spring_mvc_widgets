package com.jsochna.cms.widget.examples;

import com.jsochna.cms.widget.annotation.Widget;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

@Widget(name = "second")
public class SecondWidget {

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String hello (ServletRequest request, HttpServletResponse response) {
        return "hello world";
    }
}
