import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class BuyMaximumStocks {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long k = in.nextLong();
        long result = buyMaximumStocks(arr, k);
        System.out.println(result);
        in.close();

    }

    public static int buyMaximumStocksRec(int [] prices, long k){
        return buyMaximumStocksRec(prices, 0, k);
    }

    private static int buyMaximumStocksRec(int [] prices, int day, long k){
        if (day >= prices.length || k <= 0)
            return 0;

        int res = buyMaximumStocksRec(prices, day + 1, k);
        for (int i=1; i<=day+1; i++){
            if (prices[day] * i > k)
                break;
            res = Math.max(res, i + buyMaximumStocksRec(prices, day + 1, k - (prices[day]*i)));
        }
        return res;
    }

    public static long buyMaximumStocks(int [] prices, long k){
        Tuple [] tuples = new Tuple[prices.length];
        for (int i = 0; i < prices.length; i++) {
            tuples[i] = new Tuple(prices[i],i+1);
        }
        Arrays.sort(tuples);
        long res = 0;
        for (int i = 0; i < tuples.length; i++) {
            Tuple t = tuples[i];
            if (k < t.get_a())
                break;
            long temp = Math.min(k/t.get_a(),t.get_b());
            k -= temp * t.get_a();
            res += temp;
        }
        return res;
    }

    static class Tuple implements Comparable<Tuple>{
        private long _a, _b;
        public Tuple(long a, long b){
            _a = a;
            _b = b;
        }

        public long get_a(){
            return _a;
        }

        public long get_b(){
            return _b;
        }


        @Override
        public int compareTo(@NotNull BuyMaximumStocks.Tuple o) {
            if (_a < o.get_a())
                return -1;
            if (_a > o.get_a())
                return 1;
            return 0;
        }
    }
}
