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
        if (validator.validate("greenhouse.xsd", "greenhouse.xml")) {
            GreenhouseXmlReader reader = new GreenhouseXmlReader();
            Greenhouse greenhouse = new Greenhouse();
            greenhouse.setPlantList(reader.read("greenhouse.xml"));
            greenhouse.getPlantList().sort(Comparator.comparing(Plant::getName));
            System.out.println(greenhouse.toString());
            GreenhouseXmlWriter writer = new GreenhouseXmlWriter();
            writer.write(greenhouse.getPlantList(), "newGreenhouse.xml");
            System.out.println("Запись данных прошла успешно!!)");
        } else {
            System.out.println(validator.getError());
        }
    }
}
