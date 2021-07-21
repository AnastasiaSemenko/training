package com.epam.training.flower.domain.packs;

import com.epam.training.flower.domain.Accessory;

public class BigPack extends Pack {
    private static final Accessory BIG_ACCESSORY = new Accessory("Комплект декоративных бабочек", 6);

    public BigPack() {
        super("Большая упаковка", 15, 5);
    }

    public Accessory getACCESSORY() {
        return BIG_ACCESSORY;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Аксессуар: " + BIG_ACCESSORY;
    }
}
