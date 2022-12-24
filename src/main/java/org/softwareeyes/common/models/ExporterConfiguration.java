package org.softwareeyes.common.models;

public class ExporterConfiguration {
    private int sampleRate;

    public ExporterConfiguration(){
        sampleRate = 300;
    }
    public ExporterConfiguration(int sampleRate){
        this.sampleRate = sampleRate;
    }

    public int getSampleRate() {
        return sampleRate;
    }
}
