package gameNPC;

import gameItems.SuperItem;
import gameUI.UI;
import main.Game;
import main.Player;

import javax.swing.*;

public class SuperShopKeeper {
    private SuperItem[] shopItems = new SuperItem[5];
    public JButton shopKeeperButton;
    private String shopKeeperName;

    protected Player player;
    protected UI ui;
    protected Game game;

    public SuperShopKeeper(Game game, Player player, UI ui) {
        this.game = game;
        this.player = player;
        this.ui = ui;
    }



    public void AddItemToShop(int index, SuperItem item) {
        if (index >= 0 && index < shopItems.length) {
            shopItems[index] = item;
        } else {
            // Handle index out of bounds error
            System.out.println("Index out of bounds");
        }
    }

    public String SellMessage(SuperItem item) {
        String string = "Item Bought: " + item.getName() + " -" + item.getPrice() + "gold";
        return string;
    }

    public SuperItem getShopItems(int i) {
        return shopItems[i];
    }

    public void setShopItems(SuperItem[] shopItems) {
        this.shopItems = shopItems;
    }


    public String getShopKeeperName() {
        return shopKeeperName;
    }

    public void setShopKeeperName(String shopKeeperName) {
        this.shopKeeperName = shopKeeperName;
    }
}
