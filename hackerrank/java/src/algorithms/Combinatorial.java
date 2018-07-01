package algorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Combinatorial {

    public static int[][] permutations(int n) {

        if (n == 1) {
            return new int[][]{{1}};
        }
        List<int[]> result = new ArrayList<>();
        int[][] subPermutations = permutations(n - 1);
        for (int[] p : subPermutations) {
            for (int i = 0; i < n; i++) {
                int[] nextP = new int[n];
                for (int j = 0; j < i; j++) {
                    nextP[j] = p[j];
                }
                nextP[i] = n;
                for (int j = i; j < n - 1; j++) {
                    nextP[j + 1] = p[j];
                }
                result.add(nextP);
            }
        }
        return result.toArray(new int[result.size()][n]);
    }

    public static int[][] permutations(int[] arr) {
        int[][] pi = permutations(arr.length);
        int[][] result = new int[pi.length][pi[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                int index = pi[i][j] - 1;
                result[i][j] = arr[index];
            }
        }
        return result;
    }

    public static long factorial(long n) {
        long result = 1;
        for (long i = 2; i < n + 1; i++) {
            result *= i;
        }
        return result;
    }

    public static BigInteger bigFactorial(long n) {
        BigInteger result = BigInteger.valueOf(1);
        for (long i = 2; i < n + 1; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public long combinations(long n, long k) throws Exception {
        throw new Exception();
    }

    public long variations(long n, long k) throws Exception {
        throw new Exception();
    }

    /**
     * Calculate all the factorials from 0 to n.
     * Runs in O(n)
     * @param n
     * @return
     * @throws Exception
     */
    public long[] factorials(int n) throws Exception {
        long [] result = new long[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i-1] * i;
        }
        return result;
    }
}
