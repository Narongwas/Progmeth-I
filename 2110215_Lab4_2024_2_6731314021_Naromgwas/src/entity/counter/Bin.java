package entity.counter;

import entity.base.Container;
import entity.base.Ingredient;
import logic.Player;

public class Bin extends Counter{
	public Bin() {
		// TODO Auto-generated constructor stub
		super("Bin");
	}
	
	@Override
	public void interact(Player p) {
		if(!p.isHandEmpty() && p.getHoldingItem() instanceof Ingredient) {
			p.setHoldingItem(null);
		} else if (!p.isHandEmpty() && p.getHoldingItem() instanceof Container) {
			Container container = (Container)p.getHoldingItem();
			container.clearContent();
			p.setHoldingItem(container);
		}
	}
}
