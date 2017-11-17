import java.util.HashMap;

public class Subsequence3 {

    public static void main(String[] args){
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>(map);
    }

    public static String subsequence3(String s, int k){
        HashMap<Character, Integer> htable = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (htable.containsKey(c))
                htable.replace(c, htable.get(c) + 1);
            else
                htable.put(c, 1);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (htable.get(c) >= k)
                sb.append(c);
        }

        return sb.toString();
    }
}
