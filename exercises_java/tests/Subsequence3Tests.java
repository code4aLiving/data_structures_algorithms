import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Subsequence3Tests {

    @Test
    public void test1(){
        int k = 2;
        String s = "hackerrank";
        String expected = "akrrak";
        String actual = Subsequence3.subsequence3(s, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2(){
        int k = 2;
        String s = "baaabaacba";
        String expected = "baaabaaba";
        String actual = Subsequence3.subsequence3(s, k);
        assertEquals(expected, actual);
    }
}
