import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class surfaceArea3dTests {

    @Test
    public void surfaceAreaTest1(){
        int [][] board = {{1}};

        int expected = 6;
        int result = SurfaceArea3d.surfaceArea(board);

        assertEquals(expected, result);
    }

    @Test
    public void test2(){
        int [][] board = {{1,3,4},{2,2,3},{1,2,4}};
        int expected = 60;
        int result = SurfaceArea3d.surfaceArea(board);
        assertEquals(expected, result);
    }
    @Test
    public void test3(){
        int [][] board = {{1,2},{2,2}};
        int expected = 24;
        int result = SurfaceArea3d.surfaceArea(board);
        assertEquals(expected, result);
    }

    @Test
    public void test4(){
        int [][] board = {{2,2,2},{2,1,2},{2,2,2}};
        int expected = 46;
        int result = SurfaceArea3d.surfaceArea(board);
        assertEquals(expected, result);
    }

    @Test
    public void test5(){
        int [][] board = {{2}};
        int expected = 10;
        int result = SurfaceArea3d.surfaceArea(board);
        assertEquals(expected, result);
    }
    @Test
    public void test6(){
        int [][] board = {{1},{2}};
        int expected = 14;
        int result = SurfaceArea3d.surfaceArea(board);
        assertEquals(expected, result);
    }

    @Test
    public void test7(){
        int [][] board = {{1,2}};
        int expected = 14;
        int result = SurfaceArea3d.surfaceArea(board);
        assertEquals(expected, result);
    }
}
