package gameItems.abstractClasses;

public abstract class Item implements gameItems.interfaces.Item {

    private int itemIndex;
    private String name;
    private String type;
    private int price;

    public Item( int itemIndex, String name, String type, int price){
        this.itemIndex = itemIndex;
        this.name = name;
        this.type = type;
        this.price = price;
    }
    public Item(){

    }


    @Override
    public int getItemIndex(){return itemIndex;}
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
