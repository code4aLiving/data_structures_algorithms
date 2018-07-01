import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by sergio on 27/08/17.
 */
public class AmazonTests {

    @Test
    public void countPairsTest1(){
        int [] Integers = {0, -8, -6, -7, -9};
        int expected = Amazon.countPairsBruteForce(Integers, -1);
        assertEquals(expected, Amazon.countPairs(Integers, -1));
    }

    @Test
    public void countPairsTest2(){
        int [] Integers = {0, -8, -6, -7, -9};
        int expected = Amazon.countPairsBruteForce(Integers, -1);
        assertEquals(expected, Amazon.countPairs2(Integers, -1));
    }

    @Test
    public void countPairsRandomTests(){
        Random r = new Random();
        int [] Integers = new int[5];
        while(true){
            for (int i = 0; i < Integers.length; i++) {
                int sign = r.nextInt(1);
                int num = r.nextInt(10);
                Integers[i] = sign == 0 ? -num : num;
            }
            int sign = r.nextInt(1);
            int k = r.nextInt(10);
            k = sign == 0 ? -k : k;

            int expected = Amazon.countPairsBruteForce(Integers, k);
            int actual = Amazon.countPairs2(Integers, k);

            if (expected != actual){
                MyUtils.printarray(Integers);
                System.out.println("");
                System.out.printf("k: %d \nexpected: %d \nactual: %d", k, expected, actual);
                break;
            }
        }
    }
}
