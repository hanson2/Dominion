package util;

import cards.Artisan;
import cards.Card;
import cards.Cellar;
import cards.Chancellor;
import cards.Chapel;
import cards.Copper;
import cards.CouncilRoom;
import cards.Curse;
import cards.Duchy;
import cards.Estate;
import cards.Feast;
import cards.Festival;
import cards.Gardens;
import cards.Gold;
import cards.Laboratory;
import cards.Market;
import cards.Militia;
import cards.Moat;
import cards.Moneylender;
import cards.Province;
import cards.Remodel;
import cards.Silver;
import cards.Smithy;
import cards.ThroneRoom;
import cards.Vassal;
import cards.Village;
import cards.Woodcutter;
import cards.Workshop;

public class CardFactory {

	public static Card makeCard(Class<? extends Card> cardClass) {

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
		} else if (cardClass.equals(Remodel.class)) {
			return new Remodel();
		} else if (cardClass.equals(Artisan.class)) {
			return new Artisan();
		} else if (cardClass.equals(Feast.class)) {
			return new Feast();
		} else if (cardClass.equals(CouncilRoom.class)) {
			return new CouncilRoom();
		} else if (cardClass.equals(Gardens.class)) {
			return new Gardens();
		} else if (cardClass.equals(Workshop.class)) {
			return new Workshop();
		} else if (cardClass.equals(Militia.class)) {
			return new Militia();
		} else {
			return new Copper();
		}
	}

}
