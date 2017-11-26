import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import datastructures.Tuple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MutualIndivisibility {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int [] as = new int[t];
        int [] bs = new int[t];
        int [] xs = new int[t];
        for(int a0 = 0; a0 < t; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int x = in.nextInt();
            as[a0] = a;
            bs[a0] = b;
            xs[a0] = x;
        }

        for (int i = 0; i < t; i++) {
            int [] res = mutualIndivisibility2(as[i], bs[i], xs[i]);

            if (res == null)
                System.out.print(-1);
            else{
                for (int j = 0; j < res.length; j++) {
                    for (int k = j+1; k < res.length; k++) {
                        if (res[k] % res[j] == 0) {
                            System.out.print(String.format("%d %d %d %d %d",k, j, res[k], res[j], i));
                            throw new Exception();
                        }
                    }
                    if (res[j] == 0)
                        throw new Exception();
                    System.out.print(res[j]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        in.close();

    }

    public static int [] mutualIndivisibility(int a, int b, int x){
        int [] res = new int[x];
        List<Tuple<Integer,Integer>> l = new ArrayList<>();
        //Calculate how many divisor and multiples
        for (int i = a; i <=b ; i++) {
            Tuple<Integer, Integer> t = new Tuple<>(0,i);
            for (int j = a; j <= (int)Math.sqrt(i); j++) {
                if (i % j == 0)
                    t.set_first(t.get_first() + 1);
            }
            t.set_first(t.get_first() + b/i);
            l.add(t);
        }
        l.sort(new MyComparator());
        boolean [] selected = new boolean[b-a+1];
        int y = 0;

        for (Tuple<Integer, Integer> t :
                l) {
            for (int i = t.get_second(); i <= b; i+=t.get_second()) {
                if (selected[i-a]) {
                    selected[t.get_second()-a] = true;
                    break;
                }
            }
            if (selected[t.get_second() - a])//Cannot add this element
                continue;
            res[y++] = t.get_second();

            //update selected
            for (int i = t.get_second(); i <= b; i+=t.get_second()) {
                selected[i-a] = true;
            }
            if (y == x)
                break;
        }
        return y == x ? res : null;
    }

    public static int [] mutualIndivisibility2(int a, int b, int x){
        //The result is smaller than min(b-a+1,b/2)
        int min = Math.min(b-a+1,b/2);
        if (x > min)
            return null;
        int [] res = new int[x];
        for (int i = 0; i < x ; i++) {
            res[i] = b-i;
        }
        return res;
    }

    static class MyComparator implements Comparator<Tuple<Integer,Integer>>{

        @Override
        public int compare(Tuple<Integer, Integer> o1, Tuple<Integer, Integer> o2) {
            if (o1.get_first() < o2.get_first())
                return -1;
            if (o1.get_first() > o2.get_first())
                return 1;
            return -o1.get_second().compareTo(o2.get_second());
        }
    }
}
