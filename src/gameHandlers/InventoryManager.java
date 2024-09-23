package gameHandlers;


import gameItems.abstractClasses.Item;
import gameItems.conreteClasses.Consumables.ConsumableItem;
import gameItems.conreteClasses.equipment.ArmourItem;
import gameItems.conreteClasses.equipment.EmptyWeapon;
import gameItems.conreteClasses.equipment.WeaponItem;
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
		
		int slotNumber = 0;
		boolean itemSold = false;
		while(player.inventoryItems[slotNumber] != player.empty && slotNumber <4) {
			slotNumber++;
		}
		if(player.inventoryItems[slotNumber] == player.empty && player.getGold() >= item.getPrice()) {
			if (item.getName().equals("Hp Potion")){

				System.out.println("attempting to buy item..");
				player.addHpPotion(item);

				player.setGold(-item.getPrice());

				itemSold = true;
				System.out.println("item sold " + item.getName());
			} else if (item.getName().equals("Mp Potion")) {

				System.out.println("attempting to buy item..");
				player.addMpPotion(item);

				player.setGold(-item.getPrice());

				itemSold = true;
				System.out.println("item sold " + item.getName());
			} else {
				System.out.println("attempting to buy item..");

				player.inventoryItems[slotNumber] = item;
				player.setGold(-item.getPrice());

				itemSold = true;
				System.out.println("item sold " + item.getName());
			}
			
		}
		else if(!player.inventoryItems[slotNumber].getName().isEmpty() || player.getGold() < item.getPrice()) {
				System.out.println("player inventory is full or not enough gold");
		}
		return itemSold;
	}
	
	public boolean SellItemToShop(Player player, Item item) {

		boolean itemSold;

		if(player.getPlayerInventoryIndex() >=0 || player.getPlayerInventoryIndex() <=4) {
			System.out.println("Player sold: " + item.getName() + " for " + item.getPrice() + " Gold");
			player.inventoryItems[player.getPlayerItemIndex()] = player.empty;
			player.setGold(+item.getPrice());
			itemSold = true;

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

			if (player.equippedItems[currentItem.getItemIndex()] == player.emptyWeapon || player.equippedItems[currentItem.getItemIndex()] == player.emptyArmour){
				player.inventoryItems[player.getPlayerItemIndex()] = player.empty;
			} else {

				player.inventoryItems[player.getPlayerItemIndex()] = player.equippedItems[currentItem.getItemIndex()];
			}

				player.equippedItems[currentItem.getItemIndex()] = currentItem;
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
