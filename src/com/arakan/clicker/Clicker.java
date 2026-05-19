package com.arakan.clicker;

import com.arakan.clicker.controller.GameController;
import com.arakan.clicker.model.GameModel;
import com.arakan.clicker.view.GameView;

public class Clicker {
	
	public static void main(String[] args) {
		GameModel model = new GameModel();
        GameView view = new GameView(model.getUpgrades());
        new GameController(model, view);
	}
}
