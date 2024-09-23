package gameItems.conreteClasses.equipment;

import gameItems.abstractClasses.Item;
import gameItems.interfaces.Armor;

public class EmptyArmour extends Item implements Armor {


    @Override
    public int getArmorValue() {
        return 0;
    }
}
