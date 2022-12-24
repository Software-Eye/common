package org.softwareeyes.common.models;

public class Topology {
    private float x;
    private float y;
    private String label;

    public Topology(String label){
        this.x = 0;
        this.y = 0;
        this.label = label;
    }


    public Topology(float x, float y, String label){
        this.x = x;
        this.y = y;
        this.label = label;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getLabel() {
        return label;
    }
}
