package VaRCalculator;

public class Asset {

	// Asset name
	private String name;
	
	// Asset's historical Profit & Loss values expressed in percentages
	private double[] historicalPnL;

	// All args constructor
	public Asset(String name, double[] historicalPnL) {
		this.name = name;
		this.historicalPnL = historicalPnL;
	}

	// Getters & Setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double[] getHistoricalPnL() {
		return historicalPnL;
	}

	public void setHistoricalPnL(double[] historicalPnL) {
		this.historicalPnL = historicalPnL;
	}
	
}
