package com.jsochna.cms.widget;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Map;

@Data
@Getter
@Builder
public class WidgetInstance {
    private String widgetName;
    private Map<String, String> widgetParameters;

}
