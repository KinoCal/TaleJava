package gameItems.conreteClasses.Consumables;

import gameItems.abstractClasses.Item;
import gameItems.interfaces.Consumable;

public class ConsumableItem extends Item implements Consumable {
    private int healingValue;

    public ConsumableItem(int itemIndex, String name, String type, int price, int healingValue) {
        super(itemIndex, name, type, price);
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


}
