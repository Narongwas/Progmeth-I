package entity.container;

import entity.base.Container;
import entity.base.Cookable;
import entity.base.Ingredient;

public class Pan extends Container{
	public Pan() {
		super("Pan",1);
	}

	@Override
	public boolean verifyContent(Ingredient i) {
		// TODO Auto-generated method stub
		return (i instanceof Cookable);
	}
	
	public void cook() {
		for(Ingredient i : getContent()) {
			if(verifyContent(i)) {
				Cookable tocookI = (Cookable)i;
				tocookI.cook();
				i = (Ingredient) tocookI;
			}
		}
	}
	
}
