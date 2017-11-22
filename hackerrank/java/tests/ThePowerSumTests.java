import org.junit.Test;
import org.junit.experimental.theories.Theory;

import static org.junit.Assert.*;

/**
 * Created by sergio on 03/10/17.
 */
public class ThePowerSumTests {

    @Test
    public void generalTest1(){
        int n = 2;
        int x = 10;

        int expected = 1;
        int result = ThePowerSum.thePowerSum(x, n);

        assertEquals(expected, result);
    }

    @Test
    public void generalTest2(){
        int n = 2;
        int x = 100;

        int expected = 3;
        int result = ThePowerSum.thePowerSum(x, n);

        assertEquals(expected, result);
    }

    @Test
    public void generalTest3(){
        int n = 3;
        int x = 100;

        int expected = 1;
        int result = ThePowerSum.thePowerSum(x, n);

        assertEquals(expected, result);
    }

    @Test
    public void generalTest4(){
        int n = 3;
        int x = 10;

        int expected = 0;
        int result = ThePowerSum.thePowerSum(x, n);

        assertEquals(expected, result);
    }

}