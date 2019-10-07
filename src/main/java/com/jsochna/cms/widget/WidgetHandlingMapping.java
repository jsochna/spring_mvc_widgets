package com.jsochna.cms.widget;

import com.jsochna.cms.widget.annotation.Widget;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class WidgetHandlingMapping extends RequestMappingHandlerMapping {

    public static final String CMS_WIDGET_HEADER = "IDC_CMS_WIDGET";

    @Override
    protected boolean isHandler(Class<?> beanType) {
        return AnnotatedElementUtils.hasAnnotation(beanType, Widget.class);
    }

    protected String extractWidgetName(Class beanType) {
        Widget widgetInfo = AnnotatedElementUtils.getMergedAnnotation(beanType, Widget.class);
        return widgetInfo.name();
    }

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo superInfo = super.getMappingForMethod(method, handlerType);
        RequestMappingInfo newInfo = RequestMappingInfo.paths("/").headers("IDC_CMS_WIDGET=" + extractWidgetName(handlerType)).build();
        if (superInfo != null) {
            return newInfo.combine(superInfo);
        } else {
            return superInfo;
        }

    }
}
