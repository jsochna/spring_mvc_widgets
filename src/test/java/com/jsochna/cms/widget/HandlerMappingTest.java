package com.jsochna.cms.widget;

import com.jsochna.cms.widget.examples.HelloWorldWidget;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import java.lang.reflect.Method;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HandlerMappingTest extends AbstractHandlerTest{
    @Autowired
    WidgetHandlingMapping mapping;

    @Autowired
    BeanFactory beanFactory;

    @Test
    public void testMapping() {
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = mapping.getHandlerMethods();
        Method method = ReflectionUtils.findMethod(HelloWorldWidget.class, "hello");
        HandlerMethod handlerMethod = new HandlerMethod("helloWorldWidget", beanFactory, method);
        assertThat(handlerMethods.values()).containsAnyOf(handlerMethod);
    }

}
