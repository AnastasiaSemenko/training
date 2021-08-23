package com.epam.training.xml.xml;

import com.epam.training.xml.domain.Plant;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class GreenhouseXmlWriter {
    public void write(List<Plant> plants, String newXmlFileName) {
        XMLStreamWriter writer = null;
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            writer = factory.createXMLStreamWriter(new FileOutputStream(newXmlFileName), "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("greenhouse");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xmlns", "http://www.training.by/greenhouse");
            writer.writeAttribute("xsi:schemaLocation", "http://www.training.by/greenhouse greenhouse.xsd");
            for (Plant plant : plants) {
                writer.writeStartElement("plant");
                writer.writeAttribute("id", plant.getId());
                writer.writeStartElement("name");
                writer.writeCharacters(plant.getName());
                writer.writeEndElement();
                writer.writeStartElement("soil");
                writer.writeCharacters(plant.getSoil().getSoilType());
                writer.writeEndElement();
                writer.writeStartElement("origin");
                writer.writeCharacters(plant.getOrigin());
                writer.writeEndElement();
                writer.writeStartElement("visual-parameters");
                writer.writeStartElement("stem-color");
                writer.writeCharacters(plant.getVisualParameters().getStemColor());
                writer.writeEndElement();
                writer.writeStartElement("leaves-color");
                writer.writeCharacters(plant.getVisualParameters().getLeavesColor());
                writer.writeEndElement();
                writer.writeStartElement("average-size");
                writer.writeCharacters(String.valueOf(plant.getVisualParameters().getAverageSize()));
                writer.writeEndElement();
                writer.writeEndElement();
                writer.writeStartElement("growing-tips");
                writer.writeStartElement("temperature");
                writer.writeCharacters(String.valueOf(plant.getGrowingTips().getTemperature()));
                writer.writeEndElement();
                writer.writeStartElement("lighting");
                writer.writeCharacters(String.valueOf(plant.getGrowingTips().isLighting()));
                writer.writeEndElement();
                writer.writeStartElement("watering");
                writer.writeCharacters(String.valueOf(plant.getGrowingTips().getWatering()));
                writer.writeEndElement();
                writer.writeEndElement();
                writer.writeStartElement("multiplying");
                writer.writeCharacters(plant.getMultiplying().getMultiplyingType());
                writer.writeEndElement();
                writer.writeEndElement();
            }
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
}
