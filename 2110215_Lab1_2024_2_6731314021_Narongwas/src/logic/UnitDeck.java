package logic;
import java.util.ArrayList;

public class UnitDeck {
	private ArrayList<CardCounter> cardsInDeck;
	private String deckName;
	public UnitDeck(String deckName) {
		setDeckName(deckName);
	}
	public void addCard(UnitCard newCard, int count) {
		if(count > 0) {
			if(cardsInDeck == null) {
				cardsInDeck = new ArrayList<CardCounter>();
			}
			if(existsInDeck(newCard)) {
				for(int j = 0;j < cardsInDeck.size();j++) {
					if(cardsInDeck.get(j).getCard().equals(newCard)) {
						cardsInDeck.get(j).setCount(cardsInDeck.get(j).getCount() + count);
					}
				}
			} else {
				CardCounter cardcounter = new CardCounter(newCard,count);
				cardsInDeck.add(cardcounter);
			}
		}
	}
	public void removeCard(UnitCard toRemove, int count) {
		if((count >= 0) && existsInDeck(toRemove)) {
			for(int j = 0;j < cardsInDeck.size();j++) {
				if(cardsInDeck.get(j).getCard().equals(toRemove)) {
					cardsInDeck.get(j).setCount(cardsInDeck.get(j).getCount() - count);
				}
				if(cardsInDeck.get(j).getCount() <= 0) {
					cardsInDeck.remove(j);
					break;
				}
			}
		}
	}
	public int cardCount() {
		int sum = 0;
		for(int i = 0;i < cardsInDeck.size();i++) {
			sum += cardsInDeck.get(i).getCount();
		}
		return sum;
	}
	public boolean existsInDeck(UnitCard card) {
		if(cardsInDeck != null) {
			for(int i = 0;i < cardsInDeck.size();i++) {
				if(cardsInDeck.get(i).getCard().equals(card) && cardsInDeck.get(i).getCount() >= 1) {
					return true;
				}
			}
		}
		return false;
	}
	
	public ArrayList<CardCounter> getCardsInDeck() {
		return cardsInDeck;
	}
	public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}
	public String getDeckName() {
		return deckName;
	}
	public void setDeckName(String deckName) {
		if(deckName.isBlank()) {
			this.deckName = "Untitled Deck";
		} else {
			this.deckName = deckName;
		}
	}
	public boolean equals(UnitDeck other) {
		return this.deckName.equals(other.getDeckName());
	}
}
