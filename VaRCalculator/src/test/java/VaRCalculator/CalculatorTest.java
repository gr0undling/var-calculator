package VaRCalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
	
	Calculator calculator = new Calculator();
	
    @Mock
    Asset asset;

    @Mock
    Trade trade, trade1, trade2;

    @Mock
    Portfolio portfolio;

    @Test
    public void testTradeVar_CalculatesVaRForTradeCorrectly() {
    	
        double[] historicalPnL = {-0.1, 0.05, 0.08, -0.03, 0.02};
        
        when(asset.getName()).thenReturn("Asset 1");
        when(asset.getHistoricalPnL()).thenReturn(historicalPnL);
        
        when(trade.getAsset()).thenReturn(asset);
        when(trade.getInvestment()).thenReturn(100000.0);
        
        double tradeVar = calculator.tradeVar(trade, 95.0);
        
        assertEquals(-3000.0, tradeVar);
    }

    @Test
    public void testPortfolioVar_CalculatesVaRForPortfolioCorrectly() {
    	
        double[] historicalPnL = {-0.1, 0.05, 0.08, -0.03, 0.02};
        
        when(asset.getName()).thenReturn("Asset 1");
        when(asset.getHistoricalPnL()).thenReturn(historicalPnL);
        
        when(trade1.getAsset()).thenReturn(asset);
        when(trade1.getInvestment()).thenReturn(50000.0);
        
        when(trade2.getAsset()).thenReturn(asset);
        when(trade2.getInvestment()).thenReturn(100000.0);
        
        List<Trade> portfolioTrades = Arrays.asList(trade1, trade2);
        double confLevel = 95.0;

        when(portfolio.getName()).thenReturn("My Portfolio");
        when(portfolio.getTrades()).thenReturn(portfolioTrades);

        double portfolioVar = calculator.portfolioVar(portfolio, confLevel);

        assertEquals(-4500, portfolioVar);
    }

}

