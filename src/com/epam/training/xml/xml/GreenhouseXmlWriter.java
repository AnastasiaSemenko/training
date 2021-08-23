package com.epam.training.xml.xml;

import com.epam.training.xml.domain.Plant;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class GreenhouseXmlWriter {
    public static void write(List<Plant> plants, String fileName) {
        XMLStreamWriter writer = null;
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        try {
            writer = factory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeCharacters("\n");
            writer.writeStartElement("greenhouse");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xmlns", "http://www.training.by/greenhouse");
            writer.writeAttribute("xsi:schemaLocation", "http://www.training.by/greenhouse greenhouse.xsd");
            writer.writeCharacters("\n");
            for (Plant plant : plants) {
                writer.writeStartElement("plant");
                writer.writeAttribute("id", plant.getId());
                writer.writeCharacters("\n");
                createElement(writer, "name", plant.getName());
                createElement(writer, "soil", plant.getSoil().getSoilType());
                createElement(writer, "origin", plant.getOrigin());
                writer.writeStartElement("visual-parameters");
                writer.writeCharacters("\n");
                createElement(writer, "stem-color", plant.getVisualParameters().getStemColor());
                createElement(writer, "leaves-color", plant.getVisualParameters().getLeavesColor());
                createElement(writer, "average-size", String.valueOf(plant.getVisualParameters().getAverageSize()));
                writer.writeEndElement();
                writer.writeCharacters("\n");
                writer.writeStartElement("growing-tips");
                writer.writeCharacters("\n");
                createElement(writer, "temperature", String.valueOf(plant.getGrowingTips().getTemperature()));
                createElement(writer, "lighting", String.valueOf(plant.getGrowingTips().isLighting()));
                createElement(writer, "watering", String.valueOf(plant.getGrowingTips().getWatering()));
                writer.writeEndElement();
                writer.writeCharacters("\n");
                createElement(writer, "multiplying", plant.getMultiplying().getMultiplyingType());
                writer.writeEndElement();
            }
            writer.writeCharacters("\n");
            writer.writeEndElement();
            writer.writeEndDocument();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        } catch (XMLStreamException e) {
            System.err.println("Ошибка при считывании файла");
        } finally {
            try {
                writer.close();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createElement(XMLStreamWriter writer, String name, String value) {
        try {
            writer.writeStartElement(name);
            writer.writeCharacters(value);
            writer.writeEndElement();
            writer.writeCharacters("\n");
        } catch (XMLStreamException e) {
            System.err.println("Ошибка при считывании файла");
        }
    }
}