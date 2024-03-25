import com.amaap.troop.domain.OperationManager;
import com.amaap.troop.domain.Troop;
import com.amaap.troop.domain.Troopers;
import com.amaap.troop.exceptions.InvalidQuantityException;
import com.amaap.troop.exceptions.InvalidTrainingCostException;
import com.amaap.troop.exceptions.InvalidTrainingTimeException;
import com.amaap.troop.exceptions.InvalidTroopTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationManagerTest {

    @Test
    void shouldAbleToCreateArmyTroopWithTypeBarbarian() throws InvalidQuantityException, InvalidTroopTypeException, InvalidTrainingTimeException, InvalidTrainingCostException {
        // Arrange
        Troopers type = Troopers.Barbarian;
        int quantity = 5;
        int trainingTime = 3; // Default times
        int trainingCost = 10; // Default times
        Troop expected = Troop.create(type, quantity, trainingTime, trainingCost);

        // Act
        OperationManager operationManager = new OperationManager();
        Troop actual = operationManager.createTroop(type, quantity, trainingTime, trainingCost);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldAbleToCreateArmyTroopWithTypeArcher() throws InvalidTroopTypeException, InvalidQuantityException, InvalidTrainingTimeException, InvalidTrainingCostException {
        //Arrange
        Troopers troopType = Troopers.Archer;
        int quantity = 5;
        int trainingTime = 6;
        int trainingCost = 20;
        Troop expected = Troop.create(troopType, quantity, trainingTime, trainingCost);

        //Act
        OperationManager operationManager = new OperationManager();
        Troop actual = operationManager.createTroop(troopType, quantity, trainingTime, trainingCost);

        //Assert
        assertEquals(expected,actual);

    }


}
