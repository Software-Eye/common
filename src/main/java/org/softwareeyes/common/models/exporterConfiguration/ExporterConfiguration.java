package org.softwareeyes.common.models.exporterConfiguration;

import org.softwareeyes.common.models.exporterConfiguration.exporterTopology.ExporterTopology;
import software.amazon.awssdk.awscore.AwsRequestOverrideConfiguration;
import software.amazon.awssdk.services.lambda.model.CreateFunctionRequest;
import software.amazon.awssdk.services.lambda.model.FunctionCode;
import software.amazon.awssdk.services.lambda.model.PackageType;
import software.amazon.awssdk.services.lambda.model.Runtime;


public class ExporterConfiguration {
    private ExporterMetadata metadata;
    private ExporterConfigurationParametersBase exporterConfigurationParameters;
    private ExporterTopology topology;
    private String _id;

    public ExporterConfiguration() {
    }

    public ExporterConfiguration(ExporterMetadata metadata, ExporterConfigurationParametersBase exporterConfigurationParameters, ExporterTopology topology, String id) {
        this.metadata = metadata;
        this.exporterConfigurationParameters = exporterConfigurationParameters;
        this.topology = topology;
        this._id = id;
    }

    public ExporterMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ExporterMetadata metadata) {
        this.metadata = metadata;
    }

    public ExporterConfigurationParametersBase getExporterConfigurationParameters() {
        return exporterConfigurationParameters;
    }

    public void setExporterConfigurationParameters(ExporterConfigurationParametersBase exporterConfigurationParameters) {
        this.exporterConfigurationParameters = exporterConfigurationParameters;
    }

    public ExporterTopology getTopology() {
        return topology;
    }

    public void setTopology(ExporterTopology topology) {
        this.topology = topology;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public CreateFunctionRequest CreateLambdaFunction(){
        CreateFunctionRequest.Builder functionBuilder = CreateFunctionRequest.builder();
        functionBuilder = exporterConfigurationParameters.AddFunctionArguments(functionBuilder);
        functionBuilder
                .functionName(_id)
                .role("arn:aws:iam::870076785705:role/lambda-base-rule")
                .packageType(PackageType.IMAGE);
        return functionBuilder.build();
    }

}
