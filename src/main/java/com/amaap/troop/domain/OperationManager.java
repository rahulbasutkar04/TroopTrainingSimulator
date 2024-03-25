package com.amaap.troop.domain;

import com.amaap.troop.exceptions.InvalidQuantityException;
import com.amaap.troop.exceptions.InvalidTrainingCostException;
import com.amaap.troop.exceptions.InvalidTrainingTimeException;
import com.amaap.troop.exceptions.InvalidTroopTypeException;

public class OperationManager {
    public static Troop createTroop(Troopers type, int quantity, int trainingTime, int trainingCost) throws InvalidQuantityException, InvalidTroopTypeException, InvalidTrainingTimeException, InvalidTrainingCostException {
        return Troop.create(type, quantity, trainingTime, trainingCost);
    }
}
