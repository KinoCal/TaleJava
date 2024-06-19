package gameItems.conreteClasses;

import gameItems.abstractClasses.AbstractItem;
import gameItems.interfaces.Weapon;

public class WeaponItem extends AbstractItem implements Weapon {

        private int damageValue;

        public WeaponItem(){

        }

    @Override
    public int getDamageValue() {
        return 0;
    }

    @Override
    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }

}
