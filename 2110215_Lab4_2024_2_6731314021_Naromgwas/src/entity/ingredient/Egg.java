package entity.ingredient;

import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Egg extends Ingredient implements Cookable{
	private int cookedPercentage;
	public Egg() {
		super("Egg");
		setCookedPercentage(0);
	}
	public int getCookedPercentage() {
		return cookedPercentage;
	}
	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = Math.max(0, cookedPercentage);
	}
	@Override
	public void cook() {
		// TODO Auto-generated method stub
		setCookedPercentage(getCookedPercentage()+12);
		if(0 < getCookedPercentage() && getCookedPercentage() <= 50) {
			setName("Raw Egg");
			setEdible(false);
		} else if (50 < getCookedPercentage() && getCookedPercentage() <= 80){
			setName("Sunny Side Egg");
			setEdible(true);
		} else if (80 < getCookedPercentage() && getCookedPercentage() <= 100) {
			setName("Fried Egg");
			setEdible(true);
		} else {
			setName("Burnt Egg");
			setEdible(false);
		}
	}
	@Override
	public boolean isBurnt() {
		// TODO Auto-generated method stub
		return (getCookedPercentage() > 100);
	}
	
	public String toString() {
		return StringUtil.formatNamePercentage(getName(), getCookedPercentage());
	}
	
}
