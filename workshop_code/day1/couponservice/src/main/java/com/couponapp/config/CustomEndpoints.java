package com.couponapp.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;

@Configuration
@Endpoint(id = "custom-endpoint")
public class CustomEndpoints {
    @ReadOperation
    public String getCustomData(){
        return "This is custom Data";
    }
}
