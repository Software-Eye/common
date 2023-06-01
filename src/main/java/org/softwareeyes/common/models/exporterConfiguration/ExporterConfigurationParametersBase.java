package org.softwareeyes.common.models.exporterConfiguration;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import software.amazon.awssdk.services.lambda.model.CreateFunctionRequest;

import java.util.Map;

@BsonDiscriminator
public abstract class ExporterConfigurationParametersBase {
    private int SampleRate;
    private String ImageUri;

    protected ExporterConfigurationParametersBase() {
    }

    protected ExporterConfigurationParametersBase(int sampleRate, String imageUri) {
        SampleRate = sampleRate;
        ImageUri = imageUri;
    }

    public int getSampleRate() {
        return SampleRate;
    }

    public void setSampleRate(int sampleRate) {
        SampleRate = sampleRate;
    }

    public String getImageUri() {
        return ImageUri;
    }

    public void setImageUri(String imageUri) {
        ImageUri = imageUri;
    }

    public abstract CreateFunctionRequest.Builder AddFunctionArguments(CreateFunctionRequest.Builder functionRequestBuilder);
}
