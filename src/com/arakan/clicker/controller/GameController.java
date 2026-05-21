package com.arakan.clicker.controller;

import javax.swing.JButton;

import com.arakan.clicker.model.GameModel;
import com.arakan.clicker.model.Upgrade;
import com.arakan.clicker.model.UpgradeType;
import com.arakan.clicker.view.GameView;

public class GameController {
	private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;

        initController();
        updateView();
    }

    private void initController() {

    		// ボタンのクリックイベントの監視
        view.getClickButton().addActionListener(e -> {
            model.addFragment(model.getUpgrade(UpgradeType.CLICK));
            updateView();
        });
        
        // 強化項目のアップグレード
        for(Upgrade up : model.getUpgrades()) {
            JButton button = view.getUpgradeButton(up);
            button.addActionListener(e -> {
            		model.buyUpgrade(up);
            		updateView();
            	});
        }
        
        // タイマー
        new javax.swing.Timer(1000, e -> {
        		model.addFragment(model.getUpgrade(UpgradeType.AUTO));
            updateView();
        }).start();
    }

    // 獲得スコアをGUIに反映させる
    private void updateView() {
    		// スコア更新
    		view.setScore(model.getFragment());
    		for(Upgrade up : model.getUpgrades()) {
    	    		// 購入可能か
    	    		view.updateUpgradeButton(up, model.canBuyUpgrade(up));
    	    }
    }
}
