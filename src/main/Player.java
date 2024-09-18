package main;
//MAKE A GET INVENTORY FUNCTION THAT DISPLAYS THE PLAYERS INVO INFO TO THE UI UPDATE TEXT AREA
//
import Factories.ItemFactories.Factories;
import GameStates.GameState;
import gameItems.abstractClasses.Item;
import gameItems.conreteClasses.equipment.ArmourItem;
import gameItems.conreteClasses.equipment.WeaponItem;
import gameItems.interfaces.Item_Empty;

import java.util.ArrayList;

public class Player {
    public Game game;
    Factories factory = new Factories();
    private String shopLocation;
    private GameState currentState;
    private WeaponItem currentWeapon;
    private ArmourItem currentArmor;
    private int maxHp;
    private int currentHp;
    private int maxMp;
    private int currentMp;
    private int maxExp;
    private int currentExp;
    private int strengthStat;
    private int defenceStat;
    private int level;
    private int gold;
    private int damage;
    private int armor;
    private boolean playerAlive;
    private boolean inventoryFull;
    private String shopStatus;
    private String inventoryStatus;
    private String statScreenStatus;
    private String textFieldStatus;
    private int playerItemIndex;
    private int playerEquipmentIndex;
    private int playerInventoryIndex;
    private int shopItemIndex;
	public Item empty = new Item_Empty();
    public WeaponItem dagger = factory.createWeapon("Dagger");
    public ArmourItem clothBody = factory.createArmour("ClothBody");

    public Item hpPotion = factory.createConsumable("HpPotion");
    public Item mpPotion = factory.createConsumable("MpPotion");

    public Item[] equippedItems = new Item[3];
	public Item[] inventoryItems = new Item[5];

    private ArrayList<Item> hpPotionArray = new ArrayList<>();
    private ArrayList<Item> mpPotionArray = new ArrayList<>();

    public Player( Game game) {
    	this.game = game;

        equippedItems[0] = empty;
        equippedItems[1] = empty;
        equippedItems[2] = empty;

        hpPotionArray.add(hpPotion);
        mpPotionArray.add(mpPotion);

        inventoryItems[0] = clothBody;
        inventoryItems[1] = dagger;
        inventoryItems[2] = empty;
        inventoryItems[3] = empty;
        inventoryItems[4] = empty;

        currentWeapon = (WeaponItem) equippedItems[0];
        currentArmor = (ArmourItem) equippedItems[1];

        level = 1;
        maxHp = 10;
        currentHp = maxHp;
        maxMp = 10;
        currentMp = maxMp;
        strengthStat = 1;
        defenceStat = 1;
        damage = currentWeapon.getDamageValue();
        armor = currentArmor.getArmorValue();
        currentExp = 0;
        maxExp = level * 10;
        gold = 100;
        playerAlive = true;

        shopLocation = "none";
        statScreenStatus = "close";
        inventoryStatus = "close";
        shopStatus = "close";
        textFieldStatus = "close";

        setPlayerItemIndex(-1);
        setPlayerInventoryIndex(-1);



    }

    public boolean IsPlayerHpZero(){
        boolean isZero = false;
        if (getCurrentHp() == 0){
            System.out.println("player is dead");
            setCurrentHp(0);
            isZero = true;
        }
        return isZero;
    }

    public  GameState getCurrentState() {
        return currentState;
    }
    public void setAbsoluteCurrentState() {
    	currentState = GameState.getCurrentState();
    }
    public void setCurrentState(GameState state) {
        currentState = state;
    }      

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getCurrentMp() {
        return currentMp;
    }

    public void setCurrentMp(int currentMp) {
        this.currentMp += currentMp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold += gold;
    }

    public boolean isPlayerAlive() {
        return playerAlive;
    }

    public void setPlayerAlive(boolean playerAlive) {
        this.playerAlive = playerAlive;
    }

    public void gainXp(int amount) {
        setCurrentExp(getCurrentExp() + amount);
        if (getCurrentExp() >= getMaxExp()) {
            levelUp();
        }
    }

    private void levelUp() {
        setLevel(getLevel() + 1);
        setCurrentExp(0);
        setMaxExp(getLevel() * 10);
    }
    
    public void takeDamage(int damage) {
        setCurrentHp(Math.max(0, getCurrentHp() - damage));
        if (getCurrentHp() == 0) {
            setPlayerAlive(false);
        }
    }

    public void healPlayer(int amount) {
        setCurrentHp(Math.min(getMaxHp(), getCurrentHp() + amount));
        if (currentHp > maxHp) {
        	setCurrentHp(maxHp);
        }
    }

    public void restoreMp(int amount) {
        setCurrentMp(Math.min(getMaxMp(), getCurrentMp() + amount));
        
    }

	public  String getInventoryStatus() {
		return inventoryStatus;
	}

