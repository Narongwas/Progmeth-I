package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class LeaderUnitCard extends UnitCard {
	
	
	private int buffPower;
	private int buffHealth;
	public LeaderUnitCard(String name, String flavorText, int bloodCost, int power, int health, int buffPower, int buffHealth) {
		super(name, flavorText, bloodCost, power, health);
		setBuffHealth(buffHealth);
		setBuffPower(buffPower);
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
		return getPower();
	}
	
	public void buffUnit(UnitCard[] alliesCard) {
		for(UnitCard unitCard:alliesCard) {
			if(unitCard != null) {
				unitCard.setHealth(unitCard.getHealth()+this.buffHealth);
				unitCard.setPower(unitCard.getPower()+this.buffPower);
			}
		}
	}
	
	@Override
	public String toString() {
		return super.getName() + " (POW: " + super.getPower() + ", HP: " + super.getHealth() + 
				" | POW Inc: "+ this.getBuffPower() + ", HP Inc: " + this.getBuffHealth() + ")";
	}

	public int getBuffPower() {
		return buffPower;
	}

	public int getBuffHealth() {
		return buffHealth;
	}

	public void setBuffPower(int buffPower) {
		this.buffPower = Math.max(0, buffPower);
	}

	public void setBuffHealth(int buffHealth) {
		this.buffHealth = Math.max(0, buffHealth);
	}
	
	

}