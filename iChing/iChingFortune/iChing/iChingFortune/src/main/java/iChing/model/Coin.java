package iChing.model;

public class Coin {

	private boolean isHeads;
	
	public boolean isHeads() {
		return isHeads;
	}
	
	//flips a coin and outputs heads or tails
	
	public boolean flip() {
		isHeads = false;
		for (int i = 0 ; i < 2; i++) {
			int randomToss = (int) (Math.random() * 2);
			if (randomToss == 0) {
				isHeads = true;
			} else if (randomToss == 1) {
				isHeads = false;
			}
		}
		return isHeads;
	}
	
	public String toString() {
		if (isHeads) {
			return "Heads";
		} else {
			return "Tails";
		}
	}
}
