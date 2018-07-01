package datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MinPriorityQueueTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void pop() {
        Tuple<Integer, Integer>[] heap = new Tuple[]{
                Tuple.build(1, 0), Tuple.build(4, 0),
                Tuple.build(5, 0), Tuple.build(7, 0),
                Tuple.build(6, 0)

        };
        MinPriorityQueue pq = new MinPriorityQueue(heap);
        Tuple<Integer, Integer> min = pq.pop();
        assertEquals(1, (int)min.first);
        assertEquals(4, pq.size());
        int[] expected = new int[] {4, 6, 5, 7};
        int[] actual = getKeys(pq.getHeap(), expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void decreaseKey() {
        Tuple<Integer, Integer>[] heap = new Tuple[]{
                Tuple.build(1, 0), Tuple.build(4, 0),
                Tuple.build(5, 0), Tuple.build(7, 0),
                Tuple.build(6, 0)

        };
        MinPriorityQueue pq = new MinPriorityQueue(heap);
        pq.decreaseKey(4, Tuple.build(0, 0));
        int[] expected = new int[] {0, 1, 5, 7, 4};
        int[] actual = getKeys(pq.getHeap(), expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void push() {
        Tuple<Integer, Integer>[] heap = new Tuple[]{
                Tuple.build(0, 0), Tuple.build(4, 0),
                Tuple.build(5, 0), Tuple.build(7, 0),
                Tuple.build(6, 0)

        };
        MinPriorityQueue pq = new MinPriorityQueue(heap);
        pq.push(Tuple.build(1,0));
        int[] expected = new int[] {0, 4, 1, 7, 6, 5};
        int[] actual = getKeys(pq.getHeap(), expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void buildHeap() {
        Tuple<Integer, Integer>[] heap = new Tuple[]{
                Tuple.build(5, 0), Tuple.build(7, 0),
                Tuple.build(0, 0), Tuple.build(4, 0),
                Tuple.build(6, 0)

        };
        MinPriorityQueue.buildHeap(heap, heap.length);
        int[] expected = new int[]{0, 4, 5, 7, 6};
        int[] actual = getKeys(heap, expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], (int) actual[i]);
        }
    }

    @Test
    public void extractMin() {
        Tuple<Integer, Integer>[] heap = new Tuple[]{
                Tuple.build(0, 0), Tuple.build(4, 0),
                Tuple.build(5, 0), Tuple.build(7, 0),
                Tuple.build(6, 0)

        };

        Tuple<Integer, Integer> min = MinPriorityQueue.extractMin(heap, heap.length);
        assertEquals(0, (int) min.first);
        int[] expected = {4, 6, 5, 7};
        int[] actual = getKeys(heap, expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], (int) actual[i]);
        }
    }

    @Test
    public void pushDown_shouldNotDoAnything() {
        Tuple<Integer, Integer>[] heap = new Tuple[]{
                Tuple.build(0, 0), Tuple.build(4, 0),
                Tuple.build(5, 0), Tuple.build(7, 0),
                Tuple.build(6, 0)
        };

        int[] expected = {0, 4, 5, 7, 6};
        MinPriorityQueue.pushDown(heap, 0, heap.length);
        int[] actual = getKeys(heap, expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void pushDown() {
        Tuple<Integer, Integer>[] heap = new Tuple[]{
                Tuple.build(10, 0), Tuple.build(4, 0),
                Tuple.build(5, 0), Tuple.build(7, 0),
                Tuple.build(6, 0)
        };
        int[] expected = {4, 6, 5, 7, 10};
        MinPriorityQueue.pushDown(heap, 0, heap.length);
        int[] actual = getKeys(heap, expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], (int) actual[i]);
        }
    }

    @Test
    public void pushUp_shouldPushAllTheWayToTop() {
        Tuple<Integer, Integer>[] heap = new Tuple[]{
                Tuple.build(3, 0), Tuple.build(4, 0),
                Tuple.build(5, 0), Tuple.build(7, 0),
                Tuple.build(6, 0), Tuple.build(0, 0)
        };
        MinPriorityQueue.pushUp(heap, 5);
        int[] expected = {0, 4, 3, 7, 6, 5};
        int[] actual = getKeys(heap, expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], (int) actual[i]);
        }
    }

    @Test
    public void pushUp_alreadyInBalance_shouldDoNothing() {
        Tuple<Integer, Integer>[] heap = new Tuple[]{
                Tuple.build(3, 0), Tuple.build(4, 0),
                Tuple.build(5, 0), Tuple.build(7, 0),
                Tuple.build(6, 0)
        };
        MinPriorityQueue.pushUp(heap, 4);
        int[] expected = {3, 4, 5, 7, 6};
        int[] actual = getKeys(heap, expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void getParent() {
        Tuple<Integer, Integer>[] heap = new Tuple[]{
                Tuple.build(3, 0), Tuple.build(4, 0),
                Tuple.build(5, 0), Tuple.build(7, 0),
                Tuple.build(6, 0)
        };
        Tuple<Integer, Integer> parent = MinPriorityQueue.getParent(heap, 4);
        assertEquals(4, (int) parent.first);
        parent = MinPriorityQueue.getParent(heap, 1);
        assertEquals(3, (int) parent.first);
        parent = MinPriorityQueue.getParent(heap, 0);
        assertNull(parent);
    }

    @Test
    public void getLeft() {
        Tuple<Integer, Integer>[] heap = new Tuple[]{
                Tuple.build(3, 0), Tuple.build(4, 0),
                Tuple.build(5, 0), Tuple.build(7, 0),
                Tuple.build(6, 0)
        };

        Tuple<Integer, Integer> left = MinPriorityQueue.getLeft(heap, 0, heap.length);
        assertEquals(4, (int) left.first);
        left = MinPriorityQueue.getLeft(heap, 3, heap.length);
        assertNull(left);
    }

    @Test
    public void getRight() {
        Tuple<Integer, Integer>[] heap = new Tuple[]{
                Tuple.build(3, 0), Tuple.build(4, 0),
                Tuple.build(5, 0), Tuple.build(7, 0),
                Tuple.build(6, 0)
        };

        Tuple<Integer, Integer> right = MinPriorityQueue.getRight(heap, 1, heap.length);
        assertEquals(6, (int) right.first);
        right = MinPriorityQueue.getRight(heap, 3, heap.length);
        assertNull(right);
    }

    private int[] getKeys(Tuple<Integer, Integer>[] arr, int size) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = arr[i].first;
        }
        return res;
    }
}