import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlexibleSpacesTests {

    @Test
    public void test(){
        Integer [] expected = new Integer[] {1, 2, 3, 4, 5, 6};
        int [] input = new int[] {0, 2, 5, 6};
        Integer [] res = FlexibleSpaces.flexibleSpaces(input);

        for (int i = 0; i < expected.length; i++) {
             assertEquals(expected[i], res[i]);
        }
    }
}
