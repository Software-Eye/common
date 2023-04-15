package org.softwareeyes.common.models;

import org.softwareeyes.common.models.exporterConfiguration.ExporterConfigurationParametersBase;
import org.softwareeyes.common.models.exporterConfiguration.ExporterMetadata;
import org.softwareeyes.common.models.exporterConfiguration.exporterTopology.ExporterTopology;

import java.util.ArrayList;

public class CombinedExporter extends org.softwareeyes.common.models.exporterConfiguration.ExporterConfiguration {
    ArrayList<Rule> rules;

    public CombinedExporter(ExporterMetadata metadata, ExporterConfigurationParametersBase exporterConfigurationParameters, ExporterTopology topology, String id, ArrayList<Rule> rules) {
        super(metadata, exporterConfigurationParameters, topology, id);
        this.rules = rules;
    }

    public CombinedExporter(CombinedExporter combinedExporter){
        super(combinedExporter.getMetadata(), combinedExporter.getExporterConfigurationParameters(),
                combinedExporter.getTopology(), combinedExporter.getId());
        this.rules = combinedExporter.rules;
    }

    public ArrayList<Rule> getRules() {
        return rules;
    }
}
