package com.valuelogic.kubernetessample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MetricService {

    private final static long ONE_MINUT = 60 * 3600;

    private final Date start = new Date();
    private long counter = 0;

    @PostMapping(path = "/orders")
    public String createOrder() {
        counter++;
        return String.format("Orders made: %s", counter);
    }

    @GetMapping(path = "/metrics")
    public String metrics() {
        if ((new Date().getTime() - start.getTime()) > ONE_MINUT) {
            counter = 0;
        }
        return String.format("# TYPE qps gauge\nqps %s", counter);
    }


}
