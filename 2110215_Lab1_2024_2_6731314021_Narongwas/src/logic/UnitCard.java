package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;
	//
	public UnitCard(String name,int bloodCost,int power,int health,String flavorText) {
		setName(name);
		setBloodCost(bloodCost);
		setPower(power);
		setHealth(health);
		setFlavorText(flavorText);
	}
	
	public String getName() {
		return name;
	}

	public int getBloodCost() {
		return bloodCost;
	}

	public int getPower() {
		return power;
	}

	public int getHealth() {
		return health;
	}

	public String getFlavorText() {
		return flavorText;
	}

	public void setName(String name) {
		if(name.isBlank()) {
			this.name = "Creature";
		} else {
		this.name = name;
		}
	}

	public void setBloodCost(int bloodCost) {
		this.bloodCost = (bloodCost >= 0)? bloodCost: 0 ;
	}

	public void setPower(int power) {
		this.power = (power >= 0)? power: 0;
	}

	public void setHealth(int health) {
		this.health = (health >= 1)? health: 1;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}
	public boolean equals(UnitCard other) {
		return this.name.equals(other.name);
	}
	//
	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}
}
