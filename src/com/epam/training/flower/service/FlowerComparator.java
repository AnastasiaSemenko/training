package com.epam.training.flower.service;

import com.epam.training.flower.domain.Flower;
import java.util.Comparator;

public class FlowerComparator implements Comparator<Flower> {
    @Override
    public int compare(Flower flower1, Flower flower2) {
        return flower1.getFreshness() - flower2.getFreshness();
    }
}
