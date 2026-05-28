package com.arakan.clicker.model.upgrade;

public class AutoUpgrade extends Upgrade implements Tickable {

	private int elapsedTime = 0; // 溜まった時間
    private int interval = 1000; // 実行する間隔（初期値は1000ms = 1秒）
	
	public AutoUpgrade(UpgradeType type) {
		super(type);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public int getInterval() {
		return interval;
	}

	@Override
	public void buyUpgrade() {
		// 購入されるたびに、1回で獲得できる量を1増やす
	    this.ability++;
	}

	@Override
	public int tick(int deltaTime) {
        if (ability <= 0) return 0;

        elapsedTime += deltaTime;
        int executionCount = 0;

        // 設定された間隔を超えた分だけカウントする
        while (elapsedTime >= interval) {
            executionCount++;
            elapsedTime -= interval; 
        }	
        
        return executionCount; // 発動した回数を返す
	}
	
	// 「時間短縮」のアップグレードが購入されたら、この interval を縮める
    public void shortenInterval(int ms) {
        this.interval = Math.max(50, this.interval - ms); // 最速でも50msにする等の制限
    }

}
