package gameMonsters;

import gameUI.UI;
import main.Game;
import main.Player;

import javax.swing.*;
import java.awt.*;

public class Monster_Goblin extends SuperMonster{

	public Monster_Goblin(Game game, Player player, UI ui, int x, int y, int origX, int origY) {
		super(game, player, ui);

		setName("Goblin");
		setHp(10);
		setMaxHp(5);
		setMonsterGold(2);
		setMonsterDamage(1);

		monsterLabel = new JLabel();
		monsterLabel.setSize(25,50);
		monsterLabel.setBackground(Color.blue);
		monsterLabel.setOpaque(true);
		monsterLabel.setVisible(true);


	}
}
