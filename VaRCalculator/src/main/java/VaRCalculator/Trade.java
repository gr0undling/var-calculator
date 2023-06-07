package VaRCalculator;

public class Trade {
	
	// Asset traded
	private Asset asset;
	
	// Amount of investment on asset
	private double investment;
	

	// All args constructor
	public Trade(Asset asset, double investment) {
		this.asset = asset;
		this.investment = investment;
	}

	// Getters & Setters

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public double getInvestment() {
		return investment;
	}

	public void setInvestment(double investment) {
		this.investment = investment;
	}
	
	
	
	
	
}
