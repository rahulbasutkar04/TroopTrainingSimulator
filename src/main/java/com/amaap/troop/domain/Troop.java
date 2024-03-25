package com.amaap.troop.domain;

import com.amaap.troop.exceptions.InvalidQuantityException;
import com.amaap.troop.exceptions.InvalidTroopTypeException;

import java.util.EnumSet;
import java.util.Objects;

public class Troop {

    Troopers troopType;
    int quantity;

    public Troop(Troopers troopType, int quantity) {
        this.troopType = troopType;
        this.quantity = quantity;
    }

    public static Troop create(Troopers troopType, int quantity) throws InvalidTroopTypeException, InvalidQuantityException {
        if (isInvalidTroopType(troopType))
            throw new InvalidTroopTypeException("No Troop Type Found");
        if (isInvalidTroopQuantity(quantity))
            throw new InvalidQuantityException("Invalid quantity");
        return new Troop(troopType, quantity);
    }

    public static boolean isInvalidTroopType(Troopers troopType) {
        return !isValidTroopType(troopType);
    }

    public static boolean isValidTroopType(Troopers troopType) {
        EnumSet<Troopers> troopTypes = EnumSet.allOf(Troopers.class);
        if (troopTypes.contains(troopType))
            return true;
        return false;
    }

    public static boolean isInvalidTroopQuantity(int quantity) {
        return !isValidTroopQuantity(quantity);
    }

    private static boolean isValidTroopQuantity(int quantity) {

        if(quantity >=0 && quantity <= 10)
            return true;
        return false;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Troop troop = (Troop) o;
        return quantity == troop.quantity && troopType == troop.troopType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(troopType, quantity);
    }
    }

