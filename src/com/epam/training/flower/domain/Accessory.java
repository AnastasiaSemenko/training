package com.epam.training.flower.domain;

public class Accessory {
    private String accessoryName;
    private int accessoryCost;

    public Accessory(String accessoryName, int accessoryCost) {
        this.accessoryName = accessoryName;
        this.accessoryCost = accessoryCost;
    }

    public String getAccessoryName() {
        return accessoryName;
    }

    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName;
    }

    public int getAccessoryCost() {
        return accessoryCost;
    }

    public void setAccessoryCost(int accessoryCost) {
        this.accessoryCost = accessoryCost;
    }

    @Override
    public String toString() {
        return accessoryName +
                ". Стоимость - " + accessoryCost + "$.";
    }
}
