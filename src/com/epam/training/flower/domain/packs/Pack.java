package com.epam.training.flower.domain.packs;

import com.epam.training.flower.domain.Accessory;

public abstract class Pack {
    private String packName;
    private int volume;
    private int packCost;

    Pack(String packName, int volume, int packCost) {
        this.packName = packName;
        this.volume = volume;
        this.packCost = packCost;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getPackCost() {
        return packCost;
    }

    public void setPackCost(int packCost) {
        this.packCost = packCost;
    }

    public abstract Accessory getACCESSORY();

    @Override
    public String toString() {
        return this.getPackName() +
                " вместимостью - " + this.getVolume() + " цветов. Стоимость - " +
                this.getPackCost() + "$.\n" +
                "-------------------------------------------------------------------------- \n";
    }
}
