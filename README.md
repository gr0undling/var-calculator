
Application: VaR Calculator

Version: 1.0

Date: 07/06/2023

-------------------------------------------------------------------------------------------------------------------

1 - CLASS DIAGRAM

           -------------------------------           ------------------------------           ------------------------------
          |            Asset              |         |             Trade            |         |           Portfolio          |
           -------------------------------           ------------------------------           ------------------------------
          | - name : String               |         | - asset : Asset              |         | - name : String              |
          | - historicalPnL : double[]    | <------ | - investment : double        | <>----- | - trades : List<Trade>       |
           -------------------------------           ------------------------------           ------------------------------
          | + Getters & Setters           |         | + Getters & Setters          |         | + Getters & Setters          |
          |                               |         |                              |         |                              |
          |                               |         |                              |         |                              |
          |                               |         |                              |         |                              |
           -------------------------------           ------------------------------           ------------------------------

2. SUMMARY

	This simple application is designed to calculate Value at Risk (VaR), using the historical method, 
for a single trade and a whole portfolio, given a series of historical Profit & Loss (P&L) values for the 
traded assets. The investment amount and confidence level can be provided by the user as an input in order 
to customise the output.

3. REQUIREMENTS

	- Building a Java application that calculates VaR
	- Calculations with historical method
	- Trade and portfolio calculations
	- Configurable confidence level
	- Historical data to be provided as input (not retrieved or computed)
	- Following best practices (clean, concise code)
	- Unit testing where appropriate


4. DEFINITIONS AND ASSUMPTIONS

	- Value at Risk is a statistic calculation used to predict the greatest possible loss over a 
	  specific period of time with a certain confidence level

	- The most common time frames when calculating VaR are daily, monthly and annually. For daily 
	  calculations, around 256 data values are normally used, representing the amount of trading days
	  over a year. For the purposes of this program, 30 data values have been provided

	- Confidence level is a percentage that represents the probability of the calculated risk over a 
	  period of time

	- There are several methods to calculate VaR, the most common ones being the historical method, the
	  variance-covariance method, and the Monte Carlo simulation (the historical method has been used 
	  in this program)

	- Historical data for assets has been hardcoded as arrays containing 30 daily P&L values (covering 
	  one month), expressed as positive and negative percentages (as decimal numbers) within the range 
	 -0.1 and 0.1.

	- The calculation for single trade VaR is done by taking the chosen asset's historical P&L data, 
	  sorting it in ascending order to replicate a distribution, and then chosing the value at the 
	  percentile indicated by the chosen confidence level. This value is then applied to the investment 
	  amount to calculate VaR both as a percentage and an amount in £

	- The calculation for portfolio VaR performs the single trade calculation for all trades contained 
	  in the portfolio and then provides the combined VaR as a percentage and an amount in £

	- Two assets, four trades and two portfolios have been hardcoded for demonstration purposes, and are 
	  initialised when the program starts running. When calculating VaR for a single trade, the user can 
	  choose an asset and then provide both an investment amount (in £) and confidence level (as a 
	  percentage), thus creating a new customised trade object


		

5. IMPLEMENTATION

	- The program comprises 3 classes (Asset, Trade and Portfolio) that define the data relevant to 
	  calculations, a Calculator class that contains the calculation logic, and a Runner class that
    	  initialises some hardcoded data before the application runs

	- Asset attributes are name (String) and historical values (array of type double)

	- Trade attributes are a specific asset (Asset object) and an investment amount (double)
		
	- Portfolio attributes are a name (String) and a list of trades (ArrayList of Trade objects)

	- The Calculator class contains the 2 methods that calculate VaR (tradeVar and portfolioVar) and the 
	  methods that display the header and menus for the user interface that runs on the console
    
  	- The Runner contains the initialisation of the harcoded data required to run the program (assets, 
    	  trades and portfolios) and the definition of the menu logic as a while loop containing several switches
    	  to control user input in the main menu and submenus

	- The program is started by running the Runner class

	- When the program starts, the main menu is displayed to the user, who is prompted to enter one of 
	  three options (Trade, Portfolio o Exit)

	- When Trade is chosen, the user is then prompted to choose an asset type and enter both investment 
	  amount and confidence level. They can also choose to return to the main menu.

	- When Trade is calculated, the program displays all the relevant data to the user (asset type, 
	  investment amount, confidence level, and VaR as % and £)

	- When Portfolio is chosen, the user is prompted to choose a portofolio and enter the confidence level, 
	  since the asset types and investment amounts have been harcoded for the portfolio

	- When Trade is calculated, the program displays all the relevant data to the user (portfolio name, 
	  all assets and their investment amounts, confidence level, total portfolio investment and the combined
 	  VaR as % and £ for the portfolio)


6. TESTING

	- Unit testing has been performed to cover the logic of the two main methods in Calculator (tradeVar
	  and portfolioVar)

	- All the testing has been provided in the CalculatorTest class under src/test/java/VaRCalculator

	- JUnit and Mockito have been used for testing (dependencies are provided with the package in the 
	  pom.xml file)


7. NOTES

	- All the code has been commented extensively to provide relevant information about the logic and its 
	  implementation, and comments should be used as a reference for everything not covered by this 
	  README file

	- Retrospectively, we have noticed that the accuracy of VaR calculations depends closely on the amount 
	  of historical data available, the level of exactitude of the formula used to choose the value at the 
	  confidence level percentile and, in general, the handling of the values and the amount of decimal 
	  points that are allowed. The formulas used in this program are for demonstration purposes only and 
	  they can be improved upon by extending their complexity

	- As future improvements, given no time constraints, we would like to expand the functionality of the 
	  program by providing live or stored data (either retrieved from a database or read from a file), 
	  allowing the user to configure all the relevant assets, trades and portfolios to customise the 
	  calculations, and to be able to store those as well. Other calculation methods would be available 
	  (variance-covariance and Monte Carlo simulation) and graphics for normal distribution and data 
	  visualisation in general would be displayed to the user. Testing coverage would also be increased








