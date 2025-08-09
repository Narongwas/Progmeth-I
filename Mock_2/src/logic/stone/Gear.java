package logic.stone;

import logic.game.GameManager;

public class Gear extends HardStone{
	private int upgradeValue;

	
	public Gear(int posX, int posY) {
		super(posX,posY,2);
		setUpgradeValue(1);
	}
	
	public Gear(int posX, int posY, int upgradeValue) {
		super(posX,posY,2);
		setUpgradeValue(upgradeValue);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		GameManager instance = GameManager.getInstance();
		instance.addDigPower(upgradeValue);
	}
	
	public int getUpgradeValue() {
		return upgradeValue;
	}

	public void setUpgradeValue(int upgradeValue) {
		this.upgradeValue = Math.max(1, upgradeValue);
	}
	
	
}
