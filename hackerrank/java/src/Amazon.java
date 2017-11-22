import java.util.*;

/**
 * Created by sergio on 27/08/17.
 */
public class Amazon {

    public static int isBalanced(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (c == '}' || c == ']'){
                if (stack.size() == 0)
                    return 0;
                if (c == '}' && stack.peek() != '{')
                    return 0;
                if (c == ']' && stack.peek() != '[')
                    return 0;
                stack.pop();
            }
            else if (c == '[' || c == '{')
                stack.push(c);
        }


        return stack.size() == 0 ? 1 : 0;
    }

    static int countPairs(int[] numbers, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for(int i=0; i < numbers.length; i++){
            Integer number = numbers[i];
            if(hashMap.containsKey(number))
                hashMap.replace(number, hashMap.get(number)+1);
            else
                hashMap.put(number, 1);
        }

        int pairs = 0;
        Integer[] arr = new Integer[hashMap.keySet().size()];
        hashMap.keySet().toArray(arr);
        Arrays.sort(arr);
        for(Integer key: arr){
            Integer posKey = key + k;
            //Integer negKey = key - k;
            pairs += updatePairsAndHashMap(hashMap, posKey, key);
            //pairs += updatePairsAndHashMap(hashMap, negKey, key);
        }
        return pairs;
    }

    public static int countPairs2(int [] numbers, int k){
        int e = 1000000;
        int [] arr = new int[2*e];
        for (int i = 0; i < numbers.length; i++) {
            arr[numbers[i] + e]++;
        }
        Arrays.sort(numbers);
        int pairs = 0;
        for (int i = 0; i < numbers.length; i++) {
            int min = Math.min(arr[numbers[i] + e], arr[numbers[i] + k + e]);
            if(k == 0){
                pairs += min/2;
                arr[numbers[i] + e] -= min;
            }
            else{
                pairs += min;
                arr[numbers[i] + e] -= min;
                arr[numbers[i] + k + e] -= min;
            }
        }
        return pairs;
    }

    static int updatePairsAndHashMap(HashMap<Integer, Integer> hashMap, Integer key, Integer k){
        if (!hashMap.containsKey(key) || !hashMap.containsKey(k))
            return 0;
        int pairs;
        if (key == k){
            pairs = hashMap.get(key)/2;
            hashMap.replace(key, pairs % 2);
        }
        else {
            pairs = Math.min(hashMap.get(key), hashMap.get(k));
            hashMap.replace(key, hashMap.get(key) - pairs);
            hashMap.replace(k, hashMap.get(k) - pairs);
        }
        return pairs;
    }

    public static int countPairsBruteForce(int[] numbers, int k){
        int res = 0;
        HashSet<Integer> visited = new HashSet<>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (visited.contains(i))
                continue;
            for (int j = i + 1; j < numbers.length; j++) {
                if (visited.contains(j))
                    continue;
                if (Math.abs(k) == Math.abs(numbers[i]-numbers[j])){
                    res++;
                    visited.add(j);
                    visited.add(i);
                    break;
                }
            }
        }
        return res;
    }
}
