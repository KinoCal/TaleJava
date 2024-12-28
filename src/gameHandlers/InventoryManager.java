package gameHandlers;


import gameItems.abstractClasses.Item;
import gameItems.conreteClasses.Consumables.ConsumableItem;
import gameItems.conreteClasses.equipment.ArmourItem;
import gameItems.conreteClasses.equipment.EmptyArmour;
import gameItems.conreteClasses.equipment.EmptyWeapon;
import gameItems.conreteClasses.equipment.WeaponItem;
import gameItems.interfaces.Item_Empty;
import main.Player;

public class InventoryManager {

    public void GivePlayerItem(Player player, Item item) {

        int slotNumber = 0;
        while(player.inventoryItems[slotNumber] != player.empty && slotNumber <4) {
            slotNumber++;
        }

        if(player.inventoryItems[slotNumber] == player.empty) {
            player.inventoryItems[slotNumber] = item;
        }
        else if(player.inventoryItems[slotNumber] != player.empty) {
            System.out.println("player inventory is full");
        }
    }

    public boolean BuyItem(Player player, Item item) {
        boolean itemSold = false;

        // First pass: check for an existing item with the same name
        for (int i = 0; i < 5; i++) {
            if (player.inventoryItems[i].getName().equals(item.getName())) {
                System.out.println("attempting to buy item..1");
                player.inventoryItems[i].increaseQuantity(1);
                player.setGold(-item.getPrice());
                itemSold = true;
                System.out.println("item sold " + item.getName());
                return itemSold; // Exit the method after increasing the quantity
            }
        }

        // Second pass: find the first empty slot to add the item
        for (int i = 0; i < 5; i++) {
            if (player.inventoryItems[i].getItemIndex() == 9) {
                System.out.println("attempting to buy item..2");
                player.inventoryItems[i] = item; // Add the item to the empty slot
                player.setGold(-item.getPrice());
                itemSold = true;
                System.out.println("item sold " + item.getName());
                break; // Exit the loop after placing the item
            }
        }

        if (!itemSold) {
            System.out.println("player inventory is full or not enough gold");
        }

        return itemSold;
    }




    public boolean SellItemToShop(Player player, Item item) {

        boolean itemSold;

        if(player.getPlayerInventoryIndex() >=0 || player.getPlayerInventoryIndex() <=4) {

            if (player.inventoryItems[player.getPlayerInventoryIndex()].getQuantity() < 2){

            System.out.println("Player sold: " + item.getName() + " for " + item.getPrice() + " Gold");
            player.inventoryItems[player.getPlayerItemIndex()] = player.empty;
            player.setGold(+item.getPrice());
            itemSold = true;

            }
            else {

                System.out.println("Player sold: " + item.getName() + " for " + item.getPrice() + " Gold");
                player.inventoryItems[player.getPlayerItemIndex()].increaseQuantity(-1);
                player.setGold(+item.getPrice());
                itemSold = true;

            }


        }
        else {
            itemSold = false;
            System.out.println("item not sold to shop@@@@");
        }
        return itemSold;
    }

    public void itemUsed(int slotNumber, Player player) {
        //set the item used = to a temporary SuperItem variable
        Item currentItem = player.inventoryItems[slotNumber];
        //check to see if the current item used is a Consumable
        if(currentItem instanceof ConsumableItem consumableItem) {
            System.out.println("Player used item: " + consumableItem.getName());
            player.healPlayer(consumableItem.getHealingValue());
            player.inventoryItems[slotNumber] = player.empty;
            System.out.println("Player healed for: " + consumableItem.getHealingValue());
        }
        else {
            System.out.println("no value found");
        }
    }

