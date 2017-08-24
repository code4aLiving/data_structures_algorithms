/**
 * Created by sergio on 06/08/17.
 */
import java.util.*;

public class BirthdayCakeCandles {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }

    public static int birthdayCakeCandles(int n, int[] arr){
        int max = -1;
        int res = 0;
        for (int candle: arr) {
            if(candle == max){
                res++;
            }
            else if(candle > max){
                max = candle;
                res = 1;
            }
        }
        return res;

    }
}
