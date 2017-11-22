import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LilysHomeworkTests {

    @Test
    public void test1(){
        int [] arr = {2,5,3,1};
        int expected = 2;
        int result = LilysHomework.CountSwaps(arr);
        assertEquals(expected, result);
    }

    @Test
    public void testAlreadySorted(){
        int [] arr = {4,3,2,1};
        int expected = 0;
        int result = LilysHomework.CountSwaps(arr);
        assertEquals(expected, result);
    }
}
