package com.jsochna.cms.widget;

import com.jsochna.cms.widget.annotation.Widget;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.servlet.mvc.condition.HeadersRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class WidgetHandlingMapping extends RequestMappingHandlerMapping {

    public static final String WIDGET_PATH_PREFIX = "/widget/";
    public static final String CMS_WIDGET_HEADER = "IDC_CMS_WIDGET";

    @Override
    protected boolean isHandler(Class<?> beanType) {
        return AnnotatedElementUtils.hasAnnotation(beanType, Widget.class);
    }

    @Override
    protected void registerHandlerMethod(Object handler, Method method, RequestMappingInfo mapping) {

        super.registerHandlerMethod(handler, method, mapping);
    }
/*
    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mapping = super.getMappingForMethod(method, handlerType);
        PatternsRequestCondition widgetPrefix = new PatternsRequestCondition(WIDGET_PATH_PREFIX + extractWidgetName(handlerType) + "/**");

        RequestMappingInfo resultRequestMappingInfo = new RequestMappingInfo(
                widgetPrefix,
                mapping.getMethodsCondition(),
                mapping.getParamsCondition(),
                mapping.getHeadersCondition(), //.combine(headersRequestCondition),
                mapping.getConsumesCondition(),
                mapping.getProducesCondition(),
                mapping.getCustomCondition());
        return resultRequestMappingInfo;
    }
*/
    @Override
    protected RequestCondition<HeadersRequestCondition> getCustomTypeCondition(Class<?> handlerType) {
        HeadersRequestCondition headersRequestCondition = new HeadersRequestCondition(CMS_WIDGET_HEADER +"=" + extractWidgetName(handlerType));
        return headersRequestCondition;
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        return getCustomTypeCondition(method.getDeclaringClass());
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
