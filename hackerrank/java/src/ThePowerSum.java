import java.util.Scanner;

/**
 * Created by sergio on 03/10/17.
 */
public class ThePowerSum {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(thePowerSum(x, n));
        sc.close();
    }

    public static int thePowerSum(int x, int n){
        return thePowerSum(x, n, 1);
    }

    private static int thePowerSum(int x, int n, int min){
        if (x == 0)
            return 1;
        int pow = (int)Math.pow(min, n);
        if (pow > x)
            return 0;

        int res = thePowerSum(x - pow, n, min+1);
        res += thePowerSum(x, n, min + 1);
        return res;
    }
}
