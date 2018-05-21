package util;

import cards.*;

public class CardFactory {

	public static Card makeCard(Class<? extends Card> cardClass) {
		//TODO test this
		if (cardClass.equals(Copper.class)) {
			return new Copper();
		} else if (cardClass.equals(Silver.class)) {
			return new Silver();
		} else if (cardClass.equals(Gold.class)) {
			return new Gold();
		} else if (cardClass.equals(Estate.class)) {
			return new Estate();
		} else if (cardClass.equals(Duchy.class)) {
			return new Duchy();
		} else if (cardClass.equals(Province.class)) {
			return new Province();
		} else if (cardClass.equals(Curse.class)) {
			return new Curse();
		} else if (cardClass.equals(Cellar.class)) {
			return new Cellar();
		} else if (cardClass.equals(Chancellor.class)) {
			return new Chancellor();
		} else if (cardClass.equals(Chapel.class)) {
			return new Chapel();
		} else if (cardClass.equals(Festival.class)) {
			return new Festival();
		} else if (cardClass.equals(Laboratory.class)) {
			return new Laboratory();
		} else if (cardClass.equals(Market.class)) {
			return new Market();
		} else if (cardClass.equals(Moat.class)) {
			return new Moat();
		} else if (cardClass.equals(Moneylender.class)) {
			return new Moneylender();
		} else if (cardClass.equals(Smithy.class)) {
			return new Smithy();
		} else if (cardClass.equals(ThroneRoom.class)) {
			return new ThroneRoom();
		} else if (cardClass.equals(Vassal.class)) {
			return new Vassal();
		} else if (cardClass.equals(Village.class)) {
			return new Village();
		} else if (cardClass.equals(Woodcutter.class)) {
			return new Woodcutter();
		} else {
			return new Copper();
		}
	}

}
