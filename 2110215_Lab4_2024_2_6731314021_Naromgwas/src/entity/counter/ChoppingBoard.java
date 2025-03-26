package entity.counter;

import entity.base.Choppable;
import entity.base.Ingredient;
import logic.Player;

public class ChoppingBoard extends Counter{
	public ChoppingBoard() {
		super("Chopping Board");
	}
	
	@Override
	public void interact(Player p) {
		if(!this.isPlacedContentEmpty()) {
			super.interact(p);
		} else if (p.getHoldingItem() instanceof Ingredient) {
			super.interact(p);
			if( this.getPlacedContent() instanceof Choppable) {
				Choppable choppable = (Choppable)this.getPlacedContent();
				choppable.chop();
				Ingredient holdingItem = (Ingredient)choppable;
				this.setPlacedContent(holdingItem);;
			}
		}
	}
}
