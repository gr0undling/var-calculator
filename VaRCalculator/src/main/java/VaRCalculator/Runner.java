package VaRCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		
				// Initial set-up
		
				// Instantiating a calculator
		
				Calculator calculator = new Calculator();
		
				/* Arrays containing 1 month (30 days) of 
				   daily historical Profit & Loss values for assets 1 to 3
				   Range of values: 10% loss (-0.10) to 10% profit (0.10) */
				
				double[] asset1HistPnL = {0.091, -0.077, -0.019, -0.032, 0.092, 0.037, -0.074, 0.079, 0.093, 0.084, 
										  -0.045, 0.078, 0.063, -0.084, 0.097, 0.053, -0.006, -0.001, -0.098, -0.067, 
										  -0.046, 0.061, -0.008, -0.068, 0.077, -0.07, -0.018, -0.053, -0.056, 0.042};

				double[] asset2HistPnL = {0.021, 0.096, -0.057, 0.055, -0.099, -0.095, 0.001, -0.01, -0.079, -0.096, 
										  0.024, -0.06, 0.004, -0.032, -0.045, 0.01, -0.034, 0.074, 0.001, -0.061, 
										  0.001, 0.095, 0.084, 0.077, -0.092, 0.024, -0.037, 0.057, -0.067, -0.096};

				
				// Initialisation of assets 1 to 5
				
				Asset asset1 = new Asset("Asset 1", asset1HistPnL);
				Asset asset2 = new Asset("Asset 2", asset2HistPnL);
				
				// Initialisation of trades 1 to 6
				
				Trade trade1 = new Trade(asset1, 523000.00);
				Trade trade2 = new Trade(asset2, 345000.00);
				Trade trade3 = new Trade(asset1, 1233000.00);
				Trade trade4 = new Trade(asset2, 675000.00);
				
				// Lists containing trades for portfolios 1 and 2
				
				List<Trade> tradesPort1 = Arrays.asList(trade1, trade2);
				List<Trade> tradesPort2 = Arrays.asList(trade3, trade4);
				
				// Initialisation of portfolios 1 and 2
				
				Portfolio portfolio1 = new Portfolio("Portfolio 1", tradesPort1);
				Portfolio portfolio2 = new Portfolio("Portfolio 2", tradesPort2);
				
		        // Initialising scanner
		        
		    	Scanner scanner = new Scanner(System.in);
		    	
		    	
		    	
		    	// Menu
		    	
		    	
		    	// Controlling the main menu loop
		    	
		        boolean cont = true;
		        
		        // Displaying header
		        
		    	calculator.displayHeader();
				
		    	// Main menu loop
		        
		        while (cont) {
		        		
		        		// Displaying menu
		        	
		        		calculator.displayMainMenu();
				    	
				    	// Getting user input for menu selection
				    	
				    	List<Integer> menuOptions = Arrays.asList(0, 1, 2);
				    	List<Integer> submenuOptions = Arrays.asList(0, 1, 2); 
				    	int option = scanner.nextInt();
				    	
				    	// Controlling using input for menu selection
				    	
				    	while (!menuOptions.contains(option)) {
				    		System.out.println("  Please enter a valid option:");
				    		option = scanner.nextInt();
				    	}
				    	
				    	// Main menu switch
				    	
				    	switch (option) {
				    	
					    	// Exit selected
					    	
					    	case 0:
					    	
					    		System.out.println("  Goodbye! Thank you for using VaR CALCULATOR v1.!");
					    		cont = false;
					    		break;
					    		
					    	// Trade selected
					    		
					    	case 1:
			
					    		System.out.println("  You have selected TRADE");
					    		calculator.displayTradeMenu();
					    		
					    		// Controlling user input for secondary menu
					    		
					    		int optionAsset = scanner.nextInt();
					    		while (!submenuOptions.contains(optionAsset)) {
					    			System.out.println("  Please enter a valid option:");
					    			optionAsset = scanner.nextInt();
					    		}
					    		
					    		// Submenu switch 
					    		
					    		switch (optionAsset) {
					    			
					    			// Back to main menu selected
					    		
						    		case 0:
						    		
						    			System.out.println("  You have selected MAIN MENU");
						    			break;
						    		
						    		// Asset 1 selected
						    			
						    		case 1:
						    			
						    			// Getting user input for investment amount
						    			
						    			System.out.println("  Please enter the desired investment amount in pounds:");
						    			    		            	
						    			double investment1 = scanner.nextDouble();
						    			
						    			// Getting user input for confidence level
						    			
						    			System.out.println("  Please enter the desired confidence level:");
						    			
						    			double confLevel1 = scanner.nextDouble();
						    			
						    			// Initialising new trade
						    			
						    			Trade thisTrade1 = new Trade(asset1, investment1);
						    			
						    			// Calculating VaR for the configured trade
						    			
						    			calculator.tradeVar(thisTrade1, confLevel1);
						    			break;
				
						    		// Asset 2 selected
						    			
						    		case 2:
				
						    			// Getting user input for investment amount
						    			
						    			System.out.println("  Please enter the desired investment amount in pounds:");
						    			    		            	
						    			double investment2 = scanner.nextDouble();
						    			
						    			// Getting user input for confidence level
						    			
						    			System.out.println("  Please enter the desired confidence level:");
						    			
						    			double confLevel2 = scanner.nextDouble();
						    			
						    			// Initialising new trade
						    			
						    			Trade thisTrade2 = new Trade(asset2, investment2);
						    			
						    			// Calculating VaR for the configured trade
						    			
						    			calculator.tradeVar(thisTrade2, confLevel2);
						    			break;
			
					    		}
					    		
					    		break;
				    		
					    	// Portfolio selected
				    		
					    	case 2:

					    		System.out.println("  You have selected PORTFOLIO");
					    		calculator.displayPortfolioMenu();
					    		
					    		// Controlling user input for submenu
					    		
					    		int optionPortfolio = scanner.nextInt();
					    		while (!submenuOptions.contains(optionPortfolio)) {
					    			System.out.println("  Please enter a valid option:");
					    			optionPortfolio = scanner.nextInt();
					    		}
					    		
					    		// Submenu switch
					    		
					    		switch (optionPortfolio) {
					    			
					    			// Back to main menu selected
					    		
						    		case 0:
						    		
						    			System.out.println("  You have selected MAIN MENU");
						    			break;
						    		
						    		// Portfolio 1 selected
						    			
						    		case 1:
						    			
						    			// Getting user input for confidence level
						    			
						    			System.out.println("  Please enter the desired confidence level:");
						    			
						    			double confLevel1 = scanner.nextDouble();
						    			
						    			// Calculating VaR for the configured portfolio
						    			
						    			calculator.portfolioVar(portfolio1, confLevel1);
						    			break;
				
						    		// Portfolio 2 selected
						    			
						    		case 2:
						    			
						    			// Getting user input for confidence level
						    			
						    			System.out.println("  Please enter the desired confidence level:");
						    			
						    			double confLevel2 = scanner.nextDouble();
						    			
						    			// Calculating VaR for the configured portfolio
						    			
						    			calculator.portfolioVar(portfolio2, confLevel2);
						    			break;


					    		}
					    		
					    		break;
				    }
		    	}
		        scanner.close();
				

	}

}
