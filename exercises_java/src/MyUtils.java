/**
 * Created by sergio on 06/08/17.
 */
public class MyUtils {

    public static int min(int [] a){
        int res = Integer.MAX_VALUE;
        for (int x:a) {
            if (res > x)
                res = x;
        }
        return res;
    }

    public static int max(int[] a){
        int res = Integer.MIN_VALUE;
        for(int x:a) {
            if (res < x)
                res = x;
        }
        return res;
    }
}
