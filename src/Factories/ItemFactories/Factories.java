package Factories.ItemFactories;

import Factories.ArmourFactory.ArmourFactory;
import Factories.ConsumableFactory.ConsumableFactory;
import Factories.WeaponFactory.WeaponFactory;
import gameItems.abstractClasses.Item;
import gameItems.conreteClasses.Consumables.ConsumableItem;
import gameItems.conreteClasses.equipment.ArmourItem;
import gameItems.conreteClasses.equipment.WeaponItem;

public class Factories {

    private WeaponFactory weaponFactory = new WeaponFactory();
    private ArmourFactory armourFactory = new ArmourFactory();
    private ConsumableFactory consumableFactory = new ConsumableFactory();

    // Method to create a weapon using the WeaponFactory
    public WeaponItem createWeapon(String itemName) {
        return weaponFactory.createItem(itemName);
    }


    // Similarly, you can add methods for ArmourFactory, if needed
    public ArmourItem createArmour(String itemName){
        return armourFactory.createItem(itemName);
    }

    public ConsumableItem createConsumable(String itemName){
        return consumableFactory.createItem(itemName);
    }
}
