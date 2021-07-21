package com.epam.training.flower.service;

import com.epam.training.flower.domain.Flower;
import com.epam.training.flower.domain.packs.Pack;

public class CalculateCost {
    public static int getCalculateTotalCost(Flower[] flowers, Pack myPack) {
        int totalCost = 0;
        for (int i = 0; i < myPack.getVolume(); i++) {
            totalCost += flowers[i].getFlowerCost();
        }
        totalCost += (myPack.getPackCost() + myPack.getACCESSORY().getAccessoryCost());
        return totalCost;
    }
}
