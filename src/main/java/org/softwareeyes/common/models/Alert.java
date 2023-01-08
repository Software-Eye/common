package org.softwareeyes.common.models;

import java.time.LocalDateTime;
import java.util.Map;

public class Alert {
    private String status;
    private Map<String, String> labels;
    private Map<String, String> annotations;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String generatorURL;
    private String fingerprint;

    public Alert(String status, Map<String, String> labels, Map<String, String> annotations, LocalDateTime startTime, LocalDateTime endTime, String generatorURL, String fingerprint){
        this.status = status;
        this.labels = labels;
        this.annotations = annotations;
        this.startTime = startTime;
        this.endTime = endTime;
        this.generatorURL = generatorURL;
        this. fingerprint = fingerprint;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    public Map<String, String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getGeneratorURL() {
        return generatorURL;
    }

    public void setGeneratorURL(String generatorURL) {
        this.generatorURL = generatorURL;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }
}