    public void equipItem(int slotNumber, Player player) {
        // Check if the slotNumber is valid
        if (slotNumber >= 0 && slotNumber < player.equippedItems.length) {
            //set the item used = to a temporary currentItem variable
            Item currentItem = player.inventoryItems[player.getPlayerItemIndex()];

            if (player.inventoryItems[player.getPlayerItemIndex()].getName().equals(player.equippedItems[currentItem.getItemIndex()].getName())){

                System.out.println("same item equipped");

            }

            else if(!currentItem.getName().equals(player.equippedItems[currentItem.getItemIndex()].getName())){

                System.out.println("test1");
                if (currentItem.getQuantity() > 1){
                    System.out.println("test2");
                    currentItem.increaseQuantity(-1);
                    UnEquipItem(player,player.equippedItems[currentItem.getItemIndex()]);
                    player.equippedItems[currentItem.getItemIndex()] = currentItem;

                } else if (currentItem.getQuantity() < 2) {

                    System.out.println("test3");
                    player.inventoryItems[player.getPlayerItemIndex()] = player.empty;
                    UnEquipItem(player,player.equippedItems[currentItem.getItemIndex()]);
                    player.equippedItems[currentItem.getItemIndex()] = currentItem;

                }

            }

            player.setCurrentWeapon((WeaponItem) player.equippedItems[0]);
            player.setCurrentArmor((ArmourItem) player.equippedItems[1]);
            player.setDamage(player.getCurrentWeapon().getDamageValue());
            player.setArmor(player.getCurrentArmor().getArmorValue());

        }
        else {
            System.out.println("No item found*");
        }
    }




    public void UnEquipItem(Player player, Item item) {


        for (int i = 0; i < player.inventoryItems.length; i++){
            if (player.inventoryItems[i].getName().equals(item.getName())){

                if (item instanceof WeaponItem){
                    player.equippedItems[item.getItemIndex()] = player.emptyWeapon;
                    player.inventoryItems[i].increaseQuantity(1);

                }
                if (item instanceof ArmourItem){
                    player.equippedItems[item.getItemIndex()] = player.emptyArmour;
                    player.inventoryItems[i].increaseQuantity(1);
                }
            } else if (player.inventoryItems[i] == player.empty) {

                if (item instanceof EmptyWeapon){
                    player.equippedItems[item.getItemIndex()] = player.emptyWeapon;
                    player.inventoryItems[i] = player.empty;

                }
                if (item instanceof EmptyArmour){
                    player.equippedItems[item.getItemIndex()] = player.emptyArmour;
                    player.inventoryItems[i] = player.empty;
                }
            }
        }

        int slotNumber = 0;
        while(player.inventoryItems[slotNumber] != player.empty && slotNumber <4) {
            slotNumber++;
        }
        if(player.inventoryItems[slotNumber] == player.empty) {
            if(player.equippedItems[item.getItemIndex()]==player.emptyWeapon || player.equippedItems[item.getItemIndex()]==player.emptyArmour){

                player.inventoryItems[slotNumber] = player.empty;
            }else {
                player.inventoryItems[slotNumber] = player.equippedItems[item.getItemIndex()];

            }

            if (item instanceof WeaponItem){
                player.equippedItems[item.getItemIndex()] = player.emptyWeapon;

            }
            if (item instanceof ArmourItem){
                player.equippedItems[item.getItemIndex()] = player.emptyArmour;
            }

            player.setCurrentWeapon((WeaponItem) player.equippedItems[0]);
            player.setCurrentArmor((ArmourItem) player.equippedItems[1]);
            player.setDamage(player.getCurrentWeapon().getDamageValue());
            player.setArmor(player.getCurrentArmor().getArmorValue());

        }
        else if(player.inventoryItems[slotNumber] != player.empty) {
            System.out.println("player inventory is full");
        }
    }



    public boolean IsInventoryFull(Player player) {

        int slotNumber = 0;
        boolean isFull = false;
        while(player.inventoryItems[slotNumber] != player.empty && slotNumber <4) {
            slotNumber++;
        }
        if(player.inventoryItems[slotNumber] == player.empty) {
            isFull = false;
        }
        else if(player.inventoryItems[slotNumber] != player.empty) {
            System.out.println("player inventory is full");
            isFull = true;
        }
        return isFull;

    }

    public String OutOfGoldMessage() {
        String string = "Sorry not enough gold...";
        return string;
    }
}