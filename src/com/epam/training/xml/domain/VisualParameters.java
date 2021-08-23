package com.epam.training.xml.domain;

public class VisualParameters {
    private String stemColor;
    private String leavesColor;
    private int averageSize;

    public String getStemColor() {
        return stemColor;
    }

    public void setStemColor(String stemColor) {
        this.stemColor = stemColor;
    }

    public String getLeavesColor() {
        return leavesColor;
    }

    public void setLeavesColor(String leavesColor) {
        this.leavesColor = leavesColor;
    }

    public int getAverageSize() {
        return averageSize;
    }

    public void setAverageSize(int averageSize) {
        if (averageSize > 0) {
            this.averageSize = averageSize;
        } else {
            throw new IllegalArgumentException("Size can't be negative");
        }
    }
}
