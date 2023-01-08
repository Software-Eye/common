package org.softwareeyes.common.models;

import java.util.ArrayList;

public class CombinedExporter extends Exporter {
    ArrayList<Rule> rules;

    public CombinedExporter(ExporterMetaData metaData, ExporterConfiguration configuration, Topology topology, ArrayList<Rule> rules) {
        super(metaData, configuration, topology);
        this.rules = rules;
    }

    public ArrayList<Rule> getRules() {
        return rules;
    }
}
