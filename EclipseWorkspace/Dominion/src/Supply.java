import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Supply {
	Stack copperSupply;
	Stack silverSupply;
	Stack goldSupply;
	Stack estateSupply;
	
	public Supply(){
		setUpBaseCards();
	}
	
	private void setUpBaseCards(){
		this.copperSupply = new Stack<Card>();
		this.silverSupply = new Stack<Card>();
		this.goldSupply = new Stack<Card>();
		this.estateSupply = new Stack<Card>();
		
		for(int i = 0; i < 60; i++){
			this.copperSupply.push(new Copper());
		}
		for(int i = 0; i < 40; i++){
			this.silverSupply.push(new Silver());
		}
		for(int i = 0; i < 30; i++){
			this.goldSupply.push(new Gold());
		}
		for(int i = 0; i < 24; i++){
			this.estateSupply.push(new Estate());
		}
	}
	

	public List getKingdomCardList() {
		List kingdomCardList = new ArrayList<String>();
		
		for(int i = 0; i < 10; i++){
			kingdomCardList.add(""+ i);
		}
		
		return kingdomCardList;
	}

	public Stack<Card> getCopperSupply() {
		return this.copperSupply;
	}

	public Stack<Card> getSilverSupply() {
		return this.silverSupply;
	}

	public Stack<Card> getGoldSupply() {
		return this.goldSupply;
	}

	public Stack<Card> getEstateSupply() {
		return this.estateSupply;
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
