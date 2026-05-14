package com.arakan.clicker.controller;

import com.arakan.clicker.model.GameModel;
import com.arakan.clicker.view.GameView;

public class GameController {
	private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;

        initController();
        // コストの初期値の表示
        updateCostView();
        updateAutoCountCostView();
    }

    private void initController() {

    		// ボタンのクリックイベントの監視
        view.getClickButton().addActionListener(e -> {
            model.addFragment();
            updateView();
        });
        
        // クリックスコアのアップグレード
        view.getAddClickFragmentButton().addActionListener(e -> {
        	
        		// スコアがコストより少ない場合はリターン
        		if(model.getFragment() < model.getCost()) return;
        		
    			model.diffFragment();
    			model.upgradeClickPower();
    			model.upgradeCost();
    			updateCostView();
        });
        
        view.getAddAutoCountButton().addActionListener(e -> {
        	
        		// スコアがコストより少ない場合はリターン
        		if(model.getFragment() < model.getAutoCountCost()) return;
        		
    			model.fragmentDiffAutoCountCost();
    			model.upgradeAutoCount();
    			model.upgradeAutoCountCost();
    			updateAutoCountCostView();
        });
        
        // タイマー
        new javax.swing.Timer(1000, e -> {
            model.addAutoFragment();
            updateView();
        }).start();
    }

    // 獲得スコアをGUIに反映させる
    private void updateView() {
        view.setScore(model.getFragment());
    }
    
    private void updateCostView() {
    		view.setCost(model.getCost());
    }
    
    private void updateAutoCountCostView() {
    		view.setAutoCost(model.getAutoCountCost());
    }
}
