package gameItems.conreteClasses.equipment;

import gameItems.abstractClasses.Item;
import gameItems.interfaces.Armor;

public class EmptyArmour extends Item implements Armor {


    @Override
    public int getArmorValue() {
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
