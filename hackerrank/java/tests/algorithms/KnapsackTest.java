package algorithms;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class KnapsackTest {

    int[] weights = {0, 5, 9, 3, 2, 2};
    int[] profits = {0, 5, 9, 3, 2, 2};
    int capacity = 10;

    @Test
    public void knapsackTest_Dynamic() {
        int[][] table = Knapsack.knapsack(capacity, profits, weights, weights.length - 1);
        int expected = 10;
        assertEquals(expected, table[weights.length - 1][capacity]);
    }

    @Test
    public void knapsackTest_Dynamic2() {
        int[][] table = new int[weights.length][capacity + 1];
        int actual = Knapsack.knapsack(capacity, profits, weights, weights.length - 1, table);
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    public void knapsackRecursive() {
        int actual = Knapsack.knapsackRecursive(10, profits, weights, weights.length - 1);
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    public void knapsackObjects() {
        List<Integer> items = Knapsack.knapsackObjects(capacity, profits, weights);
        int[] expectedItems = {4, 3, 1};
        for (int i = 0; i <items.size(); i++) {
            assertEquals(expectedItems[i], items.get(i), 0.0);
        }
    }
}