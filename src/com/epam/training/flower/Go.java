package com.epam.training.flower;

import com.epam.training.flower.console.PrintBouquetInfo;
import com.epam.training.flower.domain.Bouquet;

public class Go {
    public static void main(String[] args) {
        Bouquet myBouquet = new Bouquet();
        PrintBouquetInfo print = new PrintBouquetInfo();

        System.out.println(myBouquet.toString());
        print.printSortBouquet(myBouquet);
        print.printFilterBouquet(myBouquet.getMyFlowers());
    }
}
