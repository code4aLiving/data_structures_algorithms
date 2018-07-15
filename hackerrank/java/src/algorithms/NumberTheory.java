package algorithms;

import java.util.ArrayList;
import java.util.List;

public class NumberTheory {

    public static boolean isPrime(int n) {
        if (n == 2 || n == 3) return true;
        if (n < 2 || n % 2 == 0 || n % 3 == 0) return false;
        int k = 1;
        int p = 6 * k - 1;
        while (p * p < n) {
            if (n % p == 0 || n % (p + 2) == 0)
                return false;
            k++;
            p = 6 * k - 1;
        }
        return true;
    }

    public static List<Integer> getPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] flags = new boolean[n + 1];

        for (int i = 2; i < n + 1; i++) {
            if (!flags[i]) {
                //prime
                primes.add(i);
                for (int j = 2 * i; j < flags.length; j += i) {
                    flags[j] = true;
                }
            }
        }
        return primes;
    }

    public static int gcd(int p, int q) throws Exception {
        throw new Exception();
    }

    public static int mcm(int p, int q) throws Exception {
        throw new Exception();
    }
}
