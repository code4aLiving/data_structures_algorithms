import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergio.nunez on 11/01/2017.
 */
public class Hackerrank {

    static long mod = (long)Math.pow(10,9) + 7;
    public static long luckyNumberEight_slow(String number){
        int [] arr = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            arr[i] = Integer.parseInt(Character.toString(number.charAt(i)));
        }
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 8 == 0) {
                res += 1;
                res %= mod;
            }
            for (int j = i+1; j < arr.length; j++){
                int y = 10*arr[i] + arr[j];
                if (y % 8 == 0) {
                    res += 1;
                    res %= mod;
                }
                for (int k = j+1; k < arr.length; k++){
                    int x = 100*arr[i] + 10*arr[j] + arr[k];
                    if(x%8 == 0) {
                        res += ((long) Math.pow(2, i) % mod);
                        res %= mod;
                    }
                }
            }
        }
        return res % mod;
    }

    public static long luckyNumberEight(String number){
        byte [] digits = new byte[number.length()];
        long res = 0;

        for (int i = 0; i < number.length(); i++) {
            digits[i] = Byte.parseByte(Character.toString(number.charAt(i)));
            if (digits[i] % 8 == 0) //One digit
                res++;
        }

        long [][][] cube = twoDigitsCube(digits);
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
                        twoDigitsRes += twoTable[j-1][d];
                        //twoDigitsRes = twoDigitsRes % mod;
                    }
                }
            }

            //Three digits multiples
            res += f(digits, c,d,u,cube);
            //res = res % mod;
        }

        return (res + twoDigitsRes) % mod;
    }

    private static long f(byte [] digits, byte c, byte d, byte u, long [][][] cube){
        long res = 0;
        for (int i = 2; i < digits.length; i++) {
            if (digits[i]!=u)
                continue;
            res += cube[i-1][c][d];
            res %= mod;
        }
        return res;
    }

    private static long [][] oneDigitTable(byte [] digits){
        long [][] table = new long[digits.length][10];
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
                        table[i][j] = (table[i - 1][j] + (long)Math.pow(2, i) % mod) % mod;
                    }
                }
            }
        }
        return table;
    }

    private static long[][][] twoDigitsCube(byte [] digits){
        long [][] table = oneDigitTable(digits);
        long [][][] cube = new long[digits.length][10][10];

        for (int i = 1; i < digits.length; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (k != digits[i]){
                        cube[i][j][k] = cube[i-1][j][k];
                        continue;
                    }
                    cube[i][j][k] = (cube[i-1][j][k] + table[i-1][j]) % mod;
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

}
