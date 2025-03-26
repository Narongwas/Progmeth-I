package entity.counter;

import entity.base.Item;
import entity.base.Updatable;
import entity.container.Pan;
import logic.Player;

public class Stove extends Counter implements Updatable{
	
	public Stove() {
		super("Stove");
	}
	
	public Stove(Item content) {
		super(content);
		setName("Stove");
	}
	
	@Override
	public void interact(Player p) {
		if(!this.isPlacedContentEmpty() || p.getHoldingItem() instanceof Pan) {
			super.interact(p);
		} 
	}
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(this.getPlacedContent() instanceof Pan) {
			Pan panContent = (Pan)this.getPlacedContent();
			panContent.cook();
			this.setPlacedContent(panContent);
		}
	}
	
}
