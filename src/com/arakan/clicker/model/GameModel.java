package com.arakan.clicker.model;

public class GameModel {

	private int fragment = 0;
	private int cost = 100;
	private int autoCountCost = 100;
    private int clickPower = 1;
    private int autoCount = 1;

    // 獲得スコアを返す
    public int getFragment() {
        return fragment;
    }
    
    public int getCost() {
    	 return cost;
    }
    
    public int getAutoCountCost() {
    		return autoCountCost;
    }

    // ワンクリックのパワーを返す
    public int getClickPower() {
        return clickPower;
    }

    // クリックされた時に追加されるスコア
    public void addFragment() {
    		fragment += clickPower;
    }

    // クリックから獲得できるスコアを増やす
    public void upgradeClickPower() {
        clickPower++;
    }
    
    // 自動でスコア増やす
    public void addAutoFragment() {
    		fragment += autoCount;
    }
    
    // コストの更新
    public void upgradeCost() {
    		cost = (int)(cost * 1.2);
    }
    
    // コスト分スコアを引く
    public void diffFragment() {
    		fragment -= cost;
    }
    
    // 自動でスコアを増やす値を増やす
    public void upgradeAutoCount() {
    		autoCount++;
    }
    
    // 自動欠片収集のコストの更新
    public void upgradeAutoCountCost() {
    		autoCountCost = (int)(autoCountCost * 1.2);
    }
    
    public void fragmentDiffAutoCountCost() {
		fragment -= autoCountCost;
    }
}
