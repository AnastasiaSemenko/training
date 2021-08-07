package com.epam.training.flower.domain;

import com.epam.training.flower.domain.packs.BigPack;
import com.epam.training.flower.domain.packs.MediumPack;
import com.epam.training.flower.domain.packs.Pack;
import com.epam.training.flower.domain.packs.SmallPack;
import com.epam.training.flower.service.CalculateCost;

public class Bouquet {
    private static Pack[] arrayOfPacks = new Pack[]{
            new SmallPack(),
            new MediumPack(),
            new BigPack()
    };
    private Pack myPack = arrayOfPacks[(int) (Math.random() * 3)];
    private Flower[] myFlowers = new Flower[myPack.getVolume()];
    private int totalCost;

    public Bouquet() {
        for (int i = 0; i < myPack.getVolume(); i++) {
            myFlowers[i] = new Flower();
        }
        totalCost = CalculateCost.getCalculateTotalCost(myFlowers, myPack);
    }

    public static Pack[] getARRAY_OF_PACKS() {
        return arrayOfPacks;
    }

    public static void setArrayOfPacks(Pack[] arrayOfPacks) {
        Bouquet.arrayOfPacks = arrayOfPacks;
    }

    public Pack getMyPack() {
        return myPack;
    }

    public void setMyPack(Pack myPack) {
        this.myPack = myPack;
    }

    public Flower[] getMyFlowers() {
        return myFlowers;
    }

    public void setMyFlowers(Flower[] myFlowers) {
        this.myFlowers = myFlowers;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        String str = "Ваш букет: \n";
        str += myPack.toString();
        for (int i = 0; i < myPack.getVolume(); i++) {
            str += ("Цветок " + (i + 1) + ": " + myFlowers[i].toString() + "\n");
        }
        str += ("-------------------------------------------------------------------------- \n" +
                "Общая стоимость букета составляет - " + totalCost + "$.\n\n");
        return str;
    }
}
