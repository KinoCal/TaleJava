package gameItems.conreteClasses.equipment;

import gameItems.abstractClasses.Item;
import gameItems.interfaces.Weapon;

public class WeaponItem extends Item implements Weapon {

        private int damageValue;

    public WeaponItem(int itemIndex,String name, String type, int price, int damageValue, int quantity) {
        super(itemIndex,name, type, price, quantity);
        this.damageValue = damageValue;
    }

    @Override
    public int getDamageValue() {
        return damageValue;
    }

    @Override
    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
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
