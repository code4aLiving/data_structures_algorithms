import java.lang.reflect.Array;

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

    public static int[] quicksort(int[] arr){

        int [] res = new int[arr.length];
        System.arraycopy(arr, 0, res, 0, arr.length);
        quicksort(res, 0, res.length - 1, res.length / 2);
        return res;
    }

    private static void quicksort(int [] arr, int start, int end, int p){
        int pivot = arr[p];

    }
}
