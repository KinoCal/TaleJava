package gameItems.interfaces;

import gameItems.abstractClasses.Item;

public class Item_Empty extends Item implements gameItems.interfaces.Item {
    public int damageValue;
    public Item_Empty() {
        super(000,"Empty", "Empty", 000);
    }

}
