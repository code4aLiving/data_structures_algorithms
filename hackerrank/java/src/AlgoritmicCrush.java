import java.math.BigInteger;
import java.util.Scanner;

public class AlgoritmicCrush {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int [][] queries = new int[m][3];
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            queries[a0][0] = a-1;
            queries[a0][1] = b-1;
            queries[a0][2] = k;
        }
        in.close();
        BigInteger res = algoritmicCrush(n,queries);
        System.out.println(res);
    }

    public static BigInteger algoritmicCrush(int n, int [][] queries){
        BigInteger [] arr = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            arr[i] = BigInteger.ZERO;
        }
        for (int i=0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            BigInteger k = BigInteger.valueOf(queries[i][2]);

            arr[l] = arr[l].add(k);
            if(r < arr.length-1)
                arr[r+1] = arr[r+1].subtract(k);
        }
        BigInteger max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i].add(arr[i-1]);
            if (max.compareTo(arr[i]) < 0)
                max = arr[i];
        }

        return max;
    }
}
