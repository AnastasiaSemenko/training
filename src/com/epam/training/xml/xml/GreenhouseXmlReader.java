package com.epam.training.xml.xml;

import com.epam.training.xml.domain.GrowingTips;
import com.epam.training.xml.domain.Plant;
import com.epam.training.xml.domain.VisualParameters;
import com.epam.training.xml.domain.enums.Multiplying;
import com.epam.training.xml.domain.enums.Soil;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GreenhouseXmlReader {
    public List<Plant> read(String xmlFileName) {
        List<Plant> plants = new ArrayList<>();
        XMLStreamReader reader = null;
        try {
            Plant plant = null;
            XMLInputFactory factory = XMLInputFactory.newFactory();
            reader = factory.createXMLStreamReader(new FileInputStream(xmlFileName));
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        String tagName = reader.getLocalName();
                        switch (tagName) {
                            case "plant":
                                plant = new Plant();
                                plant.setId(reader.getAttributeValue(null, "id"));
                                break;
                            case "name":
                                plant.setName(reader.getElementText());
                                break;
                            case "soil":
                                plant.setSoil(Soil.getInstance(reader.getElementText()));
                                break;
                            case "origin":
                                plant.setOrigin(reader.getElementText());
                                break;
                            case "stem-color":
                                plant.setVisualParameters(new VisualParameters());
                                plant.getVisualParameters().setStemColor(reader.getElementText());
                                break;
                            case "leaves-color":
                                plant.getVisualParameters().setLeavesColor(reader.getElementText());
                                break;
                            case "average-size":
                                plant.getVisualParameters().setAverageSize(Integer.parseInt(reader.getElementText()));
                                break;
                            case "temperature":
                                plant.setGrowingTips(new GrowingTips());
                                plant.getGrowingTips().setTemperature(Integer.parseInt(reader.getElementText()));
                                break;
                            case "lighting":
                                plant.getGrowingTips().setLighting(Boolean.parseBoolean(reader.getElementText()));
                                break;
                            case "watering":
                                plant.getGrowingTips().setWatering(Integer.parseInt(reader.getElementText()));
                                break;
                            case "multiplying":
                                plant.setMultiplying(Multiplying.getInstance(reader.getElementText()));
                                break;
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("plant".equals(tagName)) {
                            plants.add(plant);
                        }
                        break;
                    }
                }

            }
            return plants;
        } catch (XMLStreamException e) {
            System.err.println("Error occurred while parsing the file");
            return null;
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            return null;
        } finally {
            try {
                reader.close();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }
    }
}