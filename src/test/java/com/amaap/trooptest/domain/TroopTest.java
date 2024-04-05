package com.amaap.trooptest.domain;

import com.amaap.troop.domain.Troop;
import com.amaap.troop.domain.Troopers;
import com.amaap.troop.exceptions.InvalidQuantityException;
import com.amaap.troop.exceptions.InvalidTrainingCostException;
import com.amaap.troop.exceptions.InvalidTrainingTimeException;
import com.amaap.troop.exceptions.InvalidTroopTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TroopTest {

    @Test
    void shouldAbleToCreateTroopWithValidTypeAndQuantity() throws InvalidTroopTypeException, InvalidQuantityException, InvalidTrainingTimeException, InvalidTrainingCostException {
        // Arrange
        Troopers troopType = Troopers.Barbarian;
        int quantity = 5;
        int trainingTime = 3; // Default training time for Barbarians
        int trainingCost = 10; // Default training cost for Barbarians

        // Act
        Troop troop = Troop.create(troopType, quantity, trainingTime, trainingCost);

        // Assert
        assertEquals(troopType, troop.troopType);
        assertEquals(quantity, troop.quantity);
        assertEquals(trainingTime, troop.trainingTime);
        assertEquals(trainingCost, troop.trainingCost);
    }

    @Test
    void shouldAbleThrowExceptionForInvalidTroopType() {
        // Arrange
        Troopers invalidTroopType = null;
        int quantity = 5;
        int trainingTime = 3; // Default training time for Barbarians
        int trainingCost = 10; // Default training cost for Barbarians

        // Act and Assert
        assertThrows(InvalidTroopTypeException.class, () -> {
            Troop.create(invalidTroopType, quantity, trainingTime, trainingCost);
        });
    }

    @Test
    void shouldAbleThrowExceptionForInvalidQuantity() {
        // Arrange
        Troopers troopType = Troopers.Archer;
        int invalidQuantity = -1;
        int trainingTime = 6; // Default training time for Archers
        int trainingCost = 20; // Default training cost for Archers

        // Act and Assert
        assertThrows(InvalidQuantityException.class, () -> {
            Troop.create(troopType, invalidQuantity, trainingTime, trainingCost);
        });
    }

    @Test
    void shouldAbleToReturnTrueForValidTroopType() {
        // Arrange
        Troopers validTroopType = Troopers.Barbarian;

        // Act
        boolean isValid = Troop.isValidTroopType(validTroopType);

        // Assert
        assertTrue(isValid);
    }

    @Test
    void shouldAbleReturnFalseForInvalidTroopType() {
        // Arrange
        Troopers invalidTroopType = null;

        // Act
        boolean isValid = Troop.isValidTroopType(invalidTroopType);

        // Assert
        assertFalse(isValid);
    }

    @Test
    void shouldAbleReturnTrueForValidQuantity() {
        // Arrange
        int validQuantity = 5;

        // Act
        boolean isValid = Troop.isValidTroopQuantity(validQuantity);

        // Assert
        assertTrue(isValid);
    }

    @Test
    void shouldAbleReturnFalseForInvalidQuantity() {
        // Arrange
        int invalidQuantity = -1;

        // Act
        boolean isValid = Troop.isValidTroopQuantity(invalidQuantity);

        // Assert
        assertFalse(isValid);
    }
}