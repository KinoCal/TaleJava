package Factories.ConsumableFactory;

import gameItems.abstractClasses.Item;
import gameItems.conreteClasses.Consumables.ConsumableItem;

public class ConsumableFactory {

    public ConsumableItem createItem(String itemName) {
        return switch (itemName) {
            case "HpPotion" -> new ConsumableItem(9, "Hp Potion", "Consumable", 2, 3);
            case "MpPotion" -> new ConsumableItem(9, "Mp Potion", "Consumable", 2, 3);
            default -> throw new IllegalArgumentException("Unknown item type: " + itemName);
        };
    }
}
