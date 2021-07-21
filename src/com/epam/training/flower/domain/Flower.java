package com.epam.training.flower.domain;

import com.epam.training.flower.enums.FlowerType;

public class Flower {
    private FlowerType flowerType;
    private int steamLength;
    private int freshness;
    private int flowerCost;

    private static int maxLevelOfFreshness = 5;
    private static int[] arrayOfSteamLength = {25, 30, 35, 40, 45};

    public Flower() {
        this.flowerType = FlowerType.values()[(int) (Math.random() * FlowerType.values().length)];
        this.steamLength = arrayOfSteamLength[(int) (Math.random() * arrayOfSteamLength.length)];
        this.freshness = (int) (Math.random() * maxLevelOfFreshness + 1);
        this.flowerCost = flowerType.getStartFlowerCost() - (freshness - 1);
    }

    public FlowerType getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(FlowerType flowerType) {
        this.flowerType = flowerType;
    }

    public int getSteamLength() {
        return steamLength;
    }

    public void setSteamLength(int steamLength) {
        this.steamLength = steamLength;
    }

    public int getFreshness() {
        return freshness;
    }

    public void setFreshness(int freshness) {
        this.freshness = freshness;
    }

    public int getFlowerCost() {
        return flowerCost;
    }

    public void setFlowerCost(int flowerCost) {
        this.flowerCost = flowerCost;
    }

    public static int getMaxLevelOfFreshness() {
        return maxLevelOfFreshness;
    }

    public static void setMaxLevelOfFreshness(int maxLevelOfFreshness) {
        Flower.maxLevelOfFreshness = maxLevelOfFreshness;
    }

    public static int[] getArrayOfSteamLength() {
        return arrayOfSteamLength;
    }

    public static void setArrayOfSteamLength(int[] arrayOfSteamLength) {
        Flower.arrayOfSteamLength = arrayOfSteamLength;
    }

    @Override
    public String toString() {
        return flowerType.getFlowerName() +
                ". Свежесть - " + freshness +
                "-й день. Стебель длиной " + steamLength +
                "см. Стоимость - " + flowerCost + "$.";
    }
}
