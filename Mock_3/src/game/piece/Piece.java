package game.piece;

import java.util.Set;

import game.board.Board;
import game.position.Position;
import game.util.Movement;

public abstract class Piece {
	protected  boolean white;
	protected  boolean moved;
	protected  Position position;
	protected  Board board;
	
	public Piece(boolean white, Position position, Board board) {
		setBoard(board);
		setPosition(position);
		setWhite(white);
		board.placePiece(this, position);
	}
	
	public Set<Position> getLegalMove(){
		Movement movement = new Movement(getPosition(), getBoard());
		movement.getMovePositions(this);
		return movement.getMoves();
	}
	
	public abstract Object deepCopy();
	
	public String toString() {
		return getClass().getSimpleName() + "(" + position + ")";
	}
	
	public void moveHandle(Position to) {
		hadMoved();
		setPosition(to);
	}
	
	public boolean hadMoved() {
		setMoved(true);
		return moved;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Bishop) {
			Bishop b = (Bishop)o;
			return (isWhite() == b.isWhite()) && (isMoved() == b.isMoved()) && (position.equals(b.position)) && (board.equals(b.board)) && (this instanceof Bishop);
		} else {
			Knight k = (Knight)o;
			return (isWhite() == k.isWhite()) && (isMoved() == k.isMoved()) && (position.equals(k.position)) && (board.equals(k.board)) && (this instanceof Knight);
		}
	}

	public boolean isWhite() {
		return white;
	}

	public boolean isMoved() {
		return moved;
	}

	public Position getPosition() {
		return position;
	}

	public Board getBoard() {
		return board;
	}

	public void setWhite(boolean white) {
		this.white = white;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
}