	public  void setInventoryStatus(String inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	
		

	public int getPlayerItemIndex() {
		return playerItemIndex;
	}



	public void setPlayerItemIndex(int playerItemIndex) {
		this.playerItemIndex = playerItemIndex;
	}
	



	public boolean setInventoryFull(boolean inventoryFull) {
		return this.inventoryFull = inventoryFull;
	}
	
	public boolean getInventoryFull() {
		
		return inventoryFull;
	}



	public int getPlayerEquipmentIndex() {
		return playerEquipmentIndex;
	}



	public void setPlayerEquipmentIndex(int playerEquipmentIndex) {
		this.playerEquipmentIndex = playerEquipmentIndex;
	}



	public Item getCurrentWeapon() {
		return currentWeapon;
	}



	public void setCurrentWeapon(Item currentWeapon) {
		this.currentWeapon = (WeaponItem) currentWeapon;
	}



	public Item getCurrentArmor() {
		return currentArmor;
	}



	public void setCurrentArmor(Item currentArmor) {
		this.currentArmor = (ArmourItem) currentArmor;
	}



	public int getDamage() {
		return damage;
	}



	public void setDamage(int damage) {
		this.damage = damage;
	}



	public int getArmor() {
		return armor;
	}



	public void setArmor(int armor) {
		this.armor = armor;
	}



	public String getShopStatus() {
		return shopStatus;
	}



	public void setShopStatus(String string) {
		this.shopStatus = string;
	}



	public int getPlayerInventoryIndex() {
		return playerInventoryIndex;
	}



	public void setPlayerInventoryIndex(int playerInventoryIndex) {
		this.playerInventoryIndex = playerInventoryIndex;
	}



	public int getStrengthStat() {
		return strengthStat;
	}



	public void setStrengthStat(int strengthStat) {
		this.strengthStat = strengthStat;
	}



	public int getDefenceStat() {
		return defenceStat;
	}



	public void setDefenceStat(int defenceStat) {
		this.defenceStat = defenceStat;
	}
	
	@Override
	public String toString() {
	    return "Player{" +
	            "currentState=" + currentState +
	            ", currentWeapon=" + currentWeapon.getName() +
	            ", currentArmor=" + currentArmor.getName() +
	            ", maxHp=" + maxHp +
	            ", currentHp=" + currentHp +
	            ", maxMp=" + maxMp +
	            ", currentMp=" + currentMp +
	            ", maxExp=" + maxExp +
	            ", currentExp=" + currentExp +
	            ", strengthStat=" + strengthStat +
	            ", defenceStat=" + defenceStat +
	            ", level=" + level +
	            ", gold=" + gold +
	            ", damage=" + getDamage() +
	            ", armor=" + armor +
	            ", playerAlive=" + playerAlive +
	            ", inventoryFull=" + inventoryFull +
	            ", shopStatus='" + shopStatus + '\'' +
	            ", inventoryStatus='" + inventoryStatus + '\'' +
	            ", playerItemIndex=" + playerItemIndex +
	            ", playerEquipmentIndex=" + playerEquipmentIndex +
	            ", playerInventoryIndex=" + playerInventoryIndex +
	            '}';
	}


    public int getShopItemIndex() {
        return shopItemIndex;
    }

    public void setShopItemIndex(int shopItemIndex) {
        this.shopItemIndex = shopItemIndex;
    }

    public String getStatScreenStatus() {
        return statScreenStatus;
    }

    public void setStatScreenStatus(String statScreenStatus) {
        this.statScreenStatus = statScreenStatus;
    }

    public boolean isInventoryIndexEmpty(int index){
        Boolean isEmpty;
        if (inventoryItems[index].getName().isEmpty()){
            isEmpty = true;
        }else {
            isEmpty = false;
        }
        return isEmpty;
    }



    public String getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(String shopLocation) {
        this.shopLocation = shopLocation;
    }


    public String getTextFieldStatus() {
        return textFieldStatus;
    }

    public void setTextFieldStatus(String textFieldStatus) {
        this.textFieldStatus = textFieldStatus;
    }



    public ArrayList<Item> getHpPotionArray() {
        return hpPotionArray;
    }

    public void setHpPotionArray(ArrayList<Item> hpPotionArray) {
        this.hpPotionArray = hpPotionArray;
    }

    // Method to add a potion to the player's inventory
    public void addHpPotion(Item potion) {
        hpPotionArray.add(potion);
    }

    // Method to remove a potion from the player's inventory
    public void removeHpPotion() {
        hpPotionArray.remove(0);
    }

    public ArrayList<Item> getMpPotionArray() {
        return mpPotionArray;
    }

    public void setMpPotionArray(ArrayList<Item> mpPotionArray) {
        this.mpPotionArray = mpPotionArray;
    }

    // Method to add a potion to the player's inventory
    public void addMpPotion(Item potion) {
        mpPotionArray.add(potion);
    }

    // Method to remove a potion from the player's inventory
    public void removeMpPotion() {
        hpPotionArray.remove(0);
    }


}

