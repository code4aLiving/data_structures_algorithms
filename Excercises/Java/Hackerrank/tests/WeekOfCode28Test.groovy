/**
 * Created by sergio on 11/01/17.
 */
class WeekOfCode28Test extends GroovyTestCase {
    void testLuckyNumberEight() {

        //assertEquals(WeekOfCode28.luckyNumberEight_Slow("8888"),WeekOfCode28.luckyNumberEight("8888"))
        //assertEquals(WeekOfCode28.luckyNumberEight_Slow("0000"),WeekOfCode28.luckyNumberEight("0000"))
        //assertEquals(WeekOfCode28.luckyNumberEight_Slow("968"),WeekOfCode28.luckyNumberEight("968"))
        //assertEquals(WeekOfCode28.luckyNumberEight_Slow("0808"),WeekOfCode28.luckyNumberEight("0808"))

        WeekOfCode28.RangeModularQuery q1 = new WeekOfCode28.RangeModularQuery(0,1,12,1)
        WeekOfCode28.RangeModularQuery q2 = new WeekOfCode28.RangeModularQuery(0,1,12,1)
        assertTrue(q1 == q2)

    }
}
