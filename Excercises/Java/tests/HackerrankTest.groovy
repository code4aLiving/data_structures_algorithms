/**
 * Created by sergio.nunez on 11/01/2017.
 */
class HackerrankTest extends GroovyTestCase {


    void setUp() {
        super.setUp()

    }

    void testLuckyNumberEight() {
        assertEquals(Hackerrank.luckyNumberEight_slow("08"),Hackerrank.luckyNumberEight("08"))
        assertEquals(Hackerrank.luckyNumberEight_slow("0"),Hackerrank.luckyNumberEight("0"))
        assertEquals(Hackerrank.luckyNumberEight_slow("00"),Hackerrank.luckyNumberEight("00"))
        assertEquals(Hackerrank.luckyNumberEight_slow("1"),Hackerrank.luckyNumberEight("1"))
        assertEquals(Hackerrank.luckyNumberEight_slow("000"),Hackerrank.luckyNumberEight("000"))
        assertEquals(Hackerrank.luckyNumberEight_slow("0000"),Hackerrank.luckyNumberEight("0000"))
        assertEquals(Hackerrank.luckyNumberEight_slow("008"),Hackerrank.luckyNumberEight("008"))
        assertEquals(Hackerrank.luckyNumberEight_slow("0008"),Hackerrank.luckyNumberEight("0008"))
        assertEquals(Hackerrank.luckyNumberEight_slow("080"),Hackerrank.luckyNumberEight("080"))
        assertEquals(Hackerrank.luckyNumberEight_slow("811"),Hackerrank.luckyNumberEight("811"))
        assertEquals(Hackerrank.luckyNumberEight_slow("000000"),Hackerrank.luckyNumberEight("000000"))
        assertEquals(Hackerrank.luckyNumberEight_slow("555555"),Hackerrank.luckyNumberEight("555555"))
        assertEquals(Hackerrank.luckyNumberEight_slow("555558"),Hackerrank.luckyNumberEight("555558"))
        assertEquals(Hackerrank.luckyNumberEight_slow("123456"),Hackerrank.luckyNumberEight("123456"))
        assertEquals(Hackerrank.luckyNumberEight_slow("00000000000000000000000000000000"),
                Hackerrank.luckyNumberEight("00000000000000000000000000000000"))
    }

    void testLuckyNumberEight_random() {
        Random rand = new Random()

        for (int i = 0; i < 1000000; i++) {
            long n = rand.nextLong()
            n = n < 0 ? -n : n
            //System.out.println(n)
            assertEquals(Hackerrank.luckyNumberEight_slow(Long.toString(n)),
            Hackerrank.luckyNumberEight(Long.toString(n)))
        }
    }
}
