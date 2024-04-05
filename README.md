# OMD Analysis:

## Configurations:- Future Preparedness
- Training Time
- Training Cost

## Domain Model:
### Troop:
- Barbarian (Enum)
- Archer (Enum)

### Barracks:
- Queue of troops waiting
- isTroopTrained function

### ArmyCamp:
- List of troop trained TroopType: Count

## Service:
- TrainTheTroop: Training time & cost
- ViewArmyCamp

## Assumption:
We introduced initial cost that is 500 points.

## Controller:
### train(troopCount, troopType)
- Service
  - Validation
  - Service of domain (TrainTheTroop)

### view
- ArmyCampService.view
  - ArmyCampRepository.viewtroop
    - Read from DB or may call to domain service
  - ArmyCampRepository.viewtroop

# Repository:
- ArmyCampRepository:
  - totalNoTroopTrained
  - Barbarian
  - Archer
  - CostLeft
