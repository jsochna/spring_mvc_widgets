package com.jsochna.cms.widget.examples;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ControllerNotWidget {

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String hello (ServletRequest request, HttpServletResponse response) {
        return "hello world";
    }
}
