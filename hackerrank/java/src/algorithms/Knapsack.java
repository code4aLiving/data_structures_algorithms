package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    /*
    Problem Description. Given a list of objects, each of them with a weight and a profit, and a knapsack with capacity C.
    1- Determine the maximum profit that can be obtained by putting objects in the knapsack without going over the capacity.
    2- Print the list of objects that maximize profit. Multiple solutions are possible, provide one of them.
    */

    public static int[][] knapsack(int capacity, int[] profits, int[] weights, int itemsCount) {
        int[][] table = new int[itemsCount + 1][capacity + 1];
        knapsack(capacity, profits, weights, itemsCount, table);
        return table;
    }

    public static int knapsack(int capacity, int[] profits, int[] weights, int itemsCount, int[][] table) {
        for (int c = 1; c <= capacity; c++) { // row
            for (int item = 1; item <= itemsCount; item++) { // col
                if (weights[item] > c) table[item][c] = table[item - 1][c];
                else table[item][c] = Math.max(table[item - 1][c], table[item - 1][c - weights[item]] + profits[item]);
            }
        }
        return table[itemsCount][capacity];
    }

    public static int knapsackRecursive(int capacity, int[] profits, int[] weights, int itemsCount) {
        if (itemsCount == 0) return 0;
        if (capacity < 0) return Integer.MIN_VALUE;
        if (itemsCount == 1) return weights[itemsCount] <= capacity ? profits[itemsCount] : Integer.MIN_VALUE;

        return Math.max(knapsackRecursive(capacity - weights[itemsCount], profits, weights, itemsCount - 1) + profits[itemsCount],
                knapsackRecursive(capacity, profits, weights, itemsCount - 1));
    }

    public static List<Integer> knapsackObjects(int capacity, int[] profits, int[] weights) {
        int[][] table = knapsack(capacity, profits, weights, weights.length - 1);
        List<Integer> items = new ArrayList<>();
        int item = weights.length - 1;
        while (item > 0 && capacity > 0) {
            if (table[item][capacity] != table[item - 1][capacity]) {
                //This item was taken
                items.add(item);
                capacity -= weights[item];
            }
            item--;
        }
        return items;
    }
}
