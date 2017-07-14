package com.valuelogic.kubernetessample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KubernetesSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(KubernetesSampleApplication.class, args);
	}

}
