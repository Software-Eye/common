package org.softwareeyes.common.models;

public class ExporterMetaData {
    private String type;
    private String name;

    public ExporterMetaData(String type, String name){
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
