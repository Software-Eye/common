package org.softwareeyes.common.models;

import org.bson.types.ObjectId;

public class Rule {
    private String exporterID;
    private String alertName;
    private String query;
    private String duration; //for promql
    private String severity;
    private String summary;
    private String description;

    public Rule(String alertName, String query, String duration, String severity, String summary, String description, String exporterID){
        this.alertName = alertName;
        this.query = query;
        this.duration = duration;
        this.severity = severity;
        this.summary = summary;
        this.description = description;
        this.exporterID = exporterID;
    }

    public String getAlertName() {
        return alertName;
    }

    public String getQuery() {
        return query;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }

    public String getSummary() {
        return summary;
    }

    public String getExporterID(){
        return exporterID;
    }

    public void  setExporterID(ObjectId id){
        exporterID = id.toString();

    }
}

