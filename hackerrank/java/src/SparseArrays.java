import java.util.Collection;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by sergio on 14/08/17.
 */
public class SparseArrays {

    public static void main(String[] arr){
        Scanner sc = new Scanner(System.in);
        int scount = sc.nextInt();
        String [] strings = new String[scount];
        for (int i = 0; i < scount; i++) {
            strings[i] = sc.next();
        }
        int qcount = sc.nextInt();
        String [] queries = new String[qcount];
        for (int i = 0; i < qcount; i++) {
            queries[i] = sc.next();
        }
        int[] res = sparseArrays(strings, queries);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] sparseArrays(String [] strings, String [] queries){
        Hashtable<String,Integer> htable = new Hashtable<>();
        int[] res = new int[queries.length];
        for (String s: strings) {
            if (htable.containsKey(s)){
                Integer oldVal = htable.get(s);
                htable.replace(s, oldVal + 1);
            }
            else{
                htable.put(s, 1);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (htable.containsKey(queries[i]))
                res[i] = htable.get(queries[i]);
        }
        return res;
    }
}
