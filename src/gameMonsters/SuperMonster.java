package gameMonsters;

import gameUI.UI;
import main.Game;
import main.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class SuperMonster {

	private String name;
	private int hp;
	private int maxHp;
	private int monsterDamage;

	public JLabel monsterLabel;
	protected Player player;
	protected UI ui;
	protected Game game;
	private int monsterGold;

	public SuperMonster(Game game, Player player, UI ui) {
		this.game = game;
		this.player = player;
		this.ui = ui;
	}

	public void DropLoot() {
		player.setGold(this.monsterGold);
		ui.goldLabel.setText(" Gold: " + player.getGold());
	}

	public void HurtMonster(int damage){
		this.hp = this.hp - damage;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public JLabel getMonsterLabel() {
		return monsterLabel;
	}

	public void setMonsterLabel(JLabel monsterLabel) {
		this.monsterLabel = monsterLabel;
	}

	public int getMonsterDamage() {
		return monsterDamage;
	}

	public void setMonsterDamage(int monsterDamage) {
		this.monsterDamage = monsterDamage;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getMonsterGold() {
		return monsterGold;
	}

	public void setMonsterGold(int monsterGold) {
		this.monsterGold = monsterGold;
	}

	// Other getters and setters...
}
