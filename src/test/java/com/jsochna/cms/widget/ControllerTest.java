package com.jsochna.cms.widget;

import com.jsochna.cms.widget.examples.HelloWorldWidget;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;

import static org.hamcrest.core.Is.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration()
public class ControllerTest extends AbstractHandlerTest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testGet() {
        RequestEntity callWidget = RequestEntity.get(URI.create("http://localhost:" + port))
                .header(WidgetHandlingMapping.CMS_WIDGET_HEADER, "helloWorld")
                .build();
        ResponseEntity<String> widgetResponse = restTemplate.exchange(callWidget, String.class);
        Assert.assertThat(widgetResponse.getStatusCode(), is(HttpStatus.OK));
        Assert.assertThat(widgetResponse.getBody(), is("hello world"));

    }

    @Configuration
    public static class Config {
        @Bean
        Object simpleWidget() {
            return new HelloWorldWidget();
        }


    }
}
