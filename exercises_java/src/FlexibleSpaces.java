import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class FlexibleSpaces {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int divs = sc.nextInt();

        int [] divisions = new int[divs + 2];
        divisions[divs + 1] = width;
        for (int i = 1; i < divs + 1; i++) {
            divisions[i] = sc.nextInt();
        }
        Arrays.sort(divisions);
        Integer [] res = flexibleSpaces(divisions);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
        System.in.close();
    }

    public static Integer[] flexibleSpaces(int [] divisions){
        HashSet<Integer> spaces = new HashSet();
        for (int i = 0; i < divisions.length; i++) {
            for (int j = i + 1; j < divisions.length; j++) {
                spaces.add(new Integer(divisions[j] - divisions[i]));
            }
        }
        Integer[] res = spaces.toArray(new Integer[spaces.size()]);
        Arrays.sort(res);
        return res;
    }
}
