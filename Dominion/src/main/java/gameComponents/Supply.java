package gameComponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import cards.Card;
import cards.Copper;
import cards.Curse;
import cards.Duchy;
import cards.Estate;
import cards.Gold;
import cards.Province;
import cards.Silver;
import util.CardFactory;
import util.Cards;

public class Supply {
	Stack<Card> copperSupply;
	Stack<Card> silverSupply;
	Stack<Card> goldSupply;
	Stack<Card> estateSupply;
	Stack<Card> duchySupply;
	Stack<Card> provinceSupply;
	Stack<Card> curseSupply;
	List<Stack<Card>> kingdomCardList;

	Map<Cards, Stack<Card>> baseSupplyPiles;

	public Supply(int numPlayers) {
		this.baseSupplyPiles = new HashMap<Cards, Stack<Card>>();

		this.setUpCopper(numPlayers);
		this.setUpSilver();
		this.setUpGold();
		this.setUpEstate(numPlayers);
		this.setUpDuchy();
		this.setUpProvince();
		this.setUpCurse();
	}

	public void makeKingdomCardList(List<Card> availableKingdomCards, Random random) {
		ArrayList<Stack<Card>> cardList = new ArrayList<Stack<Card>>();
		Set<Card> chosenKingdomCards = this.chooseKingdomCards(availableKingdomCards, random);
		for (Card card : chosenKingdomCards) {
			Stack<Card> cardStack = new Stack<Card>();
			for (int j = 0; j < 10; j++) {
				cardStack.push(CardFactory.makeCard(card.getClass()));
			}
			cardList.add(cardStack);
		}
		this.kingdomCardList = cardList;

	}

	private Set<Card> chooseKingdomCards(List<Card> availableKingdomCards, Random random) {
		Set<Card> chosenKingdomCards = new HashSet<Card>();

		while (chosenKingdomCards.size() < 10) {
			int randomIndex = random.nextInt(availableKingdomCards.size());
			chosenKingdomCards.add(availableKingdomCards.get(randomIndex));
		}

		return chosenKingdomCards;
	}

	private void setUpCopper(int numPlayers) {
		this.baseSupplyPiles.put(Cards.COPPER, new Stack<Card>());
		this.copperSupply = this.baseSupplyPiles.get(Cards.COPPER);
		for (int i = 0; i < 60 - (7 * numPlayers); i++) {
			this.copperSupply.push(CardFactory.makeCard(Copper.class));
		}
	}

	private void setUpSilver() {
		this.baseSupplyPiles.put(Cards.SILVER, new Stack<Card>());
		this.silverSupply = this.baseSupplyPiles.get(Cards.SILVER);
		for (int i = 0; i < 40; i++) {
			this.silverSupply.push(CardFactory.makeCard(Silver.class));
		}
	}

	private void setUpGold() {
		this.baseSupplyPiles.put(Cards.GOLD, new Stack<Card>());
		this.goldSupply = this.baseSupplyPiles.get(Cards.GOLD);
		for (int i = 0; i < 30; i++) {
			this.goldSupply.push(CardFactory.makeCard(Gold.class));
		}
	}

	private void setUpEstate(int numPlayers) {
		this.baseSupplyPiles.put(Cards.ESTATE, new Stack<Card>());
		this.estateSupply = this.baseSupplyPiles.get(Cards.ESTATE);
		for (int i = 0; i < 24 - (3 * numPlayers); i++) {
			this.estateSupply.push(CardFactory.makeCard(Estate.class));
		}
	}

	private void setUpDuchy() {
		this.baseSupplyPiles.put(Cards.DUCHY, new Stack<Card>());
		this.duchySupply = this.baseSupplyPiles.get(Cards.DUCHY);
		for (int i = 0; i < 12; i++) {
			this.duchySupply.push(CardFactory.makeCard(Duchy.class));
		}
	}

	private void setUpProvince() {
		this.baseSupplyPiles.put(Cards.PROVINCE, new Stack<Card>());
		this.provinceSupply = this.baseSupplyPiles.get(Cards.PROVINCE);
		for (int i = 0; i < 12; i++) {
			this.provinceSupply.push(CardFactory.makeCard(Province.class));
		}
	}

	private void setUpCurse() {
		this.baseSupplyPiles.put(Cards.CURSE, new Stack<Card>());
		this.curseSupply = this.baseSupplyPiles.get(Cards.CURSE);
		for (int i = 0; i < 30; i++) {
			this.curseSupply.push(CardFactory.makeCard(Curse.class));
		}
	}

	List<Stack<Card>> getKingdomCardList() {
		return this.kingdomCardList;
	}

	public Stack<Card> getBaseSupply(Cards cardName) {
		return this.baseSupplyPiles.get(cardName);
	}

	public boolean isGameOver() {
		if (this.baseSupplyPiles.get(Cards.PROVINCE).isEmpty()) {
			return true;
		}
		if (this.isThreePilesGone()) {
			return true;
		}
		return false;
	}

	private boolean isThreePilesGone() {
		int numPilesGone = 0;

		for (int i = 0; i < 10; i++) {
			if (this.getKingdomCardList().get(i).isEmpty()) {
				numPilesGone++;
			}
		}
		for (Cards cardName : this.baseSupplyPiles.keySet()) {
			if (this.baseSupplyPiles.get(cardName).isEmpty()) {
				numPilesGone++;
			}
		}

		return numPilesGone >= 3;
	}

	public Set<Card> getAvailableCards() {
		Set<Card> availableCards = new HashSet<Card>();
		for (Stack<Card> kingdomPile : this.kingdomCardList) {
			if (!kingdomPile.isEmpty()) {
				availableCards.add(kingdomPile.peek());
			}
		}
		for (Cards cardName : this.baseSupplyPiles.keySet()) {
			if (!this.baseSupplyPiles.get(cardName).isEmpty()) {
				availableCards.add(this.baseSupplyPiles.get(cardName).peek());
			}
		}
		return availableCards;
	}

	public void decrementPile(Card card) {
		for (Cards cardName : this.baseSupplyPiles.keySet()) {
			Card baseCard = this.baseSupplyPiles.get(cardName).peek();
			if (baseCard.getClass().equals(card.getClass())) {
				this.baseSupplyPiles.get(cardName).pop();
				return;
			}
		}
		for (Stack<Card> kingdomPile : this.kingdomCardList) {
			Card kingdomCard = kingdomPile.peek();
			if (kingdomCard.getClass().equals(card.getClass())) {
				kingdomPile.pop();
				return;
			}
		}
	}
}
