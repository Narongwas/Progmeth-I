package game.piece;

import game.board.Board;
import game.position.Position;

public class Bishop extends Piece{
	public Bishop(boolean isWhite, Position pos, Board board){
		super(isWhite, pos, board);
	}
	
	@Override
	public Object deepCopy() {
		Bishop bishop = new Bishop(isWhite(), getPosition(), getBoard());
		if(isMoved()) {
			bishop.setMoved(isMoved());
		}
		return bishop;
	}
	
}
