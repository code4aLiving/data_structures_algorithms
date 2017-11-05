import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sergio on 31/08/17.
 */
public class CollatzConjecture {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0)
                break;

            int [] res = collatzCollide(a, b);
            System.out.printf("%d needs %d steps, %d needs %d steps, they meet at %d\n",
                    a, res[0], b, res[1], res[2]);

        }
    }

    public static int[] collatzCollide(int a, int b){
        int [] res = new int[3];
        res[0] = Integer.MIN_VALUE;
        HashMap<Integer, Integer> aHash = new HashMap<>();
        HashMap<Integer, Integer> bHash = new HashMap<>();
        aHash.put(a,0);
        bHash.put(b,0);
        int i = 0;
        while (true){
            if (aHash.containsKey(b)){
                res[0] = aHash.get(b); //seq a position
                res[1] =  i; //seq b position
                res[2] = b;
            }
            if (bHash.containsKey(a) && (res[0] > bHash.get(a) || res[0] < 0)){
                res[0] = i;
                res[1] = bHash.get(a);
                res[2] = a;
            }
            if (res[2] > 0)
                break;
            i++;
            if (!aHash.containsKey(1)) {
                a = a%2==0 ? a/2 : a*3 + 1;
                aHash.put(a, i);
            }
            if (!bHash.containsKey(1)) {
                b = b%2 == 0 ? b/2 : b*3+1;
                bHash.put(b, i);
            }
        }

        return res;
    }
}
