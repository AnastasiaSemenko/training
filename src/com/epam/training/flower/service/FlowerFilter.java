package com.epam.training.flower.service;

import com.epam.training.flower.domain.Flower;
import java.util.ArrayList;

public class FlowerFilter {
    public void findFlower(Flower[] flowers, int from, int to) {
        ArrayList<Flower> newArrayOfFlower = new ArrayList<>();
        for (Flower f : flowers) {
            if (f.getSteamLength() >= from && f.getSteamLength() <= to) {
                newArrayOfFlower.add(f);
            }
        }
        printFilterFLowers(newArrayOfFlower, from, to);
    }

    private void printFilterFLowers(ArrayList<Flower> arrayListOfFlower, int from, int to) {
        if (arrayListOfFlower != null) {
            System.out.println("Цветы с такой длиной стебля найдены! (От " + from + " до " + to + "):");
            for (Flower f : arrayListOfFlower) {
                System.out.println(f.toString());
            }
        } else {
            System.out.println("Цветы с такой длиной стебля в Вашем букете отсутствуют. (От " + from + " до " + to + ")");
        }
    }
}