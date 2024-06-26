package com.amaap.troop.domain;

import com.amaap.troop.exceptions.InvalidQuantityException;
import com.amaap.troop.exceptions.InvalidTrainingCostException;
import com.amaap.troop.exceptions.InvalidTrainingTimeException;
import com.amaap.troop.exceptions.InvalidTroopTypeException;

public class OperationManager {
    public static Troop createTroop(Troopers type, int quantity, int trainingTime, int trainingCost) throws InvalidQuantityException, InvalidTroopTypeException, InvalidTrainingTimeException, InvalidTrainingCostException {
        return Troop.create(type, quantity, trainingTime, trainingCost);
    }


    public int trainTroop(Troop troop,int quantity) {
        if (troop.getTroopType() == Troopers.Barbarian) {
            return Bardbarian.train(troop,quantity);
        } else if (troop.getTroopType() == Troopers.Archer) {
            return Archer.train(troop,quantity);
        }
        return 0;
    }
}
