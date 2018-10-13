package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringMatchingTests {

    @Test
    public void computePrefix() {
        String p = "ababaca";
        int[] expected = {0, 0, 0, 1, 2, 3, 0, 1};
        int [] actual = StringMatching.computePrefix(p);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void computePrefix2() {
        String p = "abcdabd";
        int[] expected = {0, 0, 0, 0, 0, 1, 2, 0};
        int [] actual = StringMatching.computePrefix(p);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void computePrefix3() {
        String p = "adabcdabc";
        int[] expected = {0, 0, 0, 1, 0, 0, 0, 1, 0, 0};
        int [] actual = StringMatching.computePrefix(p);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void computePrefix4() {
        String p = "bdcdb";
        int[] expected = {0, 0, 0, 0, 0, 1};
        int [] actual = StringMatching.computePrefix(p);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}
