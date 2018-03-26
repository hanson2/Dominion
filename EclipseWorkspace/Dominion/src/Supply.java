import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Supply {
	Stack copperSupply;
	Stack silverSupply;
	Stack goldSupply;
	Stack estateSupply;
	Stack duchySupply;
	Stack provinceSupply;
	Stack curseSupply;
	
	public Supply(){
		setUpBaseCards();
	}
	
	private void setUpBaseCards(){
		this.copperSupply = new Stack<Card>();
		this.silverSupply = new Stack<Card>();
		this.goldSupply = new Stack<Card>();
		this.estateSupply = new Stack<Card>();
		this.duchySupply = new Stack<Card>();
		this.provinceSupply = new Stack<Card>();
		this.curseSupply = new Stack<Card>();
		
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
		for(int i = 0; i < 12; i++){
			this.duchySupply.push(new Duchy());
		}
		for(int i = 0; i < 12; i++){
			this.provinceSupply.push(new Province());
		}
		for(int i = 0; i < 30; i++){
			this.curseSupply.push(new Curse());
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

	public Stack<Card> getDuchySupply() {
		return this.duchySupply;
	}

	public Stack<Card> getProvinceSupply() {
		return this.provinceSupply;
	}

	public Stack<Card> getCurseSupply() {
		return this.curseSupply;
	}

	public boolean isGameOver() {
		if(this.provinceSupply.isEmpty()){
			return true;
		}
		if(this.isThreePilesGone()){
			return true;
		}
		return false;
	}
	
	private boolean isThreePilesGone(){
		int numPilesGone = 0;
		if(this.copperSupply.isEmpty()){
			numPilesGone++;
		}
		if(this.silverSupply.isEmpty()){
			numPilesGone++;
		}
		if(this.goldSupply.isEmpty()){
			numPilesGone++;
		}
		if(this.estateSupply.isEmpty()){
			numPilesGone++;
		}
		if(this.duchySupply.isEmpty()){
			numPilesGone++;
		}
		if(this.curseSupply.isEmpty()){
			numPilesGone++;
		}
		
		if(numPilesGone >= 3){
			return true;
		}
		return false;
	}

}
