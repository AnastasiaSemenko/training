package com.epam.training.xml.domain.enums;

public enum Soil {
    PODZOLIC("подзолистая"),
    UNPAVED("грунтовая"),
    SOD_PODZOLIC("дерново-подзолистая");

    private final String soilType;

    Soil(String soilType) {
        this.soilType = soilType;
    }

    public String getSoilType() {
        return soilType;
    }

    public static Soil getInstance(String str) {
        for (Soil soil : Soil.values()) {
            if (soil.soilType.equalsIgnoreCase(str)) {
                return soil;
            }
        }
        return null;
    }
}