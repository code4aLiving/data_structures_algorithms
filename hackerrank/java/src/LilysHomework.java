import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sergio on 06/10/17.
 */
public class LilysHomework {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(CountSwaps(arr));
    }

    public static int CountSwaps(int [] arr){
        int [] sortedArr = Arrays.copyOf(arr, arr.length);
        int [] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        int [] reverseSortedArr = new int[arr.length];
        for (int i = 0; i < sortedArr.length; i++) {
            reverseSortedArr[sortedArr.length - 1 - i] = sortedArr[i];
        }
        return Math.min(CountSwaps(arr, sortedArr), CountSwaps(arrCopy, reverseSortedArr));
    }

    public static int CountSwaps(int [] arr, int[] sortedArr){

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortedArr.length; i++) {
            map.put(arr[i],i);
        }

        int swaps = 0;
        for (int i = 0; i < sortedArr.length; i++) {
            int val = sortedArr[i];
            if (map.get(val) == i)
                continue;
            swaps++;
            int temp = arr[i];
            arr[i] = sortedArr[i];
            arr[map.get(arr[i])] = temp;
            map.replace(temp, map.get(arr[i]));
            map.replace(arr[i],i);
        }

        return swaps;
    }
}
