package logic.stone;

import logic.game.GameManager;
import utils.GameUtilities;

public class WalkingStone extends Stone{

	public WalkingStone(int posX, int posY) {
		super(posX, posY);
	}
	
	@Override
	public void dig(int digPower) {
		if(digPower > 1) {
			GameManager instance =  GameManager.getInstance();
			instance.setGameScore(instance.getGameScore()+1);
		}
		super.dig(digPower);
	}
	
	public void walk() {
		GameUtilities.moveWalkingRock(this);
	}
}
