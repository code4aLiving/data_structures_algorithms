/**
 * Created by sergio on 06/08/17.
 */

import java.util.*;

public class BetweenTwoSets {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }

    public static int getTotalX(int [] a, int [] b){
        int maxa = MyUtils.max(a);
        int res = 0;
        int x = maxa;
        while(x <= b[0]){
            boolean condition = true;
            for (int ax: a) {
                if(x % ax > 0){
                    condition = false;
                    break;
                }
            }
            if(condition){
                for(int bx: b){
                    if(bx % x > 0){
                        condition = false;
                        break;
                    }
                }
            }

            if (condition)
                res++;
            x += maxa;
        }
        return res;
    }
}
