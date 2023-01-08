package org.softwareeyes.common.models.exporterConfiguration;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;

@BsonDiscriminator
public abstract class ExporterConfigurationParametersBase {
    private int SampleRate;

    protected ExporterConfigurationParametersBase() {
    }

    protected ExporterConfigurationParametersBase(int sampleRate) {
        SampleRate = sampleRate;
    }

    public int getSampleRate() {
        return SampleRate;
    }

    public void setSampleRate(int sampleRate) {
        SampleRate = sampleRate;
    }

    public abstract String toTerraformEnvironmentConfiguration();
}
