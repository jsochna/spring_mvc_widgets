package com.jsochna.cms.widget.examples;

import com.jsochna.cms.widget.annotation.Widget;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Widget(name = "multiple")
public class MultipleMappingsController {
    @GetMapping
    public String get() {
        return "multiple-get";
    }

    @PostMapping
    public String post() {
        return "multiple-post";
    }
}
