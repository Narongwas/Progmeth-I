package logic.unit;

import java.util.ArrayList;

public class BaseUnit {
	private int row;
	private int column;
	private boolean isWhite;
	private String name;
	protected int hp;
	protected int power;
	protected boolean isFlying;
	public BaseUnit(int startColumn, int startRow, boolean isWhite, String name) {
		this.setColumn(startColumn);
		this.setRow(startRow);
		this.setWhite(isWhite);
		this.setName(name);
		this.setFlying(false);;
		this.setHp(2);;
		this.setPower(1);;
	}
	public boolean move(int direction) {
		if((direction > 3) || (direction < 0)) {
			return false;
		} 
		if(direction == 0) {
			if(row + 1 > 4) {
				return false;
			}
			row++;
		} else if (direction == 1) {
			if(column + 1 > 4) {
				return false;
			}
			column++;
		} else if (direction == 2) {
			if(row - 1 < 0) {
				return false;
			}
			row--;
		} else {
			if(column - 1 < 0) {
				return false;
			}
			column--;
		}
		return true;
	}
	
	public int getRow() {
		return row;
	}
	public int getColumn(){
		return column;
	}
	public boolean isWhite() {
		return isWhite;
	}
	public String getName() {
		return name;
	}
	public void setRow(int row) {
		if(row < 0) {
			row = 0;
		} else if (row > 4) {
			row = 4;
		}
		this.row = row;
	}
	public void setColumn(int column) {
		if(column < 0) {
			column = 0;
		} else if (column > 4) {
			column = 4;
		}
		this.column = column;
	}
	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getPower() {
		return power;
	}
	public boolean isFlying() {
		return isFlying;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public void setFlying(boolean isFlying) {
		this.isFlying = isFlying;
	}
	public void attack(ArrayList<BaseUnit> targetPieces) {
		for(BaseUnit baseunit : targetPieces) {
			if((!baseunit.isFlying) && ((baseunit.getRow() == this.getRow()) && 
					(baseunit.getColumn() == this.getColumn()))) {
				System.out.println(this.getName() + " attacks " + baseunit.getName());
				baseunit.setHp(baseunit.getHp() - this.power);
			}
		}
	}
	
}
