package org.softwareeyes.common.models;

public class Exporter {
    ExporterMetaData metaData;
    ExporterConfiguration configuration;
    Topology topology;

    public Exporter(ExporterMetaData metaData, ExporterConfiguration configuration, Topology topology){
        this.metaData = metaData;
        this.configuration = configuration;
        this.topology = topology;
    }

    public Exporter(CombinedExporter combinedExporter)
    {
        this.metaData = combinedExporter.metaData;
        this.configuration = combinedExporter.configuration;
        this.topology = combinedExporter.topology;
    }
    public ExporterMetaData getMetaData() {
        return metaData;
    }

    public Topology getTopology() {
        return topology;
    }

    public ExporterConfiguration getConfiguration() {
        return configuration;
    }
}
