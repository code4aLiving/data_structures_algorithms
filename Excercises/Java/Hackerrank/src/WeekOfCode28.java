import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by sergio on 11/01/17.
 */
public class WeekOfCode28 {

    public static int luckyNumberEight(String number){
        byte [] digits = new byte[number.length()];
        int res = 0;
        int mod = (int)Math.pow(10,9);
        for (int i = 0; i < number.length(); i++) {
            digits[i] = Byte.parseByte(Character.toString(number.charAt(i)));
            if (digits[i] % 8 == 0) //One digit
                res++;
        }
        res = res % mod;
        int [][][] cube = twoDigitsCube(digits);
        List<Integer> multiplesOfEight = new ArrayList<>();
        int i = 0;
        while(8*i < 1000) {
            multiplesOfEight.add(8 * i);
            i++;
        }

        int [][] twoTable = twoDigitsTable(digits);
        int twoDigitsRes = 0;
        for (int m: multiplesOfEight) {
            byte c = (byte)(m / 100);
            byte d = (byte)((m / 10) % 10);
            byte u = (byte)(m % 10);

            //Two digit multiples
            if (m == 0 || m == 8 || (m > 10 && m < 100)){
                for (int j = digits.length-1; j > 0; j--) {
                    if (digits[j] == u){
                        twoDigitsRes += twoTable[j-1][d] % mod;
                        twoDigitsRes = twoDigitsRes % mod;
                    }
                }
            }

            //Three digits multiples
            res += f(digits, c,d,u,cube) % mod;
            res = res % mod;
        }

        return (res + twoDigitsRes) % mod;
    }

    private static int f(byte [] digits, byte c, byte d, byte u, int [][][] cube){
        int res = 0;
        for (int i = 2; i < digits.length; i++) {
            if (digits[i]!=u)
                continue;
            res += cube[i-1][c][d];
        }
        return res;
    }

    private static int [][] oneDigitTable(byte [] digits){
        int [][] table = new int[digits.length][10];
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j != digits[i]){
                    if(i > 0)
                        table[i][j] = table[i-1][j];

                }
                else {
                    if (i == 0)
                        table[i][j] = 1;
                    else {
                        table[i][j] = table[i - 1][j] + (int) Math.pow(2, i);
                    }
                }
            }
        }
        return table;
    }

    private static int[][][] twoDigitsCube(byte [] digits){
        int [][] table = oneDigitTable(digits);
        int [][][] cube = new int[digits.length][10][10];

        for (int i = 1; i < digits.length; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (k != digits[i]){
                        cube[i][j][k] = cube[i-1][j][k];
                        continue;
                    }
                    cube[i][j][k] = cube[i-1][j][k] + table[i-1][j];
                }
            }
        }
        return cube;
    }

    private static int[][] twoDigitsTable(byte [] digits){
        int [][] table = new int[digits.length][10];
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < 10; j++) {
                if (digits[i] != j){
                    if (i > 0)
                        table[i][j]=table[i-1][j];
                }
                else{
                    if (i > 0)
                        table[i][j]=table[i-1][j]+1;
                    else
                        table[i][j]=1;
                }
            }
        }
        return table;
    }

    public static int luckyNumberEight_Slow(String number){
        int [] arr = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            arr[i] = Integer.parseInt(Character.toString(number.charAt(i)));
        }
        int res = 0;
        int mod = (int)Math.pow(10,9);
        for (int i = arr.length -1; i >= 0; i--) {
            if (arr[i] % 8 == 0)
                res+=1;
            for (int j = i-1; j >= 0; j--){
                if ((10*arr[j] + arr[i]) % 8 == 0)
                    res+=1;
                for (int k = j-1; k >= 0; k--){
                    int x = 100*arr[k] + 10*arr[j] + arr[i];
                    if(x%8 == 0)
                        res += ((int)Math.pow(2,k)) % mod;
                }
            }
        }
        return res;
    }

    public static int[] rangeModularQueries(int [] arr, RangeModularQuery [] queries){
        int[] result = new int[queries.length];
        HashMap<RangeModularQuery,int[]> prevQueries = new HashMap();
        for (int i = 0; i < queries.length; i++) {
            result[i] = rangeModularQuery(arr, queries[i],prevQueries);
        }
        return result;
    }

    private static int rangeModularQuery(int [] arr, RangeModularQuery query, HashMap<RangeModularQuery, int []> prevQueries){
        if (!prevQueries.containsKey(query)){
            int [] memory = new int[arr.length];
            memory[0] = arr[0]%query.x == query.y ? 1 : 0;
            for (int i = 1; i <= arr.length; i++) {
                memory[i] = memory[i-1] + arr[i]%query.x == query.y ? 1 : 0;
            }
            prevQueries.put(query,memory);
        }

        if(query.left == 0)
            return prevQueries.get(query)[query.right];
        else
            return prevQueries.get(query)[query.right] - prevQueries.get(query)[query.left-1];
    }

    public class RangeModularQuery{
        public int left,right,x,y;
        public RangeModularQuery(Integer leftP,Integer rightP,Integer xP,Integer yP){
            left = leftP;
            right = rightP;
            x = xP;
            y = yP;
        }

        @Override
        public boolean equals(Object other){
            RangeModularQuery otherQuery = (RangeModularQuery)other;
            return otherQuery.x == x && otherQuery.y == y;
        }
        @Override
        public int hashCode(){
            return ((Integer)x).hashCode() & ((Integer)y).hashCode();
        }
    }

    public static int poles(int n, int k, int [] weights, int [] positions){
        int res = Integer.MAX_VALUE;
        int [][] table = new int[n][k];
        int[][] costs = costs(weights,positions);
        for (int row = 0; row < k; row++) {
            for (int col = row + 1; col <= n-k; col++) {
                if (row == 0)
                    table[row][col] = costs[0][col];
                else{
                    int tempRes = Integer.MAX_VALUE;
                    for (int i = row-1; i < col; i++) {
                        tempRes = Math.min(tempRes,table[row-1][i] + costs[i+1][col]);
                    }
                    table[row][col] = tempRes;
                }
            }

        }

        for (int col = 0; col < n-k; col++) {
            res = Math.min(res, table[k-1][col] + costs[col+1][n-1]);
        }
        return res;
    }

    public static int [][] costs(int [] weights, int [] positions){
        int [][] res = new int[weights.length][weights.length];
        for (int i = 0; i < res[0].length; i++) {
            for (int j = i+1; j < res[0].length; j++) {
                for (int k = i; k <= j ; k++) {
                    res[i][j] += weights[k]*(positions[j]-positions[i]);
                }
            }
        }
        return res;
    }
}
