package com.epam.training.flower.console;

import com.epam.training.flower.domain.Bouquet;
import com.epam.training.flower.domain.Flower;
import com.epam.training.flower.service.FlowerFilter;
import com.epam.training.flower.service.FlowerComparator;

import java.util.Arrays;

public class PrintBouquetInfo {

    public void printSortBouquet(Bouquet bouquet) {
        Arrays.sort(bouquet.getMyFlowers(), new FlowerComparator());
        System.out.println("Отсортированный букет(по свежести цветов):");
        System.out.println(bouquet.toString());
    }

    public void printFilterBouquet(Flower[] flowers) {
        FlowerFilter myFilter = new FlowerFilter();
        myFilter.findFlower(flowers, 30, 40);
    }
}
