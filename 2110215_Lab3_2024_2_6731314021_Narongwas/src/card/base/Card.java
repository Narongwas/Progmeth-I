package card.base;

//You CAN modify the first line
public abstract class  Card implements Cloneable {	

	/// You can modify code below ///
	private String name;
	private String flavorText;
	private int bloodCost;
	public Card(String name, String flavorText, int bloodCost) {
		this.name = name;
		this.flavorText = flavorText;
		this.bloodCost = Math.max(0, bloodCost);
	}
		
	public abstract String toString();
	
	public String getName() {
		return name;
	}

	public int getBloodCost() {
		return bloodCost;
	}

	public String getFlavorText() {
		return flavorText;
	}
	
	/// You can modify code above ///
	
	public boolean equals(UnitCard other) {
		return this.getName().equals(other.getName());
	}
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}  

	
}