package logic.unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit{
	public RangeUnit(int startColumn,int startRow, boolean isWhite, String name) {
		super(startColumn,startRow,isWhite,name);
		this.setHp(2);
	}
	@Override
	public void attack(ArrayList<BaseUnit> targetPieces) {
		if(isWhite()) {
			for(BaseUnit baseunit:targetPieces) {
				if(baseunit.getRow() > this.getRow() && baseunit.getColumn() == this.getColumn()) {
					System.out.println(this.getName() + " attacks " + baseunit.getName());
					baseunit.setHp(baseunit.getHp() - this.power);
				}
			}
		} else {
			for(BaseUnit baseunit:targetPieces) {
				if(baseunit.getRow() < this.getRow() && baseunit.getColumn() == this.getColumn()) {
					System.out.println(this.getName() + " attacks " + baseunit.getName());
					baseunit.setHp(baseunit.getHp() - this.power);
				}
		}
	}
	}
}
