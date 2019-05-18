package algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NumberTheoryTest {
    private int input;
    boolean isPrimeOutput;

    public NumberTheoryTest(int input, boolean isPrimeOutput) {
        this.input = input;
        this.isPrimeOutput = isPrimeOutput;
    }

    @Parameterized.Parameters
    public static Collection inputs() {
        return Arrays.asList(new Object[][]{
                {2, true},
                {0, false},
                {1, false},
                {3, true},
                {5, true},
                {10, false},
                {11, true},
                {101, true}
        });
    }

    @Test
    public void isPrime() throws Exception {
        assertEquals(isPrimeOutput, NumberTheory.isPrime(input));
    }

    @Test
    public void gcd() {
    }

    @Test
    public void mcm() {
    }

    @Test
    public void primeFactorization() throws Exception {
        int n = 12;
        int[] primes = {2, 3, 5, 7, 11, 13};
        List<Integer> actual = NumberTheory.primeFactorization(primes, n);
        List<Integer> expected = Arrays.asList(2, 2, 3);
        assertEquals(expected, actual);
    }
}