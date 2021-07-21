package com.epam.training.flower.enums;

public enum FlowerType {
    ROSE("Роза", 10),
    PEONY("Пион", 11),
    CHRYSANTHEMUM("Хризантема", 9),
    LUPIN("Люпин", 10),
    LILY("Лилия", 11),
    DAFFODIL("Нарцисс", 9),
    TULIP("Тюльпан", 9),
    CARNATION("Гвоздика", 9),
    CHAMOMILE("Ромашка", 9);

    private final String FLOWER_NAME;
    private final int START_FLOWER_COST;

    public String getFlowerName() {
        return FLOWER_NAME;
    }

    public int getStartFlowerCost() {
        return START_FLOWER_COST;
    }

    FlowerType(String FLOWER_NAME, int START_FLOWER_COST) {
        this.FLOWER_NAME = FLOWER_NAME;
        this.START_FLOWER_COST = START_FLOWER_COST;
    }
}

