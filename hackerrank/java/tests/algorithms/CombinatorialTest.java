package algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CombinatorialTest {

    private long input, expectedOutput;

    public CombinatorialTest(long input, long expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection inputs() {
        return Arrays.asList(new Object[][]{
                {-2, 1},
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120},
                {6, 720}
        });
    }

    @Test
    public void factorial() {
        assertEquals(expectedOutput, Combinatorial.factorial(input));
    }

    @Test
    public void bigFactorial() {
        assertEquals(BigInteger.valueOf(expectedOutput), Combinatorial.bigFactorial(input));
    }

    @Test
    public void permutations() {
        final int n = 3;
        final int[][] expectedResult = {
                {1, 2, 3},
                {1, 3, 2},
                {2, 1, 3},
                {2, 3, 1},
                {3, 1, 2},
                {3, 2, 1}
        };
        final int[][] actual = Combinatorial.permutations(n);
        assertEquals(expectedResult.length, actual.length);
        for (int[] ep : expectedResult) {
            boolean assertion = false;
            for (int[] ap: actual) {
                assertion = arrayEquals(ep, ap);
                if (assertion)
                    break;
            }
            assertTrue(assertion);
        }
    }

    private boolean arrayEquals(final int[] a1, final int[] a2) {
        if (a1.length != a2.length)
            return false;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i])
                return false;
        }
        return true;
    }
}