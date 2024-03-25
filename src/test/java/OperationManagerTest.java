import com.amaap.troop.domain.OperationManager;
import com.amaap.troop.domain.Troop;
import com.amaap.troop.domain.Troopers;
import com.amaap.troop.exceptions.InvalidQuantityException;
import com.amaap.troop.exceptions.InvalidTroopTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationManagerTest {

    @Test
    void shouldAbleToCreateArmyTroopWithTypeBarbarian() throws InvalidQuantityException, InvalidTroopTypeException {
        // Arrange
        Troopers type = Troopers.Barbarian;
        int quantity = 5;
        Troop expected = Troop.create(type, quantity);

        // Act
        OperationManager operationManager = new OperationManager();
        Troop actual = operationManager.createTroop(type, quantity);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldAbleToCreateArmyTroopWithTypeArcher() throws InvalidTroopTypeException, InvalidQuantityException {
        //Arrange
        Troopers troopType = Troopers.Archer;
        int quantity = 5;
        Troop expected = Troop.create(troopType,quantity);

        //Act
        OperationManager operationManager = new OperationManager();
        Troop actual =operationManager.createTroop(troopType,quantity);

        //Assert
        assertEquals(expected,actual);

    }


}
