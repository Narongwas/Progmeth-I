package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class NormalUnitCard extends UnitCard {
	
	public NormalUnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		super(name,flavorText,bloodCost,power,health);
	}
	
	@Override
	public int attackUnit(UnitCard unitCard) {
		int remainingHealth = unitCard.getHealth() - this.getPower();
		if(remainingHealth <= 0) {
			int damage = unitCard.getHealth();
			unitCard.setHealth(remainingHealth);
			return damage;
		}
		unitCard.setHealth(remainingHealth);
		return this.getPower();
	}
	
}

