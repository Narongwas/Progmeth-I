package logic.unit;

public class FlyingUnit extends BaseUnit {
	public FlyingUnit(int startColumn,int startRow, boolean isWhite, String name) {
		super(startColumn,startRow,isWhite,name);
		this.setHp(2);
		this.setFlying(true);
	}
	@Override
	public boolean move(int direction) {
		if((direction > 3) || (direction < 0)) {
			return false;
		} 
		if(direction == 0) {
			if(this.getRow() > 2) {
				return false;
			}
			this.setRow(this.getRow() + 2);
		} else if (direction == 1) {
			if( this.getColumn() > 2) {
				return false;
			}
			this.setColumn(this.getColumn() + 2);
		} else if (direction == 2) {
			if(this.getRow() < 2) {
				return false;
			}
			this.setRow(this.getRow() - 2);
		} else {
			if(this.getColumn() < 2) {
				return false;
			}
			this.setColumn(this.getColumn() - 2);
		}
		return true;
	}
	
}
