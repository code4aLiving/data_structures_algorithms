/**
 * Created by sergio on 06/08/17.
 */
public class MyUtils {

    public static void main(String[] args){
        Integer [] arr = {4,3,5,6,7,1,0,0,0,1};
        Integer [] arr1 = {};
        Integer [] arr2 = { 0 };
        Integer [] arr3 = { 1,0 };

        Integer [] sorted = quicksort(arr);
        printarray(sorted);
        System.out.println();
        Integer [] sorted1 = quicksort(arr1);
        printarray(sorted1);
        System.out.println();
        Integer [] sorted2 = quicksort(arr2);
        printarray(sorted2);
        System.out.println();
        Integer [] sorted3 = quicksort(arr3);
        printarray(sorted3);
        System.out.println();

    }

    public static void printarray(Integer [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.format("%d ",arr[i]));
        }
    }

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

    public static int binarySearchClosest(int [] arr, int x, int start, int end) {
        if (start >= end) {
            return start;
        }
        int middle = (start + end) / 2;
        if (x <= arr[middle])
            return binarySearchClosest(arr, x, start, middle);
        if (arr[middle] < arr[middle + 1] && Math.abs(x - arr[middle]) <= Math.abs(x - arr[middle + 1]))
            return middle;
        return binarySearchClosest(arr, x, middle + 1, end);
    }
   
     public static Integer[] quicksort(Integer[] arr){
        Integer [] res = new Integer[arr.length];
        System.arraycopy(arr, 0, res, 0, arr.length);
        quicksort(res, 0, res.length - 1);
        return res;
    }

    private static void quicksort(Integer [] arr, int start, int end){
        if (start >= end)
            return;
        int ipivot = partition(arr, start, end);
        quicksort(arr, start, ipivot - 1);
        quicksort(arr, ipivot + 1, end);
    }

    private static int partition(Integer [] arr, int start, int end){
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot){
                i++;
                swap(i, j, arr);
            }
        }
        swap(i+1,end,arr);
        return i+1;
    }

    public static void swap(int i, int j, Object[] arr){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /** Each query is of the form l,r
     * The result is an array where position i is the sum of all the elemnts of arr
     * between qi_l and qi_r*/
    public static int[] partialSums(int [] arr, int[][] queries){
        int [] sums = new int[arr.length];
        sums[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sums[i] = sums[i-1] + arr[i];
        }
        int [] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l == 0)
                res[i] = sums[r];
            else
                res[i] = sums[r] - sums[l-1];
        }
        return res;
    }
    /** Each query is of the form l,r,v
     * For each query add v to every element of arr which indexes are between l and r,
     * inclusive*/
    public static int[] partialSumsIncrement(int [] arr, int[][] queries){

        //Create a zeros array
        int [] temp = new int[arr.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int v = queries[i][2];

            temp[l] += v;
            if (r < temp.length - 1)
                temp[r+1] -= v;
        }
        int [] res = new int[arr.length];
        res[0] = arr[0] + temp[0];
        for (int i = 1; i < temp.length; i++) {
            temp[i] += temp[i-1];
            res[i] = arr[i] + temp[i];
        }
        return res;
    }
}
