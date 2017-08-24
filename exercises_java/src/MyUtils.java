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

    public static int binarySearchLower(int [] arr, int x){
        return binarySearchLower(arr, x, 0, arr.length-1);
    }

    public static int binarySearchLower(int [] arr, int x, int start, int end){
        if (start > end)
            return -1;
        if (start == end){
            if (x == arr[start])
                return start;
            return -1;
        }

        int middle = (start + end) / 2;
        if (x <= arr[middle])
            return binarySearchLower(arr, x, start, middle);
        return binarySearchLower(arr, x, middle + 1, end);
    }

    public static int binarySearchUpper(int [] arr, int x){
        return binarySearchUpper(arr, x, 0, arr.length -1);
    }

    public static int binarySearchUpper(int [] arr, int x, int start, int end){
        if (start > end)
            return -1;
        if (start == end) {
            if (x == arr[start])
                return start;
            return -1;
        }

        int middle = (start+end)/2;
        if (x >= arr[middle]){
            if (x == arr[middle] && arr[middle+1] > x)
                return middle;
            return binarySearchUpper(arr, x, middle + 1, end);
        }
        return binarySearchUpper(arr, x, start, middle-1);
    }

    public static boolean binarySearch(int [] arr, int x){
        return binarySearch(arr, x, 0, arr.length - 1);
    }

    public static boolean binarySearch(int [] arr, int x, int start, int end){
        int index = binarySearchLower(arr, x, start, end);
        return index >= start && index <= end;
    }

    public static int binarySearchClosest(int [] arr, int x){
        return binarySearchClosest(arr, x, 0, arr.length-1);
    }

    public static int binarySearchClosest(int [] arr, int x, int start, int end){
        if (start >= end) {
            return start;
        }
        int middle = (start + end)/2;
        if (x <= arr[middle])
            return binarySearchClosest(arr, x, start, middle);
        if (arr[middle] < arr[middle+1] && Math.abs(x - arr[middle]) <= Math.abs(x - arr[middle + 1]))
            return middle;
        return binarySearchClosest(arr, x, middle + 1, end);
    }
}
