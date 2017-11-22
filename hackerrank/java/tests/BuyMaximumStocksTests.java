import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuyMaximumStocksTests {

    @Test
    public void test1(){
        int [] prices = {10,7,19};
        int res = BuyMaximumStocks.buyMaximumStocksRec(prices, 45);
        assertEquals(4,res);
    }

    @Test
    public void test2(){
        int [] prices = {1, 5, 1};
        int res = BuyMaximumStocks.buyMaximumStocksRec(prices, 11);
        assertEquals(5, res);
    }

    @Test
    public void test3(){
        int [] prices = {1, 5, 1};
        long res = BuyMaximumStocks.buyMaximumStocks(prices, 11);
        assertEquals(5, res);
    }

    @Test
    public void test4(){
        int [] prices = {10,7,19};
        long res = BuyMaximumStocks.buyMaximumStocks(prices, 45);
        assertEquals(4,res);
    }
}
