package model.cards.interfaces;

public class Cost {

	private int cost;

	private boolean potion;

	public Cost(int cost){
		this.cost = cost;
		this. potion = false;
	}

	public Cost(int cost, boolean potion){
		this.cost = cost;
		this.potion = potion;
	}

	public int getCost(){
		return cost;
	}

	public boolean getPotion(){
		return potion;
	}

	public boolean equals(Cost other){
		if(this.cost == other.cost && !this.potion && !other.potion){
			return true;
		}else if(this.cost == other.cost && this.potion && other.potion){
			return true;
		}
		return false;
	}

	public boolean GE(Cost other){
		if(this.equals(other)){
			return true;
		}else if(this.cost >= other.cost && !other.potion){
			return true;
		}else if(this.cost >= other.cost && this.potion){
			return true;
		}
		return false;
	}
	
	public boolean LE(Cost other){
		return other.GE(this);
	}
	
	public boolean LT(Cost other){
		return !this.GE(other);
	}
	
	public boolean GT(Cost other){
		return !this.LE(other);
	}

}
