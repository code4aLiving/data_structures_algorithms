
import java.util.HashSet;

public class FindDuplicates {

    public static void main(String[] args){
        Integer[] arr = {1,1,2,2,3,4,5,6,6,7,6,6,6};
        Integer[] duplicates = findDuplicates(arr);

        MyUtils.printarray(duplicates);
    }

    public static Integer[] findDuplicates(Integer[] arr){
        HashSet<Integer> hashTable = new HashSet();
        HashSet<Integer> res = new HashSet();

        for (int i = 0; i < arr.length; i++) {
            if (hashTable.contains(arr[i]))
                res.add(arr[i]);
            else
                hashTable.add(arr[i]);
        }
        return res.toArray(new Integer[res.size()]);
    }
}
