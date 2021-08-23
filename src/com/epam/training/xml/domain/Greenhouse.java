package com.epam.training.xml.domain;

import java.util.List;

public class Greenhouse {
    private List<Plant> plantList;

    public List<Plant> getPlantList() {
        return plantList;
    }

    public void setPlantList(List<Plant> plantList) {
        this.plantList = plantList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Plant plant : plantList) {
            builder.append("Растение (id = ").append(plant.getId()).append("): ").append(plant.getName());
            builder.append("\nПочва: ").append(plant.getSoil().getSoilType());
            builder.append("\nСтрана: ").append(plant.getOrigin());
            builder.append("\nЦвет стебля: ").append(plant.getVisualParameters().getStemColor());
            builder.append("\nЦвет листьев: ").append(plant.getVisualParameters().getLeavesColor());
            builder.append("\nСредний размер: ").append(plant.getVisualParameters().getAverageSize());
            builder.append("\nТемпература: ").append(plant.getGrowingTips().getTemperature());
            builder.append("\nОсвещение: ").append(plant.getGrowingTips().isLighting());
            builder.append("\nПолив: ").append(plant.getGrowingTips().getWatering());
            builder.append("\nРазмножение: ").append(plant.getMultiplying().getMultiplyingType());
            builder.append("\n\n");
        }
        return builder.toString();
    }
}
