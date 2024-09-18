package Factories.ArmourFactory;

import gameItems.abstractClasses.Item;
import gameItems.conreteClasses.equipment.ArmourItem;

public class ArmourFactory {

    public ArmourItem createItem(String itemName) {
        return switch (itemName) {
            case "ClothBody" -> new ArmourItem("Cloth Body", "Armour", 2, 1);
            default -> throw new IllegalArgumentException("Unknown item type: " + itemName);
        };
    }
}
