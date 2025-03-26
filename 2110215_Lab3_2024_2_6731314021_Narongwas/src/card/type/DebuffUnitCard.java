package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class DebuffUnitCard extends UnitCard {	
	private int debuffPower;
	public DebuffUnitCard(String name, String flavorText, int bloodCost, int power, int health, int debuffPower) {
		super(name,flavorText,bloodCost,power,health);
		setDebuffPower(debuffPower);
	}
	
	@Override
	public int attackUnit(UnitCard unitCard) {
		int remainingHealth = unitCard.getHealth() - this.getPower();
		unitCard.setPower(unitCard.getPower()-this.debuffPower);
		if(remainingHealth <= 0) {
			int damage = unitCard.getHealth();
			unitCard.setHealth(remainingHealth);
			return damage;
		}
		unitCard.setHealth(remainingHealth);
		return this.getPower();
	}
	
	public int getDebuffPower() {
		return debuffPower;
	}
	public void setDebuffPower(int debuffPower) {
		this.debuffPower = Math.max(0, debuffPower);
	}	
	
	
}
