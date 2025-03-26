package card.base;

import player.Player;

//You CAN modify the first line
public abstract class UnitCard extends Card  {
	private int health;
	private int power;
	public UnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		super(name,flavorText,bloodCost);
		setHealth(health);
		setPower(power);
	}
	public abstract int attackUnit(UnitCard u);

	public int attackPlayer(Player opponent) {
		/*
		 Hint:
			Use takeDamage(int)
			from Player class
		 */
		opponent.takeDamage(this.power);
		return this.power;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getName() + "\tCost: " + this.getBloodCost() +"\t(POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}
	public int getHealth() {
		return this.health;
	}
	public int getPower() {
		return this.power;
	}
	public void setHealth(int health) {
		this.health = Math.max(0, health);
	}
	public void setPower(int power) {
		this.power = Math.max(0, power);
	}
	
}
