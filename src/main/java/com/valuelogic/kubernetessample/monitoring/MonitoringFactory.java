package com.valuelogic.kubernetessample.monitoring;

import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.monitoring.v3.ProjectName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MonitoringFactory {

    private MetricServiceClient metricServiceClient;
    @Value("monitoring.projectId")
    private String projectId;
    private  ProjectName name;

    @PostConstruct
    public void init() throws Exception {
        if (projectId == null) {
            throw new RuntimeException("Project ID not set for monitoring");
        }
        metricServiceClient = MetricServiceClient.create();
        ProjectName name = ProjectName.create(projectId);
    }


}
