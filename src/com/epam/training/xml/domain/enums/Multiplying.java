package com.epam.training.xml.domain.enums;

public enum Multiplying {
    LEAVES("листьями"),
    CUTTINGS("черенками"),
    SEEDS("семенами");

    private final String multiplyingType;

    Multiplying(String multiplyingType) {
        this.multiplyingType = multiplyingType;
    }

    public String getMultiplyingType() {
        return multiplyingType;
    }

    public static Multiplying getInstance(String str) {
        for (Multiplying multiplying : Multiplying.values()) {
            if (multiplying.multiplyingType.equalsIgnoreCase(str)) {
                return multiplying;
            }
        }
        return null;
    }
}