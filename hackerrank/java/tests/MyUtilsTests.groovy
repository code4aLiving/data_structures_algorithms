/**
 * Created by sergio on 12/08/17.
 */

class MyUtilsTests extends GroovyTestCase {
    void test_binarySearchLowerClosest_generalcase() {

        int [] arr = new int[3]
        arr[0] = 0
        arr[1] = 1
        arr[2] = 3

        int res = MyUtils.binarySearchClosest(arr, 2)
        assertEquals(1, res)
    }

    void test_binarySearchClosest_allElementsAreTheSame() {

        int [] arr = new int[3]
        arr[0] = 0
        arr[1] = 0
        arr[2] = 0

        int res = MyUtils.binarySearchClosest(arr, 0)
        assertEquals(0, res)
    }

    void test_binarySearchClosest_xIsGreaterThanAll() {

        int [] arr = new int[3]
        arr[0] = 1
        arr[1] = 1
        arr[2] = 1

        int res = MyUtils.binarySearchClosest(arr, 2)
        assertEquals(2, res)
    }

    void test_binarySearchClosest_generalcase2() {

        int [] arr = new int[3]
        arr[0] = 0
        arr[1] = 1
        arr[2] = 4

        int res = MyUtils.binarySearchClosest(arr, 3)
        assertEquals(2, res)
    }

    void test_binarySearchClosest_ExistsShouldReturnTheFirst() {

        int [] arr = new int[4]
        arr[0] = 0
        arr[1] = 1
        arr[2] = 1
        arr[3] = 2

        int res = MyUtils.binarySearchClosest(arr, 1)
        assertEquals(1, res)
    }

    void test_binarySearchClosest_ExistsUnique() {

        int [] arr = new int[4]
        arr[0] = 0
        arr[1] = 0
        arr[2] = 1
        arr[3] = 5

        int res = MyUtils.binarySearchClosest(arr, 1)
        assertEquals(2, res)
    }

    void test_binarySearchClosest_OneElementArray() {

        int [] arr = new int[1]
        arr[0] = 0

        int res = MyUtils.binarySearchClosest(arr, 4)
        assertEquals(0, res)
    }

    void test_binarySearchClosest_EmptyArray() {

        int [] arr = new int[0]

        int res = MyUtils.binarySearchClosest(arr, 2)
        assertEquals(0, res)
    }

    void test_binarySearchLower_emptyArrayShouldReturnNegative(){
        int [] arr = new int[0]

        int res = MyUtils.binarySearchLower(arr, 2)
        assertTrue(res < 0);
    }

    void test_binarySearchLower_elementExistsShouldReturnCorrectIndex(){
        int [] arr = new int[4]
        arr[0] = 0
        arr[1] = 1
        arr[2] = 2
        arr[3] = 5

        int res = MyUtils.binarySearchLower(arr, 2)
        assertEquals(2, res)
    }

    void test_binarySearchLower_moreThanOneMatch_shouldReturnTheFirst(){
        int [] arr = new int[4]
        arr[0] = 0
        arr[1] = 1
        arr[2] = 1
        arr[3] = 5

        int res = MyUtils.binarySearchLower(arr, 1)
        assertEquals(1, res)
    }

    void test_binarySearchLower_noMatch_shouldReturnNegative(){
        int [] arr = new int[4]
        arr[0] = 0
        arr[1] = 1
        arr[2] = 1
        arr[3] = 5

        int res = MyUtils.binarySearchLower(arr, 10)
        assertTrue(res < 0)
    }

    void test_binarySearchUpper_emptyArray_shouldReturnNegative(){
        int[] arr = new int[0]
        assertTrue(MyUtils.binarySearchUpper(arr, 1) < 0)
    }

    void test_binarySearchUpper_elementExistsUnique_shouldReturnCorrectIndex(){
        int [] arr = new int[4]
        arr[0] = 0
        arr[1] = 3
        arr[2] = 5
        arr[3] = 6
        assertEquals(2, MyUtils.binarySearchUpper(arr, 5))
    }

    void test_binarySearchUpper_multipleElemntsMatch_shouldreturnTheLastIndex(){
        int [] arr = new int[4]
        arr[0] = 0
        arr[1] = 3
        arr[2] = 5
        arr[3] = 5
        assertEquals(3, MyUtils.binarySearchUpper(arr, 5))
    }

    void test_binarySearchUpper_noMatches_shouldReturnNegative(){
        int [] arr = new int[4]
        arr[0] = 0
        arr[1] = 3
        arr[2] = 5
        arr[3] = 5
        assertTrue(MyUtils.binarySearchUpper(arr, 4) < 0)
    }
}