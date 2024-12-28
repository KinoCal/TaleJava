package Factories.WeaponFactory;

import gameItems.abstractClasses.Item;
import gameItems.conreteClasses.equipment.WeaponItem;

public class WeaponFactory {

    public WeaponItem createItem(String itemName) {
        return switch (itemName) {
            case "Dagger" -> new WeaponItem(0, "Dagger", "Equipment", 2, 1, 2);
            case "Sword" -> new WeaponItem(0, "Sword", "Equipment", 5, 3, 1);
            default -> throw new IllegalArgumentException("Unknown item type: " + itemName);
        };
    }
}
