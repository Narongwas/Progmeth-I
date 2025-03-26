package deck;


import java.util.Arrays;

import card.base.Card;


public class Deck {
	// TODO: constructor
	private String name;
	private int deckSize;
	private Card[] deckList;
	public Deck(String name, Card[] deckList) {
		this.name = name;
		this.deckSize = deckList.length;
		this.deckList = new Card[this.deckSize];
		this.deckList = Arrays.copyOf(deckList, deckSize);
	}

	//You CAN modify the first line
		public int insertCard(Card card) throws InsertCardFailedException{
			long count = Arrays.stream(this.deckList).filter(card::equals).count();
			if(count >= 4) {
				throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
			}
			//FILL CODE HERE
			this.deckList = Arrays.copyOf(deckList, deckSize+1);
			this.deckSize++;
			this.deckList[this.deckSize-1] = card;
			//You can use Arrays.copyOf(Original Array, New Length) to create new arrays with bigger size
			//Must return new deckSize
			return deckSize;
		}

		//You CAN modify the first line
		public Card removeCard(int slotNumber) throws RemoveCardFailedException {
			if (this.deckList.length <= slotNumber) {
				throw new RemoveCardFailedException("Number you insert exceed deck size");
			}		
			if (this.deckList[slotNumber] == null) {
				throw new RemoveCardFailedException("There is no card in that slot");
			}
			//FILL CODE HERE
			
			Card[] new_card = new Card[deckSize-1];
			deckSize--;
			for(int i = 0;i < deckList.length;i++) {
				if(i < slotNumber) {
					new_card[i] = deckList[i];
				} else if (i > slotNumber) {
					new_card[i-1] = deckList[i];
				}
			}
			Card card = (Card)deckList[slotNumber];
			deckList = Arrays.copyOf(new_card,deckSize);
			return card;
			//You can use Arrays.copyOf(Original Array, New Length) to create new arrays with bigger size (Added slot is empty)
			//Once card is removed, other card down the list must rearrange to the empty slot
			//Must return card that was removed
		}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("{").append(this.getName()).append("}")
				.append("(").append(this.getDeckSize()).append(" deck size)")
				.toString();
	}
	/* GETTERS & SETTERS */

	public String getName() {
		return name;
	}

	public int getDeckSize() {
		return deckSize;
	}

	public Card[] getDeckList() {
		return deckList;
	}

	public void setDecksize(int decksize) {
		this.deckSize = decksize;
	}
	
	
}
