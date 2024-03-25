package com.amaap.troop.domain;

public class Archer {
    public static int train(Troop troop,int quantity) {
        troop.setQuantity(quantity);
        int trainingTimeSeconds = troop.getTrainingTime();
        try {
            Thread.sleep(trainingTimeSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        troop.setTrainingComplete(true);

        return troop.getQuantity();
    }
}
