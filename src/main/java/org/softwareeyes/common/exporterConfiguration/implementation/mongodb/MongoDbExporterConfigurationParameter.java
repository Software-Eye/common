package org.softwareeyes.common.exporterConfiguration.implementation.mongodb;

import org.softwareeyes.common.models.exporterConfiguration.ExporterConfigurationParametersBase;
import software.amazon.awssdk.services.lambda.model.CreateFunctionRequest;
import software.amazon.awssdk.services.lambda.model.Environment;
import software.amazon.awssdk.services.lambda.model.FunctionCode;
import software.amazon.awssdk.services.lambda.model.ImageConfig;
import software.amazon.awssdk.services.lambda.model.Runtime;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class MongoDbExporterConfigurationParameter extends ExporterConfigurationParametersBase {

    private static final String IMAGE_URI = "870076785705.dkr.ecr.us-east-1.amazonaws.com/softwareye-test:mongodb_exporter_2.37.0";
    private String connectionString;

    public MongoDbExporterConfigurationParameter(int sampleRate, String connectionString) {
        super(sampleRate, IMAGE_URI);
        this.connectionString = connectionString;
    }

    public MongoDbExporterConfigurationParameter() {
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public CreateFunctionRequest.Builder AddFunctionArguments(CreateFunctionRequest.Builder functionRequestBuilder) {
        return functionRequestBuilder
                .environment(builder -> builder.variables(Map.ofEntries(entry("MONGODB_URI", connectionString))))
                .code(builder -> builder.imageUri(IMAGE_URI))
                .imageConfig(builder -> builder.command("--no-mongodb.direct-connect"));
    }
}
