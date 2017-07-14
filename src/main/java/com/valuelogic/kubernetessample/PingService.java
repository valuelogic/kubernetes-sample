package com.valuelogic.kubernetessample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PingService {

    private final UUID id = UUID.randomUUID();
    private boolean healthy = true;
    private boolean ready = true;


    @GetMapping(path = "/hello")
    public String ping() {
        if (!healthy) {
            return String.format("[%s] I'm sick!", id);
        } else if (!ready) {
            return String.format("[%s] Dude, I'm busy - leave me alone!", id);
        } else {
            return String.format("[%s] Greetings K8s fans!", id);
        }
    }

    @GetMapping(path = "/health")
    public boolean health() {
        return healthy;
    }

    @PostMapping(path = "/health")
    public String changeHealth() {
        healthy = !healthy;
        return String.format("%s is now: %s", id, healthy);
    }

    @GetMapping(path = "/ready")
    public boolean ready() {
        return ready;
    }

    @PostMapping(path = "/ready")
    public String changeReady() {
        ready = !ready;
        return String.format("%s is now: %s", id, ready);
    }

}
