import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TowerBreakersAgain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] primes = getPrimes(100000).stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < t; i++) {
            int[] towers = readIntArray(sc);
            System.out.println(solve(towers, primes));
        }
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

    public static int solve(int[] towers, int[] primes) {
        int[] piles = new int[towers.length];
        for (int i = 0; i < towers.length; i++) {
            HashMap<Integer, Integer> factors = primeFactorization(primes, towers[i]);
            for (Integer key: factors.keySet()) {
                if (key == 2) {
                    piles[i] += 1;
                }
                else {
                    piles[i] += factors.get(key);
                }
            }
        }
        return nim(piles) + 1;
    }

    public static int[] readIntArray(Scanner sc) {
        int n = sc.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextInt();
        }
        return res;
    }

    public static HashMap<Integer, Integer> primeFactorization(int[] primes, int n) {
        final HashMap<Integer, Integer> res = new HashMap<>();
        int i = 0;
        while (n > 1 && i < primes.length && primes[i] <= n) {
            if (n % primes[i] == 0) {
                n /= primes[i];
                if (res.containsKey(primes[i])) {
                    res.put(primes[i], res.get(primes[i]) + 1);
                }
                else res.put(primes[i], 1);
            } else
                i++;
        }
        return res;
    }

    public static int nim(int[] piles) {
        int res = 0;
        for (int i = 0; i < piles.length; i++) {
            res = res ^ piles[i];
        }
        if (res != 0)
            return 0;
        return 1;
    }
}
