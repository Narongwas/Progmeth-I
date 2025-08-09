package logic.stone;

public class HardStone extends Stone{
	
	protected int durability;
	
	public HardStone(int posx,int posy ,int durability) {
		super(posx, posy);
		setDurability(durability);
	}
	
	@Override
	public void dig(int digPower) {
		setDurability(getDurability()-digPower);
		if(getDurability() == 0) {
			destroy();
		}
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = Math.max(0, durability);
		this.durability = Math.min(5, this.durability);
	}

}
