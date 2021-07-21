package com.epam.training.flower.domain.packs;

import com.epam.training.flower.domain.Accessory;

public class MediumPack extends Pack {
    private static final Accessory MEDIUM_ACCESSORY = new Accessory("Комплект бархатных сердец", 4);

    public MediumPack() {
        super("Средняя упаковка", 10, 3);
    }

    public Accessory getACCESSORY() {
        return MEDIUM_ACCESSORY;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Аксессуар: " + MEDIUM_ACCESSORY;
    }
}
