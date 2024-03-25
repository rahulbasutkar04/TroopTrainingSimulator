package com.amaap.trooptest.domain;

import com.amaap.troop.domain.Troop;
import com.amaap.troop.domain.Troopers;
import com.amaap.troop.exceptions.InvalidQuantityException;
import com.amaap.troop.exceptions.InvalidTroopTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TroopTest {

    @Test
    void shouldCreateTroopWithValidTypeAndQuantity() throws InvalidTroopTypeException, InvalidQuantityException {
        // Arrange
        Troopers troopType = Troopers.Barbarian;
        int quantity = 5;

        // Act
        Troop troop = Troop.create(troopType, quantity);

        // Assert
        assertEquals(troopType, troop.troopType);
        assertEquals(quantity, troop.quantity);
    }

    @Test
    void shouldThrowExceptionForInvalidTroopType() {
        // Arrange
        Troopers invalidTroopType = null;
        int quantity = 5;

        // Act and Assert
        assertThrows(InvalidTroopTypeException.class, () -> {
            Troop.create(invalidTroopType, quantity);
        });
    }

    @Test
    void shouldThrowExceptionForInvalidQuantity() {
        // Arrange
        Troopers troopType = Troopers.Archer;
        int invalidQuantity = -1;

        // Act and Assert
        assertThrows(InvalidQuantityException.class, () -> {
            Troop.create(troopType, invalidQuantity);
        });
    }

    @Test
    void shouldReturnTrueForValidTroopType() {
        // Arrange
        Troopers validTroopType = Troopers.Barbarian;

        // Act
        boolean isValid = Troop.isValidTroopType(validTroopType);

        // Assert
        assertTrue(isValid);
    }

    @Test
    void shouldReturnFalseForInvalidTroopType() {
        // Arrange
        Troopers invalidTroopType = null;

        // Act
        boolean isValid = Troop.isValidTroopType(invalidTroopType);

        // Assert
        assertFalse(isValid);
    }

    @Test
    void shouldReturnTrueForValidQuantity() {
        // Arrange
        int validQuantity = 5;

        // Act
        boolean isValid = Troop.isValidTroopQuantity(validQuantity);

        // Assert
        assertTrue(isValid);
    }

    @Test
    void shouldReturnFalseForInvalidQuantity() {
        // Arrange
        int invalidQuantity = -1;

        // Act
        boolean isValid = Troop.isValidTroopQuantity(invalidQuantity);

        // Assert
        assertFalse(isValid);
    }

}