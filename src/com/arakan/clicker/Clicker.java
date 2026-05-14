package com.arakan.clicker;

import com.arakan.clicker.controller.GameController;
import com.arakan.clicker.model.GameModel;
import com.arakan.clicker.view.GameView;

public class Clicker {
	
	public Clicker() {
		
	}
	
	public static void main(String[] args) {
		GameModel model = new GameModel();
        GameView view = new GameView();
        new GameController(model, view);
	}
}
