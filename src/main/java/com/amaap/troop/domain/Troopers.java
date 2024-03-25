package com.amaap.troop.domain;

public enum Troopers {
    Barbarian(3,10),
    Archer(6,20);
    int trainingTime;
    int trainingCost;
    Troopers(int trainingTime, int trainingCost) {
        this.trainingTime = trainingTime;
        this.trainingCost = trainingCost;

    }

    public int getTrainingTime() {
        return trainingTime;
    }

    public int getTrainingCost() {
        return trainingCost;
    }
}
