package com.amaap.troop.domain;

import com.amaap.troop.exceptions.InvalidQuantityException;
import com.amaap.troop.exceptions.InvalidTrainingCostException;
import com.amaap.troop.exceptions.InvalidTrainingTimeException;
import com.amaap.troop.exceptions.InvalidTroopTypeException;

import java.util.EnumSet;
import java.util.Objects;

    public class Troop {
        public Troopers troopType;
        public int quantity;
        public int trainingTime; // in seconds
        public int trainingCost; // in magic potions
        public boolean isTrainingComplete;

        public static Troop create(Troopers troopType, int quantity, int trainingTime, int trainingCost) throws InvalidTroopTypeException, InvalidQuantityException, InvalidTrainingTimeException, InvalidTrainingCostException {
            if (isInvalidTroopType(troopType))
                throw new InvalidTroopTypeException("No Troop Type Found");
            if (isInvalidTroopQuantity(quantity))
                throw new InvalidQuantityException("Invalid quantity");

            if (!isValidTrainingTime(troopType, trainingTime))
                throw new InvalidTrainingTimeException("Invalid training time for " + troopType);
            if (!isValidTrainingCost(troopType, trainingCost))
                throw new InvalidTrainingCostException("Invalid training cost for " + troopType);
            return new Troop(troopType, quantity, trainingTime, trainingCost);
        }

        private Troop(Troopers troopType, int quantity, int trainingTime, int trainingCost) {
            this.troopType = troopType;
            this.quantity = quantity;
            this.trainingTime = trainingTime;
            this.trainingCost = trainingCost;
            this.isTrainingComplete = false;
        }

        public static boolean isInvalidTroopType(Troopers troopType) {
            return !isValidTroopType(troopType);
        }

        public static boolean isValidTroopType(Troopers troopType) {
            EnumSet<Troopers> troopTypes = EnumSet.allOf(Troopers.class);
            return troopTypes.contains(troopType);
        }

        public static boolean isInvalidTroopQuantity(int quantity) {
            return !isValidTroopQuantity(quantity);
        }

        public static boolean isValidTroopQuantity(int quantity) {
            return quantity >= 0 && quantity <= 10;
        }

        private static boolean isValidTrainingTime(Troopers troopType, int trainingTime) {
            if (troopType == Troopers.Barbarian && trainingTime != 3)
                return false;
            if (troopType == Troopers.Archer && trainingTime != 6)
                return false;
            return true;
        }

        private static boolean isValidTrainingCost(Troopers troopType, int trainingCost) {
            if (troopType == Troopers.Barbarian && trainingCost != 10)
                return false;
            if (troopType == Troopers.Archer && trainingCost != 20)
                return false;
            return true;
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

        public Troopers getTroopType() {
            return troopType;
        }

        public void setTroopType(Troopers troopType) {
            this.troopType = troopType;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getTrainingTime() {
            return trainingTime;
        }

        public void setTrainingTime(int trainingTime) {
            this.trainingTime = trainingTime;
        }

        public int getTrainingCost() {
            return trainingCost;
        }

        public void setTrainingCost(int trainingCost) {
            this.trainingCost = trainingCost;
        }

        public boolean isTrainingComplete() {
            return isTrainingComplete;
        }

        public void setTrainingComplete(boolean trainingComplete) {
            isTrainingComplete = trainingComplete;
        }
    }



