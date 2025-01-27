package logic;

public class CardCounter {
	
	private UnitCard card;
	private int count;
	//
	public CardCounter(UnitCard card, int count) {
		setCard(card);
		setCount(count);
	}
	public void setCount(int count) {
		this.count = (count >= 0)? count:0;
	}
	
	public UnitCard getCard() {
		return card;
	}

	public int getCount() {
		return count;
	}

	public void setCard(UnitCard card) {
		this.card = card;
	}

	//
	public String toString() {
		return  this.getCard() + " x " + this.getCount();
	}


}
