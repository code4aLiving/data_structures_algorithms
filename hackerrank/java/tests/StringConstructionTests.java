import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class StringConstructionTests {

    @Test
    public void emptyString() {

    }

    @Test
    public void oneCharString() {

    }

    @Test
    public void allCharsTheSame() {

    }

    @Test
    public void xEqualsZero() {

    }

    @Test
    public void xGreaterThanY() {
        String s = "abaccc";
        int x = 5;
        int y = 4;
        long expected = StringConstruction.solveRec(s, x, y, 0);
        long actual = StringConstruction.solve4(s, x, y);
        assertEquals(expected, actual);
    }

    @Test
    public void yGreaterThanX() {
        String s = "baccacbbcb";
        int x = 5;
        int y = 9;
        long expected = StringConstruction.solveRec(s, x, y, 0);
        long actual = StringConstruction.solve4(s, x, y);
        assertEquals(expected, actual);
    }

    @Test
    public void test_random() {
        final int tests = 10000;
        final int len = 4;
        final int chars = 3;
        Random r = new Random();
        for (int i = 0; i < tests; i++) {
            final String input = generateRandom(len, chars);
            final int x = r.nextInt(11);
            final int y = r.nextInt(11);
            long recSolve = StringConstruction.solveRec(input, x, y, 0);
            long solveN2 = StringConstruction.solve4(input, x, y);

            System.out.println(String.format("%d s:%s x:%d y:%d", i, input, x, y));
            assertEquals(recSolve, solveN2);
        }
    }

    @Test
    public void test2() {
        String s = "adabcdabc";
        long actual = StringConstruction.solve4(s, 1, 2);
        long expected = StringConstruction.solve(s, 1, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        String s = "xzxpzxzxpq";
        long actual = StringConstruction.solve4(s, 10, 11);
        assertEquals(71, actual);
    }

    @Test
    public void solve3() {
        String s = "abababab";
        int x = 1;
        int y = 2;
        long expected = StringConstruction.solveRec(s, x, y, 0);
        long actual = StringConstruction.solve4(s, x, y);
        assertEquals(expected, actual);
    }

    @Test
    public void solve3_1() {
        String s = "ddd";
        int x = 4;
        int y = 3;
        long expected = StringConstruction.solveRec(s, x, y, 0);
        long actual = StringConstruction.solve4(s, x, y);
        assertEquals(expected, actual);
    }

    private String generateRandom(int len, int chars) {
        int inta = (int) 'a';
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            int x = r.nextInt(chars + 1);
            sb.append((char) (x + inta));
        }
        return sb.toString();
    }
}
