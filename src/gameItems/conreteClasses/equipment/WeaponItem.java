package gameItems.conreteClasses.equipment;

import gameItems.abstractClasses.Item;
import gameItems.interfaces.Weapon;

public class WeaponItem extends Item implements Weapon {

        private int damageValue;

    public WeaponItem(int itemIndex,String name, String type, int price, int damageValue) {
        super(itemIndex,name, type, price);
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

}
