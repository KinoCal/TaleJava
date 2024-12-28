package gameItems.interfaces;

public interface Item {

    int getItemIndex();
    String getName();
    String getType();
    int getPrice();

    String ToString();

    int getQuantity();
    int setQuantity();
    int increaseQuantity();

}
