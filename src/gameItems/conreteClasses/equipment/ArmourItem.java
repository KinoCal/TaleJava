package gameItems.conreteClasses.equipment;

import gameItems.abstractClasses.Item;
import gameItems.interfaces.Armor;

public class ArmourItem extends Item implements Armor {
    private int armourValue;

    public ArmourItem(int itemIndex, String name, String type, int price, int armourValue, int quantity) {
        super(itemIndex, name, type, price, quantity);
        this.armourValue = armourValue;
    }

    @Override
    public int getArmorValue() {
        return armourValue;
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
