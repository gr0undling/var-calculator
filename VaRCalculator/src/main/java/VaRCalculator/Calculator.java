package VaRCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {

	// No args constructor
	
	public Calculator() {
		
	}
	
	/*
	 * Calculate VaR for a single trade
	 * 
	 * @param trade
	 * 			Trade object containing asset type and investment amount
	 * 
	 * 
	 * @param confLevel
	 * 			Confidence level expressed as a double percentage,
	 *          later converted to a double decimal number
	 *          
	 * @return
	 * 		VaR in £ based on provided investment amount
	 * 		Prints investment amount, confidence level, and VaR in % and £
	 * 			
	 */
	
	public double tradeVar(Trade trade, double confLevel) {
		
		double investment = trade.getInvestment();
		String asset = trade.getAsset().getName();
		double[] historicalPnL = trade.getAsset().getHistoricalPnL();
		Arrays.sort(historicalPnL);
		int index = (int) Math.ceil((1 - (confLevel / 100)) * historicalPnL.length);
		double assetVar = historicalPnL[index] * 100;
		double investmentVar = investment * historicalPnL[index];
		System.out.println(asset);
		System.out.println("Investment: £" + investment);
		System.out.println("Confidence Level: " + confLevel + "%");
		System.out.println("VaR: " + assetVar + "% (£" + investmentVar + ")");
		return investmentVar;
	}
	
	
	/*
	 * Calculate VaR for portfolio
	 * 
	 * @param portfolio
	 * 			Portfolio object containing a list of trades
	 * 
	 * 
	 * @param confLevel
	 * 			Confidence level expressed as a double percentage,
	 *          later converted to a double decimal number
	 *          
	 * @return
	 * 		Cumulative VaR in £ based on provided investment amount for the whole portfolio
	 * 		Prints total investment amount for portfolio and combined VaR in % and £
	 * 			
	 */
	public double portfolioVar(Portfolio portfolio, double confLevel) {
		
		System.out.println(portfolio.getName() + "\n");
		List<Trade> portfolioTrades = portfolio.getTrades();
		double[] portFolioInvestments = new double[portfolioTrades.size()];
		double[] portfolioInvestmentsVar = new double[portfolioTrades.size()];
		for (int i = 0; i < portfolioTrades.size(); i++) {
			portFolioInvestments[i] = portfolioTrades.get(i).getInvestment();
			portfolioInvestmentsVar[i] = tradeVar(portfolioTrades.get(i), confLevel);
			System.out.println("\n");
		}
		
		double portfolioTotalInvestment = Arrays.stream(portFolioInvestments).sum();
		double portfolioTotalInvestmentVar = Arrays.stream(portfolioInvestmentsVar).sum();
		double portFolioAssetsCombinedVar = (portfolioTotalInvestmentVar * 100) / portfolioTotalInvestment;
		
		System.out.println("Total Investment: £" + portfolioTotalInvestment);
		System.out.println("Portfolio VaR: " + portFolioAssetsCombinedVar + "% (£" + portfolioTotalInvestmentVar + ")");
		
		return portfolioTotalInvestmentVar;
	}
	
	
	// Displays header
	
    public void displayHeader() {
		System.out.println("  ==================================================");   	
		System.out.println(" |                                                  |");
		System.out.println(" |                  VaR CALCULATOR v1.              |");
		System.out.println(" |                                                  |");
		System.out.println("  ==================================================");
		System.out.println("");
    }
    
    // Displays main menu
    
    public void displayMainMenu() {
		System.out.println("  ==================================================");  	
		System.out.println(" |                                                  |");
		System.out.println(" |                       MENU                       |");
		System.out.println(" |                                                  |");
		System.out.println(" |              ----------------------              |");
		System.out.println(" |             |                      |             |");
		System.out.println(" |             |    1 - Trade         |             |");
		System.out.println(" |             |    2 - Portfolio     |             |");
		System.out.println(" |             |                      |             |");
		System.out.println(" |              ----------------------              |");
		System.out.println(" |                                                  |");
		System.out.println(" |             Please, select an option             |");
		System.out.println(" |                                                  |");
		System.out.println(" |                        OR                        |");
		System.out.println(" |                                                  |");
		System.out.println(" |                  Enter 0 to Exit                 |");
		System.out.println("  ==================================================");
		System.out.println("");
    }
    
    // Displays submenu for trades
    
    public void displayTradeMenu() {
		System.out.println("  ==================================================");  	
		System.out.println(" |                                                  |");
		System.out.println(" |                      TRADES                      |");
		System.out.println(" |              ----------------------              |");
		System.out.println(" |             |                      |             |");
		System.out.println(" |             |     1 - Asset 1      |             |");
		System.out.println(" |             |     2 - Asset 2      |             |");
		System.out.println(" |             |                      |             |");
		System.out.println(" |              ----------------------              |");
		System.out.println(" |                                                  |");
		System.out.println(" |              Please, select an asset             |");
		System.out.println(" |                                                  |");
		System.out.println(" |                        OR                        |");
		System.out.println(" |                                                  |");
		System.out.println(" |             Enter 0 to go back to Menu           |");
		System.out.println("  ==================================================");
		System.out.println("");
    }
    
    // Displays submenu for portfolios
    
    public void displayPortfolioMenu() {
		System.out.println("  ==================================================");  	
		System.out.println(" |                                                  |");
		System.out.println(" |                    PORTFOLIOS                    |");
		System.out.println(" |              ----------------------              |");
		System.out.println(" |             |                      |             |");
		System.out.println(" |             |   1 - Portfolio 1    |             |");
		System.out.println(" |             |   2 - Portfolio 2    |             |");
		System.out.println(" |             |                      |             |");
		System.out.println(" |              ----------------------              |");
		System.out.println(" |                                                  |");
		System.out.println(" |            Please, select a portfolio            |");
		System.out.println(" |                                                  |");
		System.out.println(" |                        OR                        |");
		System.out.println(" |                                                  |");
		System.out.println(" |             Enter 0 to go back to Menu           |");
		System.out.println("  ==================================================");
		System.out.println("");
    }
	
}
