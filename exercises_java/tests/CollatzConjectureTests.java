import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sergio on 31/08/17.
 */
public class CollatzConjectureTests {

    @Test
    public void test1_AEqualsB(){
        int a = 3;
        int b = 3;

        int [] res = CollatzConjecture.collatzCollide(a,b);

        assertEquals(0, res[0]);
        assertEquals(0, res[1]);
        assertEquals(a, res[2]);
    }

    @Test
    public void test2(){
        int a = 7;
        int b = 8;

        int [] res = CollatzConjecture.collatzCollide(a, b);
        assertEquals(13, res[0]);
        assertEquals(0, res[1]);
        assertEquals(8, res[2]);
    }
}
