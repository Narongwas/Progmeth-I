package logic.stone;

import javax.security.auth.Destroyable;

import utils.GameUtilities;

public class Dynamite extends Stone{
	
	public Dynamite(int posx,int posy) {
		// TODO Auto-generated constructor stub
		super(posx, posy);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		for(Stone stone: GameUtilities.getAdjacentStones(posX, posY)) {
			stone.destroy();
		}
	}

	
}
