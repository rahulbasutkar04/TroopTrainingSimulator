package com.amaap.troop.domain;

import com.amaap.troop.exceptions.InvalidQuantityException;
import com.amaap.troop.exceptions.InvalidTroopTypeException;

public class OperationManager {
    public Troop createTroop(Troopers type, int quantity) throws InvalidQuantityException, InvalidTroopTypeException {
        return Troop.create(type,quantity);
    }
}
