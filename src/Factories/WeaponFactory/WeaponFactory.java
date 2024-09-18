package Factories.WeaponFactory;

import gameItems.abstractClasses.Item;
import gameItems.conreteClasses.equipment.WeaponItem;

public class WeaponFactory {

    public WeaponItem createItem(String itemName) {
        return switch (itemName) {
            case "Dagger" -> new WeaponItem("Dagger", "Weapon", 2, 1);
            default -> throw new IllegalArgumentException("Unknown item type: " + itemName);
        };
    }
}
