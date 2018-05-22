package gameComponents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

import cards.Card;
import cards.Copper;
import cards.Estate;

public class Player {

	private String name;
	List<Card> hand;
	Stack<Card> drawPile;
	Stack<Card> discardPile;
	private GUI gui;

	public Player(String name, GUI gui) {
		this.hand = new ArrayList<Card>();
		this.drawPile = new Stack<Card>();
		this.discardPile = new Stack<Card>();
		this.addStarterCards();
		this.name = name;
		this.gui = gui;
	}

	public void drawACard() {
		if (this.drawPile.size() > 0) {
			this.hand.add(this.drawPile.pop());
		} else if (this.discardPile.size() > 0) {
			this.drawPile.addAll(this.discardPile);
			this.discardPile.clear();
			Collections.shuffle(this.drawPile);
			this.drawACard();
		}
	}

	public void drawNewHand() {
		for (int i = 0; i < 5; i++) {
			this.drawACard();
		}
	}

	public void cleanup(List<Card> playArea) {
		this.discardPile.addAll(playArea);
		playArea.clear();
		this.discardHand();
		this.drawNewHand();
	}

	public void discardHand() {
		this.discardPile.addAll(this.hand);
		this.hand.clear();
	}

	public void discardDrawPile() {
		this.discardPile.addAll(this.drawPile);
		this.drawPile.clear();
	}

	public Optional<Card> chooseCardToPlay() {
		return this.gui.chooseCardToPlay(this.hand, name).join();
	}

	public Optional<Card> buy(Supply supplyPiles) {
		return this.gui.chooseCardToBuy(supplyPiles.getAvailableCards(), this.name).join();
	}

	public int getPoints() {
		int totalPoints = this.addPointsFromPile(this.drawPile);
		totalPoints += this.addPointsFromPile(this.hand);
		totalPoints += this.addPointsFromPile(this.discardPile);
		return totalPoints;
	}

	public String getName() {
		return name;
	}

	public int sizeOfDrawPile() {
		return this.drawPile.size();
	}

	public int sizeOfHand() {
		return this.hand.size();
	}

	public int sizeOfDiscardPile() {
		return this.discardPile.size();
	}

	public List<Card> getHand() {
		return this.hand;
	}

	public void gainCard(Card card) {
		this.discardPile.push(card);
	}

	private void addStarterCards() {
		for (int i = 0; i < 7; i++) {
			this.drawPile.push(new Copper());
		}
		for (int i = 0; i < 3; i++) {
			this.drawPile.push(new Estate());
		}
	}

	private int addPointsFromPile(Collection<Card> cards) {
		int totalPoints = 0;
		for (Card card : cards) {
			totalPoints += card.getVictoryValue();
		}
		return totalPoints;
	}

	public boolean promptYesNo(String messageKey) {
		return this.gui.promptYesNo(messageKey, this.name).join();
	}

	public boolean trashCardFromHand(Class<? extends Card> cardClass) {
		for (Card c : this.hand) {
			if (c.getClass() == cardClass) {
				this.hand.remove(c);
				return true;
			}
		}
		return false;
	}

	public Optional<Card> discardTopCardOfDrawPile() {
		if (this.sizeOfDrawPile() == 0 && this.sizeOfDiscardPile() == 0) {
			return Optional.empty();
		} else if (this.sizeOfDrawPile() == 0) {
			this.drawPile.addAll(this.discardPile);
			this.discardPile.clear();
			return this.discardTopCardOfDrawPile();
		} else {
			Card toMove = this.drawPile.pop();
			this.discardPile.push(toMove);
			return Optional.of(toMove);
		}
	}

	public Card chooseCardFromHand(String messageKey) {
		return gui.chooseCardFromHand(this.hand, this.name, messageKey).join();
	}

	public boolean discardCardFromHand(Class<? extends Card> cardClass) {
		for (Card c : this.hand) {
			if (c.getClass() == cardClass) {
				this.hand.remove(c);
				this.discardPile.push(c);
				return true;
			}
		}
		return false;
	}

	public int getHandSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean hasCardInHand(Class<? extends Card> cardClass) {
		for (Card c : this.hand) {
			if (c.getClass() == cardClass) {
				return true;
			}
		}
		return false;
	}
}
