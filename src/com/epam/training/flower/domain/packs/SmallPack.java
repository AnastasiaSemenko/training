package com.epam.training.flower.domain.packs;

import com.epam.training.flower.domain.Accessory;

public class SmallPack extends Pack {
    private static final Accessory SMALL_ACCESSORY = new Accessory("Атласная лента", 2);

    public SmallPack() {
        super("Маленькая упаковка", 5, 2);
    }

    public Accessory getACCESSORY() {
        return SMALL_ACCESSORY;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Аксессуар: " + SMALL_ACCESSORY;
    }
}
