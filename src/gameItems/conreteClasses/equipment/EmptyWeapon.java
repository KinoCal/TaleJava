package gameItems.conreteClasses.equipment;

import gameItems.abstractClasses.Item;
import gameItems.interfaces.Weapon;

public class EmptyWeapon extends Item implements Weapon {

    @Override
    public int getDamageValue() {
        return 0;
    }

    @Override
    public void setDamageValue(int damageValue) {

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
