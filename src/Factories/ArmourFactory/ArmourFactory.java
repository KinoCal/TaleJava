package Factories.ArmourFactory;

import gameItems.abstractClasses.Item;
import gameItems.conreteClasses.equipment.ArmourItem;

public class ArmourFactory {

    public ArmourItem createItem(String itemName) {
        return switch (itemName) {
            case "ClothBody" -> new ArmourItem(1, "Cloth Body", "Equipment", 2, 1);
            default -> throw new IllegalArgumentException("Unknown item type: " + itemName);
        };
    }
}
