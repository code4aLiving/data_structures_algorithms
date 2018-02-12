import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MatrixLandTests {

    @Test
    public void test1(){
        int [][] matrix = { {1,2,3,-1,-2},
                            {-5,-8,-1,2,-150},
                            {1,2,3,-250,100},
                            {1,1,1,1,20} };
        int res = MatrixLand.matrixLand(matrix);
        int expected = 37;
        assertEquals(expected, res);
    }
}
