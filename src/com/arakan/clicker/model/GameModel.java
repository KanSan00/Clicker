package com.arakan.clicker.model;

import java.util.ArrayList;
import java.util.List;

import com.arakan.clicker.model.upgrade.AutoUpgrade;
import com.arakan.clicker.model.upgrade.ClickUpgrade;
import com.arakan.clicker.model.upgrade.TimeUpgrade;
import com.arakan.clicker.model.upgrade.Upgrade;
import com.arakan.clicker.model.upgrade.UpgradeType;

public class GameModel {

	private int fragment = 0;
	
	private List<Upgrade> upgrades = new ArrayList<>();

    public GameModel() {
    		// 初期化
    	// まずインスタンス（実体）を変数として作る
        ClickUpgrade clickUp = new ClickUpgrade(UpgradeType.CLICK);
        AutoUpgrade autoUp = new AutoUpgrade(UpgradeType.AUTO);
        
        // 作ったものをリストに登録する
        upgrades.add(clickUp);
        upgrades.add(autoUp);
        
        // 時間短縮には、上で作った autoUp（同じ実体）を渡して連携させる！
        upgrades.add(new TimeUpgrade(UpgradeType.TIMESAVING, autoUp));
    }
    
    public List<Upgrade> getUpgrades() {
        return upgrades;
    }
    
    // 獲得スコアを返す
    public int getFragment() {
        return fragment;
    }

    // クリックされた時に追加されるスコア
    public void addFragment(Upgrade up) {
    		fragment += up.getAbility();
    }
    
    /**
     * 渡されたTypeからそのUpgradeを返す。
     * @param type
     * @return
     */
    public Upgrade getUpgrade(UpgradeType type) {
    		for(Upgrade up : upgrades) {
    			if(up.getType() == type) {
    				return up;
    			}
        }

        return null;
    }

    /**
     *  購入されたupgradeをアップグレードする
     * @param up
     */
    public void buyUpgrade(Upgrade up) {
    	
    	if(!canBuyUpgrade(up)) return;
    	
    	    fragment -= up.getCost();
    	    
    		up.increaseCost();
    		
    		up.buyUpgrade();
    }
    
    /**
     *  購入できるかどうかの判定
     * @param up
     * @return
     */
    public boolean canBuyUpgrade(Upgrade up) {
        return fragment >= up.getCost();
    }
    
    
    /**
     * 任意の数だけ増やす
     * @param amount
     */
    public void addDebugFragment(int amount) {
        this.fragment += amount;
    }
}
