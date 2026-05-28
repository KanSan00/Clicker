package com.arakan.clicker.controller;

import javax.swing.JButton;

import com.arakan.clicker.model.GameModel;
import com.arakan.clicker.model.upgrade.Tickable;
import com.arakan.clicker.model.upgrade.Upgrade;
import com.arakan.clicker.model.upgrade.UpgradeType;
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
            // Shiftキーが押されているか判定
            if ((e.getModifiers() & java.awt.event.ActionEvent.SHIFT_MASK) != 0) {
                // デバッグ用：一気に10,000増やす
                model.addDebugFragment(1000);
            } else {
                // 通常のクリック処理
                model.addFragment(model.getUpgrade(UpgradeType.CLICK));
            }
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
        
     // 10ミリ秒ごとに常に一定の速度で刻む（ゲームループ）
        new javax.swing.Timer(10, e -> {
            
            // モデル内のTickableなアップグレードすべてに通知する
            // (Model側に upgrades の中で Tickable を実装しているものを一斉に tick させるメソッドを作ると良いです)
            for (Upgrade up : model.getUpgrades()) {
                if (up instanceof Tickable) {
                		// int で発動回数を受け取る
                    int executions = ((Tickable) up).tick(10); 
                    
                    // 発動した回数分、スコアを追加する
                    for (int i = 0; i < executions; i++) {
                        model.addFragment(up);
                    }
                }
            }

            // 必要に応じて、何かが発動した時だけ view を更新する形にするとさらに効率的です
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
