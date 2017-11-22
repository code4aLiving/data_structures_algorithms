import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringReductionTests {

    @Test
    public void test1(){
        String input = "cab";
        int res = StringReduction.stringReductionBruteForce(input);
        assertEquals(2, res);
    }

    @Test
    public void test2(){
        String input = "bcab";
        int res = StringReduction.stringReductionBruteForce(input);
        assertEquals(1, res);
    }

    @Test
    public void test3(){
        String input = "ccccc";
        int res = StringReduction.stringReductionBruteForce(input);
        assertEquals(5, res);
    }

    @Test
    public void test4(){
        String input = "cab";
        int res = StringReduction.stringReductionDP(input);
        assertEquals(2, res);
    }

    @Test
    public void test5(){
        String input = "bcab";
        int res = StringReduction.stringReductionDP(input);
        assertEquals(1, res);
    }

    @Test
    public void test6(){
        String input = "ccccc";
        int res = StringReduction.stringReductionDP(input);
        assertEquals(5, res);
    }
}
