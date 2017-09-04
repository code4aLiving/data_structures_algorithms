import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import datastructures.Tuple;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class StringReduction {

    public static void main(String[] args){

    }

    public static int stringReductionBruteForce(String s){
        int res = Integer.MAX_VALUE;
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);

        while(queue.size() > 0){
            String current = queue.poll();
            res = Math.min(res, current.length());
            for (String neighbor: getNeighbors(current)){
                if (visited.contains(neighbor))
                    continue;
                queue.add(neighbor);
                visited.add(neighbor);
            }
        }
        return res;
    }

    private static Iterable<String> getNeighbors(String s){

        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == s.charAt(i+1))
            i++;

        final int start = i;

        return new Iterable<String>() {
            @NotNull
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int i = start;
                    @Override
                    public boolean hasNext() {
                        return i < s.length()-1;
                    }

                    @Override
                    public String next() {
                        char[] current = s.toCharArray();
                        return null;
                    }
                };
            }
        };
    }

    private static Tuple<Integer, char[]> stringReductionRecursive(char [] s, int start, int end){

        if (start == end) {
            char [] res = new char[] {s[start]};
            return new Tuple<Integer, char[]>(1, res);
        }

        if (end - start == 1){
            char [] res;
            if (s[start] != s[end]){
                res = new char[1];
                if (s[start] != 'c' && s[end] != 'c' )
                    res[0] = 'c';
                else if(s[start] != 'a' && s[end] != 'a')
                    res[0] = 'a';
                else
                    res[0] = 'b';
                return new Tuple(1, res);
            }
            else {
                res = new char[] {s[start], s[end]};
                return new Tuple(2, res);
            }
        }

        Tuple<Integer, char[]> res = new Tuple<>(Integer.MAX_VALUE, null);
        for (int i = start; i < end; i++) {
            Tuple<Integer, char[]> left = stringReductionRecursive(s, start, i);
            Tuple<Integer, char[]> right = stringReductionRecursive(s, i + 1, end);
            char [] l = left.get_second();
            char [] r = right.get_second();

            if (l[l.length - 1] != r[0]){

            }
            else{
                if (res.get_first() > left.get_first() + right.get_first()){
                    char [] concat = Arrays.
                }

            }

        }
    }
}
