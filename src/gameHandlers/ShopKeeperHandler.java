package gameHandlers;

import Factories.ItemFactories.Factories;
import gameItems.abstractClasses.Item;
import gameItems.conreteClasses.Consumables.ConsumableItem;
import gameItems.conreteClasses.equipment.ArmourItem;
import gameItems.conreteClasses.equipment.WeaponItem;
import gameNPC.SuperShopKeeper;
import gameNPC.TavernShopKeeper;
import gameUI.InventoryUI;
import gameUI.ShopKeeperUI;
import gameUI.UI;
import main.Game;
import main.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static GameStates.GameState.pushStateAndSetCurrent;

public class ShopKeeperHandler implements ActionListener {
    private Game game;
    private Player player;
    private UI ui;
    private InventoryUI invoUI;
    private ShopKeeperUI shopKeeperUI;
    private ArrayList<SuperShopKeeper> shopKeepers = new ArrayList<>();


    public ShopKeeperHandler(Game game, Player player, UI ui,InventoryUI invoUI, ShopKeeperUI shopKeeperUI){
        this.game = game;
        this.player = player;
        this.ui = ui;
        this.invoUI = invoUI;
        this.shopKeeperUI = shopKeeperUI;


        SuperShopKeeper tavernShopKeeper = new TavernShopKeeper(game,player,ui);
        AddShopKeeperToArray(tavernShopKeeper);

        shopKeeperUI.buyItemButton.addActionListener(this);
        shopKeeperUI.shopButtons[0].addActionListener(this);
        shopKeeperUI.shopButtons[1].addActionListener(this);
        shopKeeperUI.closeItemButton.addActionListener(this);
        shopKeeperUI.shopButtons[0].setText("Item1:" + tavernShopKeeper.getShopItems(0).getName());
        shopKeeperUI.shopButtons[1].setText("Item2:" + tavernShopKeeper.getShopItems(1).getName());


    }

    public void AddShopKeeperToArray(SuperShopKeeper shopKeeperObject){
        shopKeepers.add(shopKeeperObject);

    }

