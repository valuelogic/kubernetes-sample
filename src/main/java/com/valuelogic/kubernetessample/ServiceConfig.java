package com.valuelogic.kubernetessample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Value("${ping.message:Hello!}")
    private String message;

    public String getMessage() {
        return message;
    }

}
