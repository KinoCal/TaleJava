package gameMonsters;

import Factories.ItemFactories.Factories;
import gameItems.abstractClasses.Item;

import java.util.ArrayList;
import java.util.Random;

public class SuperMonster {

	private String name;
	private int level;
	private int currentHp;
	private int maxHp;
	private int monsterDamage;
	private int monsterGold;
	private ArrayList<Item> lootTable = new ArrayList<>();
	private Factories factories = new Factories();

	public SuperMonster() {

	}

	public void HurtMonster(int damage){
		this.currentHp = this.currentHp - damage;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentHp() {
		return this.currentHp;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}

	public int getMonsterDamage() {
		return monsterDamage;
	}

	public void setMonsterDamage(int monsterDamage) {
		this.monsterDamage = monsterDamage;
	}

	public int getMaxHp() {
		return this.maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getMonsterGold() {
		return this.monsterGold;
	}

	public void setMonsterGold(int monsterGold) {
		this.monsterGold = monsterGold;
	}

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<Item> getLootTable() {
        return lootTable;
    }

	public Item getLootTableItemAtIndex(int index){
		Item lootTableItem = lootTable.get(index);
		return lootTableItem;
	}

	public Item randomMonsterLoot() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(10) + 1;
        Item lootItem = null;

        if (randomNumber < 3) {
            lootItem = getLootTableItemAtIndex(0);
			System.out.println(randomNumber);
        } else if (randomNumber > 8) {
			lootItem = getLootTableItemAtIndex(1);
			System.out.println(randomNumber);
		} else {
			lootItem = getLootTableItemAtIndex(2);
			System.out.println(randomNumber);
		}


		return lootItem;
    }

    public Factories getFactories() {
        return factories;
    }

    // Other getters and setters...
}
