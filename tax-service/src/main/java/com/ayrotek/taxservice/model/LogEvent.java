package com.ayrotek.taxservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public final class LogEvent {
    public static final String LOG_ID = "_id";
    public static final String LOG_TIME = "_createDate";
    public static final String LOG_REQUEST_HEADERS = "requestHeaders";
    public static final String LOG_REQUEST_BODY = "requestBody";
    public static final String LOG_STATUS_CODE = "statusCode";
    public static final String LOG_RESPONSE_HEADERS = "responseHeaders";
    public static final String LOG_RESPONSE_BODY = "responseBody";

    private Map<String, String> logEvent;

    // explicit constructor for json serialization
    public LogEvent() {
        this.logEvent = new HashMap<>();
    }

}