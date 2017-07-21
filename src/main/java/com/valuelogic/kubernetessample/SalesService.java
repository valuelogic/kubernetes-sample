package com.valuelogic.kubernetessample;

import com.valuelogic.kubernetessample.monitoring.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SalesService {

    @Autowired
    private Metrics metrics;

    @PostMapping(path = "/sales")
    public double saleNewStuff() {
        double value = Math.random() * 1000;
        metrics.value("sales.product.value", value);
        return value;
    }

}
