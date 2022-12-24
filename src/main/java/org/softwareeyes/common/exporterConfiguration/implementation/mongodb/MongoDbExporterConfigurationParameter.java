package org.softwareeyes.common.exporterConfiguration.implementation.mongodb;

import org.softwareeyes.common.models.exporterConfiguration.ExporterConfigurationParametersBase;

public class MongoDbExporterConfigurationParameter extends ExporterConfigurationParametersBase {

    private String connectionString;

    public MongoDbExporterConfigurationParameter(int sampleRate, String connectionString){
        super(sampleRate);
        this.connectionString = connectionString;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public String toTerraformEnvironmentConfiguration() {
        return "variables = {" +
                "MONGODB_URL = " + this.connectionString +
                "}";
    }
}
