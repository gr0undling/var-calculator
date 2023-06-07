package VaRCalculator;

import java.util.List;

public class Portfolio {
	
	// Portfolio name
	private String name;
	
	// List containing portfolio's trades
	private List<Trade> trades;
	
	// All args constructor
	public Portfolio(String name, List<Trade> trades) {
		this.name = name;
		this.trades = trades;
	}

	// Getters & Setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}
	
	
	
	

}
