import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Supply {

	public List getKingdomCardList() {
		List kingdomCardList = new ArrayList<String>();
		
		for(int i = 0; i < 10; i++){
			kingdomCardList.add(""+ i);
		}
		
		return kingdomCardList;
	}

	public Stack<Card> getCopperSupply() {
		Stack copperSupply = new Stack<Card>();
		
		for(int i = 0; i < 60; i++){
			copperSupply.push(new Copper());
		}
		
		return copperSupply;
	}

	public Stack getSilverSupply() {
		Stack silverSupply = new Stack<String>();
		
		for(int i = 0; i < 40; i++){
			silverSupply.push(""+i);
		}
		
		return silverSupply;
	}

	public Stack getGoldSupply() {
		Stack goldSupply = new Stack<String>();
		
		for(int i = 0; i < 30; i++){
			goldSupply.push(""+i);
		}
		
		return goldSupply;
	}

	public Stack getEstateSupply() {
		Stack estateSupply = new Stack<String>();
		
		for(int i = 0; i < 24; i++){
			estateSupply.push(""+i);
		}
		
		return estateSupply;
	}

	public Stack getDuchieSupply() {
		Stack duchieSupply = new Stack<String>();
		
		for(int i = 0; i < 12; i++){
			duchieSupply.push(""+i);
		}
		
		return duchieSupply;
	}

	public Stack getProvinceSupply() {
		Stack provinceSupply = new Stack<String>();
		
		for(int i = 0; i < 12; i++){
			provinceSupply.push(""+i);
		}
		
		return provinceSupply;
	}

}
