package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable, Cookable{
	private boolean chopState;
	private int cookedPercentage;
	public Meat() {
		super("Meat");
		setChopState(false);
		setCookedPercentage(0);
	}
	@Override
	public void cook() {
		// TODO Auto-generated method stub
		if(!chopState) {
			cookedPercentage += 10;
			if(0 < getCookedPercentage() && getCookedPercentage() <= 50) {
				setName("Raw Meat");
				setEdible(false);
			} else if (50 < getCookedPercentage() && getCookedPercentage() <= 80){
				setName("Medium Rare Steak");
				setEdible(true);
			} else if (80 < getCookedPercentage() && getCookedPercentage() <= 100) {
				setName("Well Done Steak");
				setEdible(true);
			} else {
				setName("Burnt Steak");
				setEdible(false);
			}
		} else {
			cookedPercentage += 15;
			if(0 < getCookedPercentage() && getCookedPercentage() <= 80) {
				setName("Raw Burger");
				setEdible(false);
			} else if (80 < getCookedPercentage() && getCookedPercentage() <= 100) {
				setName("Cooked Burger");
				setEdible(true);
			} else {
				setName("Burnt Burger");
				setEdible(false);
			}
		}
	}
	@Override
	public boolean isBurnt() {
		// TODO Auto-generated method stub
		return cookedPercentage > 100;
	}
	@Override
	public void chop() {
		// TODO Auto-generated method stub
		if(!chopState) {
			setChopState(true);
			setName("Minced Meat");
		}
	}
	@Override
	public boolean isChopped() {
		// TODO Auto-generated method stub
		return chopState;
	}
	
	public String toString() {
		return StringUtil.formatNamePercentage(getName(), cookedPercentage);
	}
	
	public int getCookedPercentage() {
		return cookedPercentage;
	}
	public void setChopState(boolean chopState) {
		this.chopState = chopState;
	}
	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = Math.max(0, cookedPercentage);
	}
	
	
}
