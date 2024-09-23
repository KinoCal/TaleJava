package gameNPC;

import Factories.ItemFactories.Factories;
import gameUI.UI;
import main.Game;
import main.Player;

import javax.swing.*;
import java.awt.*;

public class TavernShopKeeper extends SuperShopKeeper {
	
	Factories factories = new Factories();
	public TavernShopKeeper(Game game, Player player, UI ui) {
        super(game,player,ui);

        setShopKeeperName("tavernShop");

		AddItemToShop(0,factories.createConsumable("HpPotion"));
		AddItemToShop(1,factories.createConsumable("MpPotion"));
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
