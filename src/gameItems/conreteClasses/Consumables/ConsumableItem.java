package gameItems.conreteClasses.Consumables;

import gameItems.abstractClasses.Item;
import gameItems.interfaces.Consumable;

public class ConsumableItem extends Item implements Consumable {
    private int healingValue;

    public ConsumableItem(int itemIndex, String name, String type, int price, int healingValue, int quantity) {
        super(itemIndex, name, type, price, quantity);
        this.healingValue = healingValue;
    }



    @Override
    public int getHealingValue() {
        return healingValue;
    }

    @Override
    public int setHealingValue(int healingValue) {
        return 0;
    }


    @Override
    public int setQuantity() {
        return 0;
    }

    @Override
    public int increaseQuantity() {
        return 0;
    }
}
