package com.epam.training.xml;

import com.epam.training.xml.domain.Greenhouse;
import com.epam.training.xml.domain.Plant;
import com.epam.training.xml.xml.GreenhouseXmlReader;
import com.epam.training.xml.xml.GreenhouseXmlValidator;
import com.epam.training.xml.xml.GreenhouseXmlWriter;

import java.util.Comparator;

public class Go {
    public static void main(String[] args) {
        GreenhouseXmlValidator validator = new GreenhouseXmlValidator();
        if (validator.validate("src/resources/greenhouse.xsd", "src/resources/greenhouse.xml")) {
            Greenhouse greenhouse = new Greenhouse();
            greenhouse.setPlantList(GreenhouseXmlReader.read("src/resources/greenhouse.xml"));
            greenhouse.getPlantList().sort(Comparator.comparing(Plant::getName));
            System.out.println(greenhouse.toString());
            GreenhouseXmlWriter.write(greenhouse.getPlantList(), "src/resources/newGreenhouse.xml");
            System.out.println("Запись данных прошла успешно!!)");
        } else {
            System.out.println(validator.getError());
        }
    }
}
