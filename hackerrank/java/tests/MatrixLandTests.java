import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixLandTests {

    @Test
    public void subsequenceSumTest(){
        int [] arr = {1,2,3,-1,-2};
        int [] expected = {6,6,6,5,3};
        int [] result = MatrixLand.subsequenceSum(arr);

        for (int i = 0; i < result.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    public void subsequenceSumTest2(){
        int [] arr = {16,-3,8,-1,12,-15,17,12,7,-9,-12,6,-13,-18,-7,-15,12,-10,-2,16};
        //int [] expected = {53,53,53,53,53,53,53,53,53};
        int [] result = MatrixLand.subsequenceSum(arr);
    }

    @Test
    public void matrixLandTest(){
        int [][] matrix = {{1,2,3,-1,-1},{-5,-8,-1,2,-150},{1,2,3,-250,100},{1,1,1,1,20}};
        int res = MatrixLand.matrixLand(matrix);
        int expected = 37;

        assertEquals(expected, res);
    }
}