    public SuperShopKeeper GetShopKeeperFromIndex(int i){
        return shopKeepers.get(i);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();

        switch (yourChoice) {
            case"ShopKeeperButton":
                shopKeepers.get(0).shopKeeperButton.removeActionListener(this);
                System.out.println("ShopKeeperButton is pressed");
                pushStateAndSetCurrent(game.tavernState, player);


                break;

            case"button0":
            ui.RemoveOutputTextPanelAddInfoPanel();

            System.out.println("shop button 0 pressed");

            for (int i = 0; i < shopKeepers.size(); i++) {

                if(shopKeepers.get(i).getShopKeeperName().equals(player.getShopLocation())) {
                    System.out.println("inside");
                    if(shopKeepers.get(i).getShopItems(0) instanceof ConsumableItem currentItem) {

                        shopKeeperUI.itemLabel.setText("Item: " + currentItem.getName());
                        shopKeeperUI.itemShopPriceLabel.setText("Price: " + currentItem.getPrice());
                        shopKeeperUI.itemHealingValue.setText("Heals: " + currentItem.getHealingValue());
                        shopKeeperUI.itemHealingValue.setVisible(true);
                        shopKeeperUI.itemShopPriceLabel.setVisible(true);
                        shopKeeperUI.itemLabel.setVisible(true);
                        shopKeeperUI.buyItemButton.setText("Buy:");
                        shopKeeperUI.buyItemButton.setActionCommand("buyItem");
                        shopKeeperUI.buyItemButton.setVisible(true);
                        shopKeeperUI.closeItemButton.setVisible(true);
                        shopKeeperUI.equipmentDamageOrArmorValue.setVisible(false);
                        invoUI.CloseInventoryUI();
                        shopKeeperUI.RemoveInfoPanelAddShopKeeperItemInfoPanel();
                        //ui.RemoveOutputTextPanelAddInfoPanel();

                        player.setShopItemIndex(0);
                        System.out.println("shop item index" + player.getShopItemIndex());

                    }
                    else if (shopKeepers.get(i).getShopItems(0) instanceof WeaponItem currentItem) {

                            shopKeeperUI.itemLabel.setText("Item: " + currentItem.getName());
                            shopKeeperUI.itemShopPriceLabel.setText("Price: " + currentItem.getPrice());
                            shopKeeperUI.equipmentDamageOrArmorValue.setText("Damage: " + currentItem.getDamageValue());
                        }
                    else if(shopKeepers.get(i).getShopItems(0) instanceof ArmourItem currentItem) {
                            shopKeeperUI.equipmentDamageOrArmorValue.setText("Armor: " + currentItem.getArmorValue());

                        }



                        shopKeeperUI.itemShopPriceLabel.setVisible(true);
                        shopKeeperUI.itemLabel.setVisible(true);
                        shopKeeperUI.equipmentDamageOrArmorValue.setVisible(true);
                        shopKeeperUI.buyItemButton.setText("Buy:");
                        shopKeeperUI.buyItemButton.setActionCommand("buyItem");
                        shopKeeperUI.buyItemButton.setVisible(true);
                        shopKeeperUI.closeItemButton.setVisible(true);
                        shopKeeperUI.itemHealingValue.setVisible(false);
                        invoUI.CloseInventoryUI();
                        shopKeeperUI.RemoveInfoPanelAddShopKeeperItemInfoPanel();
                        //ui.RemoveOutputTextPanelAddInfoPanel();


                        player.setShopItemIndex(0);
                        player.setPlayerEquipmentIndex(0);
                        System.out.println("shop item index" + player.getShopItemIndex());

                    }
                }


            break;

            case "button1":
                ui.RemoveOutputTextPanelAddInfoPanel();

                System.out.println("shop button 1 pressed");
                for (int i = 0; i < shopKeepers.size(); i++) {

                    if(shopKeepers.get(i).getShopKeeperName().equals(player.getShopLocation())) {
                        System.out.println("inside");
                        if(shopKeepers.get(i).getShopItems(1) instanceof ConsumableItem currentItem) {

                            shopKeeperUI.itemLabel.setText("Item: " + currentItem.getName());
                            shopKeeperUI.itemShopPriceLabel.setText("Price: " + currentItem.getPrice());
                            shopKeeperUI.itemHealingValue.setText("Heals: " + currentItem.getHealingValue());
                            shopKeeperUI.itemHealingValue.setVisible(true);
                            shopKeeperUI.itemShopPriceLabel.setVisible(true);
                            shopKeeperUI.itemLabel.setVisible(true);
                            shopKeeperUI.buyItemButton.setText("Buy:");
                            shopKeeperUI.buyItemButton.setActionCommand("buyItem");
                            shopKeeperUI.buyItemButton.setVisible(true);
                            shopKeeperUI.closeItemButton.setVisible(true);
                            shopKeeperUI.equipmentDamageOrArmorValue.setVisible(false);
                            invoUI.CloseInventoryUI();
                            shopKeeperUI.RemoveInfoPanelAddShopKeeperItemInfoPanel();
                            //ui.RemoveOutputTextPanelAddInfoPanel();

                            player.setShopItemIndex(0);
                            System.out.println("shop item index" + player.getShopItemIndex());

                        }
                        else if (shopKeepers.get(i).getShopItems(0) instanceof WeaponItem currentItem) {

                            shopKeeperUI.itemLabel.setText("Item: " + currentItem.getName());
                            shopKeeperUI.itemShopPriceLabel.setText("Price: " + currentItem.getPrice());
                            shopKeeperUI.equipmentDamageOrArmorValue.setText("Damage: " + currentItem.getDamageValue());
                        }
                        else if(shopKeepers.get(i).getShopItems(0) instanceof ArmourItem currentItem) {
                            shopKeeperUI.equipmentDamageOrArmorValue.setText("Armor: " + currentItem.getArmorValue());

                        }



                        shopKeeperUI.itemShopPriceLabel.setVisible(true);
                        shopKeeperUI.itemLabel.setVisible(true);
                        shopKeeperUI.equipmentDamageOrArmorValue.setVisible(true);
                        shopKeeperUI.buyItemButton.setText("Buy:");
                        shopKeeperUI.buyItemButton.setActionCommand("buyItem");
                        shopKeeperUI.buyItemButton.setVisible(true);
                        shopKeeperUI.closeItemButton.setVisible(true);
                        shopKeeperUI.itemHealingValue.setVisible(false);
                        invoUI.CloseInventoryUI();
                        shopKeeperUI.RemoveInfoPanelAddShopKeeperItemInfoPanel();
                        //ui.RemoveOutputTextPanelAddInfoPanel();


                        player.setShopItemIndex(1);
                        player.setPlayerEquipmentIndex(1);
                        System.out.println("shop item index" + player.getShopItemIndex());

                    }
                }
                break;

            case "buyItem":

                System.out.println("check");
                for(int i = 0; i < player.inventoryItems.length; i++) {
                    System.out.println(player.inventoryItems[i].getName());
                }
                InventoryManager inventoryManager = new InventoryManager();
                //check if player inventory is full

                for (int i = 0; i < shopKeepers.size(); i++) {
                    if (shopKeepers.get(i).getShopKeeperName().equals(player.getShopLocation())) {
                        if (inventoryManager.BuyItem(player, shopKeepers.get(i).getShopItems(player.getShopItemIndex()))) {
                            System.out.println("attempting to sell player item..");

                            ui.goldLabel.setText(" Gold: " + player.getGold());
                            ui.hpPotLabel.setText(" Hp Pots: " + player.getHpPotionArray().size());
                            ui.mpPotLabel.setText(" Mp Pots: " + player.getMpPotionArray().size());
                            System.out.println("-" + shopKeepers.get(i).getShopItems(player.getShopItemIndex()).getPrice() + "gold");
                            System.out.println(player.getGold());

                            invoUI.refreshInventoryButtons();//always!!
                            //ui.RemoveInfoPanelAddOutputTextPanel();
                            shopKeeperUI.RemoveShopKeeperItemInfoPanelAddOutputTextPanel();
                            ui.updateGameTextOutputArea(shopKeepers.get(i).SellMessage(shopKeepers.get(i).getShopItems(player.getShopItemIndex())));

                        } else {
                            ui.RemoveInfoPanelAddOutputTextPanel();
                            ui.updateGameTextOutputArea("Can't buy item");
                            System.out.println("out of gold or invo full*");

                        } {
                        System.out.println("end of buyItem case check");

                        System.out.println("shop item index" + player.getShopItemIndex());

                        }
                    }
                }

                break;

            case "closeItem":

                shopKeeperUI.CloseShopItemInfoUI();
                shopKeeperUI.RemoveShopKeeperItemInfoPanelAddOutputTextPanel();
                invoUI.CloseInventoryUI();

                break;


            case "":
                System.out.println("already in tavern");
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + yourChoice);
        }

    }
    }

