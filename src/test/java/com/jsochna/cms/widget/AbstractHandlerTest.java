package com.jsochna.cms.widget;

import com.jsochna.cms.widget.examples.ClassPathScanMarker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;

@ContextConfiguration(classes = AbstractHandlerTest.WidgetHandlerConfig.class)
abstract class AbstractHandlerTest extends AbstractJUnit4SpringContextTests {


    @Configuration
    @ComponentScan(basePackageClasses = ClassPathScanMarker.class)
    public static class WidgetHandlerConfig {
        @Bean
        public HandlerMapping widgetMapping() {
            return new WidgetHandlingMapping();
        }

        @Bean
        public HandlerAdapter widgetHandlerAdapter() {
            return new WidgetHandlerAdapter();
        }

    }

}
