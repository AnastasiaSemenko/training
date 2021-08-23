package com.epam.training.xml.domain;

public class GrowingTips {
    private int temperature;
    private boolean lighting;
    private int watering;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        if (temperature >= 0 && temperature <= 30) {
            this.temperature = temperature;
        } else {
            throw new IllegalArgumentException("Temperature can not be more than 30 or less than 0");
        }
    }

    public boolean isLighting() {
        return lighting;
    }

    public void setLighting(boolean lighting) {
        this.lighting = lighting;
    }

    public int getWatering() {
        return watering;
    }

    public void setWatering(int watering) {
        if (watering > 0) {
            this.watering = watering;
        } else {
            throw new IllegalArgumentException("Watering should be more than 0");
        }
    }
}