package gameItems.interfaces;

import gameItems.abstractClasses.Item;

public class Item_Empty extends Item implements gameItems.interfaces.Item {
    public int damageValue;
    public Item_Empty() {
        super(9," ", "Empty", 000,0);
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
