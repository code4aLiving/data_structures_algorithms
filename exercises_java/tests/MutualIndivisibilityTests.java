import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MutualIndivisibilityTests {

    @Test
    public void test1(){
        int a = 1;
        int b = 3;
        int x = 2;

        int[] res = MutualIndivisibility.mutualIndivisibility(a,b,x);
        int[] expected = {2,3};
        for (int i = 0; i < x; i++) {
            assertEquals(expected[i], res[i]);
        }
    }
}
