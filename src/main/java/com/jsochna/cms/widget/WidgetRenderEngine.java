package com.jsochna.cms.widget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


@Component
public class WidgetRenderEngine {
    @Autowired
    WidgetHandlerAdapter adapter;
    @Autowired
    WidgetHandlingMapping mapping;


    public String renderWidget(WidgetInstance widgetInstance, ServletRequest request, ServletResponse response) {
        return null;
    }
}
