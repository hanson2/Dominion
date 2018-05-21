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
import cards.Moneylender;
import cards.Province;
import cards.Silver;
import cards.Smithy;

public class Supply {
	Stack<Card> copperSupply;
	Stack<Card> silverSupply;
	Stack<Card> goldSupply;
	Stack<Card> estateSupply;
	Stack<Card> duchySupply;
	Stack<Card> provinceSupply;
	Stack<Card> curseSupply;
	List<Stack<Card>> kingdomCardList;

	Map<String, Stack<Card>> supplyPiles;

	public Supply() {
		this.supplyPiles = new HashMap<String, Stack<Card>>();
		this.kingdomCardList = new ArrayList<Stack<Card>>();

		this.setUpCopper();
		this.setUpSilver();
		this.setUpGold();
		this.setUpEstate();
		this.setUpDuchy();
		this.setUpProvince();
		this.setUpCurse();

		for (int i = 0; i < 10; i++) {
			this.kingdomCardList.add(new Stack<Card>());
			for (int j = 0; j < 10; j++) {
				//TODO replace with real kingdom Cards
				this.kingdomCardList.get(i).push(new Moneylender());
			}
		}
	}

	private void setUpCopper() {
		this.supplyPiles.put("COPPER", new Stack<Card>());
		this.copperSupply = this.supplyPiles.get("COPPER");
		for (int i = 0; i < 60; i++) {
			this.copperSupply.push(new Copper());
		}
	}

	private void setUpSilver() {
		this.supplyPiles.put("SILVER", new Stack<Card>());
		this.silverSupply = this.supplyPiles.get("SILVER");
		for (int i = 0; i < 40; i++) {
			this.silverSupply.push(new Silver());
		}
	}

	private void setUpGold() {
		this.supplyPiles.put("GOLD", new Stack<Card>());
		this.goldSupply = this.supplyPiles.get("GOLD");
		for (int i = 0; i < 30; i++) {
			this.goldSupply.push(new Gold());
		}
	}

	private void setUpEstate() {
		this.supplyPiles.put("ESTATE", new Stack<Card>());
		this.estateSupply = this.supplyPiles.get("ESTATE");
		for (int i = 0; i < 24; i++) {
			this.estateSupply.push(new Estate());
		}
	}

	private void setUpDuchy() {
		this.supplyPiles.put("DUCHY", new Stack<Card>());
		this.duchySupply = this.supplyPiles.get("DUCHY");
		for (int i = 0; i < 12; i++) {
			this.duchySupply.push(new Duchy());
		}
	}

	private void setUpProvince() {
		this.supplyPiles.put("PROVINCE", new Stack<Card>());
		this.provinceSupply = this.supplyPiles.get("PROVINCE");
		for (int i = 0; i < 12; i++) {
			this.provinceSupply.push(new Province());
		}
	}

	private void setUpCurse() {
		this.supplyPiles.put("CURSE", new Stack<Card>());
		this.curseSupply = this.supplyPiles.get("CURSE");
		for (int i = 0; i < 30; i++) {
			this.curseSupply.push(new Curse());
		}
	}

	public List<Stack<Card>> getKingdomCardList() {
		return this.kingdomCardList;
	}

	public Stack<Card> getBaseSupply(String cardName) {
		return this.supplyPiles.get(cardName);
	}

	public boolean isGameOver() {
		if (this.supplyPiles.get("PROVINCE").isEmpty()) {
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
		for (String cardName : this.supplyPiles.keySet()) {
			if (this.supplyPiles.get(cardName).isEmpty()) {
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
		for (String cardName : this.supplyPiles.keySet()) {
			if (!this.supplyPiles.get(cardName).isEmpty()) {
				availableCards.add(this.supplyPiles.get(cardName).peek());
			}
		}
		return availableCards;
	}

}
