import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by sergio on 27/08/17.
 */
public class SherlockAndValidString {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        Boolean result = isValid(s);
        if(result)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static boolean isValid(String s){
        HashMap<Character, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (hashTable.containsKey(c))
                hashTable.replace(c, hashTable.get(c) + 1);
            else
                hashTable.put(c,1);
        }

        HashMap<Integer, Integer> invertedHash = new HashMap<>();
        for (Character c: hashTable.keySet()) {
            Integer value = hashTable.get(c);
            if (invertedHash.containsKey(value))
                invertedHash.replace(value, invertedHash.get(value) + 1);
            else
                invertedHash.put(value, 1);
        }

        if (invertedHash.size() == 1)
            return true;
        if (invertedHash.size() == 2){
            if (invertedHash.containsKey(1) && invertedHash.get(1) == 1)
                return true;

            Integer [] arr = new Integer[2];
            invertedHash.keySet().toArray(arr);
            Arrays.sort(arr);
            if(arr[1] - arr[0] == 1 && invertedHash.get(arr[1]) == 1)
                return true;
        }

        return false;
    }
}
