package datastructures;

public class MinPriorityQueue {

    private int size;
    private Tuple<Integer, Integer>[] heap;

    public MinPriorityQueue(Tuple<Integer, Integer>[] array) {
        heap = new Tuple[array.length];
        for (int i = 0; i < array.length; i++) {
            heap[i] = array[i];
        }
        size = heap.length;
        buildHeap(heap, heap.length);
    }

    public Tuple<Integer, Integer> pop() {
        Tuple min = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        pushDown(heap, 0, size);
        return min;
    }

    public void decreaseKey(int index, Tuple<Integer, Integer> newValue) {
        heap[index] = newValue;
        pushUp(heap, index);
    }

    public void push(Tuple<Integer, Integer> item) {
        if (size == heap.length) {
            // Double the size of the array
            Tuple<Integer, Integer>[] newHeap = new Tuple[size * 2];
            for (int i = 0; i < size; i++) {
                newHeap[i] = heap[i];
            }
            heap = newHeap;
        }
        heap[size] = item;
        size++;
        pushUp(heap, size - 1);
    }

    public Tuple<Integer, Integer>[] getHeap(){
        return heap;
    }

    public int size() {
        return size;
    }

    public static void buildHeap(int[] arr, int heapSize) {
        Tuple<Integer, Integer> [] tuples = new Tuple[heapSize];
        for (int i = 0; i < heapSize; i++) {
            tuples[i] = Tuple.build(arr[i], 0);
        }
        buildHeap(tuples, heapSize);
    }

    public static void buildHeap(Tuple[] arr, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            pushDown(arr, i, heapSize);
        }
    }

    public static Tuple<Integer, Integer> extractMin(Tuple<Integer, Integer>[] heap, int heapSize) {
        Tuple min = heap[0];
        heap[0] = heap[heapSize - 1];
        pushDown(heap, 0, heapSize - 1);
        return min;
    }

    public static void pushDown(Tuple<Integer, Integer>[] heap, int index, int heapSize) {

        Tuple<Integer, Integer> current;
        Tuple<Integer, Integer> left;
        Tuple<Integer, Integer> right;

        while (index * 2 + 1 < heapSize) {
            // Not in the last level of the heap
            current = heap[index];
            left = getLeft(heap, index, heapSize);
            right = getRight(heap, index, heapSize);

            if (right == null || right.first > left.first) {
                // The left child is either the only child or the smallest
                if (current.first < left.first)
                    break;
                // Swap
                heap[index] = left;
                heap[index * 2 + 1] = current;
                index = index * 2 + 1;
            } else {
                // The right child is the smallest
                if (current.first < right.first)
                    break;

                //Swap
                heap[index] = right;
                heap[index * 2 + 2] = current;
                index = index * 2 + 2;
            }
        }
    }

    public static void pushUp(Tuple<Integer, Integer>[] heap, int index) {
        while (index > 0) {
            int parentIndex = index % 2 == 1 ? index / 2 : (index - 1) / 2;
            Tuple<Integer, Integer> current = heap[index];
            Tuple<Integer, Integer> parent = getParent(heap, index);
            if (parent.first < current.first)
                break;
            heap[parentIndex] = current;
            heap[index] = parent;
            index = parentIndex;
        }
    }

    public static Tuple getParent(Tuple[] heap, int index) {
        if (index == 0) return null;
        if (index % 2 == 1) {
            // is left child
            return heap[index / 2];
        }
        return heap[(index - 1) / 2];
    }

    public static Tuple<Integer, Integer> getLeft(Tuple[] heap, int index, int heapSize) {
        if (index * 2 + 1 >= heapSize)
            return null;
        return heap[2 * index + 1];
    }

    public static Tuple<Integer, Integer> getRight(Tuple<Integer, Integer>[] heap, int index, int heapSize) {
        if (index * 2 + 2 >= heapSize)
            return null;
        return heap[2 * index + 2];
    }
}
