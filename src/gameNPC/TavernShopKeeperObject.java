package gameNPC;

import gameEquipment.Weapon_Dagger;
import gameItems.Item_Hp_Potion;
import gameItems.Item_Mp_Potion;
import gameUI.UI;
import main.Game;
import main.Player;

import javax.swing.*;
import java.awt.*;

public class TavernShopKeeperObject extends SuperShopKeeperObject {

	private Item_Hp_Potion potion = new Item_Hp_Potion();
	private Weapon_Dagger dagger = new Weapon_Dagger();
	private Item_Mp_Potion mpPotion = new Item_Mp_Potion();
	
	
	
	public TavernShopKeeperObject(Game game, Player player, UI ui) {
        super(game,player,ui);

        setShopKeeperName("tavernShop");

		AddItemToShop(0,potion);
		AddItemToShop(1,mpPotion);
		//AddItemToShop(2,potion);
		//AddItemToShop(3,potion);
		//AddItemToShop(4,potion);


		shopKeeperButton = new JButton();
		shopKeeperButton.setBackground(Color.pink);
		shopKeeperButton.setOpaque(true);
		shopKeeperButton.setVisible(true);
		shopKeeperButton.setFocusable(true);
		//ui.buttonPanel.add(shopKeeperButton);
		
	}
	



}
