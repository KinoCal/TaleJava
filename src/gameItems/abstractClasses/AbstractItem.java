package gameItems.abstractClasses;

import gameItems.interfaces.Item;

public abstract class AbstractItem implements Item {

    private int itemIndex;
    private String name;
    private String type;
    private int price;

    public AbstractItem(){


    }

    @Override
    public int getItemIndex() {
        return itemIndex;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
