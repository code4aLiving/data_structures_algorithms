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
}
