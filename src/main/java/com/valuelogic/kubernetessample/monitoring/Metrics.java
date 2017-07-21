package com.valuelogic.kubernetessample.monitoring;

import com.google.api.Metric;
import com.google.api.MonitoredResource;

import com.google.cloud.monitoring.v3.MetricServiceClient;

import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.Point;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.TimeInterval;
import com.google.monitoring.v3.TimeSeries;
import com.google.monitoring.v3.TypedValue;
import com.google.protobuf.util.Timestamps;

import java.util.*;

public class Metrics {

    private final MetricServiceClient metricServiceClient;
    private final ProjectName name;

    private Metric metric(String name) {
        Map<String, String> metricLabels = new HashMap<String, String>();
        metricLabels.put("other_label", "monitoring_demo");
        return Metric.newBuilder()
                .setType(name)
                .putAllLabels(metricLabels)
                .build();
    }

    private List<Point> points(Date date, double v) {
        TimeInterval interval = TimeInterval.newBuilder()
                .setEndTime(Timestamps.fromMillis(date.getTime()))
                .build();
        TypedValue value = TypedValue.newBuilder()
                .setDoubleValue(v)
                .build();
        Point point = Point.newBuilder()
                .setInterval(interval)
                .setValue(value)
                .build();

        List<Point> pointList = new ArrayList<>();
        pointList.add(point);
        return pointList;
    }

    private MonitoredResource resource() {
        Map<String, String> resourceLabels = new HashMap<>();
        resourceLabels.put("project_id", name.getProject());
        return MonitoredResource.newBuilder()
                .setType("global")
                .putAllLabels(resourceLabels)
                .build();
    }

    public void value(String mName, double mValue) {
        TimeSeries timeSeries = TimeSeries.newBuilder()
                .setMetric(metric(mName))
                .setResource(resource())
                .addAllPoints(points(new Date(), mValue))
                .build();

        List<TimeSeries> timeSeriesList = new ArrayList<>();
        timeSeriesList.add(timeSeries);

        CreateTimeSeriesRequest request = CreateTimeSeriesRequest.newBuilder()
                .setNameWithProjectName(name)
                .addAllTimeSeries(timeSeriesList)
                .build();

        metricServiceClient.createTimeSeries(request);
    }

    public Metrics(MetricServiceClient metricServiceClient, ProjectName name) {
        this.metricServiceClient = metricServiceClient;
        this.name = name;
    }
}
