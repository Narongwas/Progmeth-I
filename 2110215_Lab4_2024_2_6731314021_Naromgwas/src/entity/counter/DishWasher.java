package entity.counter;

import entity.base.Updatable;
import entity.container.Dish;
import logic.Player;

public class DishWasher extends Counter implements Updatable{
	public DishWasher() {
		super("Dish Washer");
	}
	
	@Override
	public void interact(Player p) {
		if(!this.isPlacedContentEmpty() ) {
			super.interact(p);
		} else if (p.getHoldingItem() instanceof Dish ) {
			Dish pDish = (Dish)p.getHoldingItem();
			if(pDish.isDirty()) {
				super.interact(p);
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(this.getPlacedContent() instanceof Dish) {
			Dish dishContent = (Dish)this.getPlacedContent();
			dishContent.clean(15);
			this.setPlacedContent(dishContent);
		}
	}
}
