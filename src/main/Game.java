package main;

import GameStates.*;
import gameHandlers.*;
import gameUI.InventoryUI;
import gameUI.PlayerStatsUI;
import gameUI.ShopKeeperUI;
import gameUI.UI;

public class Game {
	
	GameState gameState;
	public Player player  = new Player(this);

	public UI ui = new UI(player, this); // create a new UI instance;

	public PlayerStatsUI playerStatsUI = new PlayerStatsUI(player, ui);
	public InventoryUI invoUI = new InventoryUI(player, ui);
	public ShopKeeperUI shopKeeperUI = new ShopKeeperUI(this,player,ui,invoUI);

	public ShopKeeperHandler shopKeeperHandler = new ShopKeeperHandler(this,player,ui,invoUI,shopKeeperUI);
	public InventoryHandler iHandler = new InventoryHandler(player, ui, this, invoUI, shopKeeperUI);
	public PlayerStatsHandler sHandler = new PlayerStatsHandler(this, player, ui, playerStatsUI);

	public TitleScreenState titleScreenState = new TitleScreenState(this, player, ui, invoUI);
	public TownState townState = new TownState(this, player, ui, invoUI);
	public TavernState tavernState = new TavernState(this, player, ui, invoUI,shopKeeperUI,shopKeeperHandler);
	public PlayerStatsScreenState playerStatsScreenState = new PlayerStatsScreenState(this, player, ui, sHandler, playerStatsUI);
	public PlayerInventoryState playerInventoryState = new PlayerInventoryState(this, player, ui, invoUI, iHandler);


	public static void main(String[] args) {
		
		new Game();

	}	
	
	public Game() {

			GameState.setCurrentState(titleScreenState);
			GameState.pushGameState(titleScreenState);
			player.setCurrentState(gameState);
		
	
			GameState.getCurrentState().update();
			GameState.getCurrentState().ui();
				
			
			}
		
	}
