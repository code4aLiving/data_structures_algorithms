import java.io.IOException;
import java.util.*;

public class ATimeSavingAffair {

    // Complete the leastTimeToInterview function below.
    static long leastTimeToInterview(int n, int k, int m) {
        // Return the least amount of time needed to reach the interview location in seconds.
        Map<Integer, Set<Tuple<Integer, Long>>> graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            long t = scanner.nextLong();
            if (!graph.containsKey(u)) graph.put(u, new HashSet<>());
            if (!graph.containsKey(v)) graph.put(v, new HashSet<>());
            graph.get(u).add(Tuple.build(v, t));
            graph.get(v).add(Tuple.build(u, t));
        }
        long[] x = dijkstra(n * 2, 1, graph, k);
        return x[n];
    }

    static long[] dijkstra(final int n, final int s, final Map<Integer, Set<Tuple<Integer, Long>>> graph, int k) {
        final long[] distance = new long[n + 1];
        final boolean[] visited = new boolean[n + 1];

        for (int i = 1; i < distance.length; i++) {
            distance[i] = Long.MAX_VALUE;
        }
        distance[s] = 0l;

        // Priority queue of tuples <Distance to origin, Vertex>
        PriorityQueue<Tuple<Long, Integer>> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(Tuple.build(0l, s));

        while (priorityQueue.size() > 0) {
            Tuple<Long, Integer> du = priorityQueue.poll();
            int u = du.second;
            if (visited[u]) continue;

            //Once a vertex has been extracted from the queue it reached its optimum
            visited[u] = true;

            for (Tuple<Integer, Long> uv : graph.get(u)) {
                int v = uv.first;
                long weightuv = uv.second;
                // In the graph each tuple is an edge <vertex, weight>
                if (relax(u, v, weightuv, distance, k)) {
                    //We could relax U ~> V
                    // Add v back to the priority queue with the new updated distance.
                    // It would be better to do decrease key but that's not available in java's priority queue
                    priorityQueue.add(Tuple.build(distance[v], v));
                }
            }
        }

        return distance;
    }

    static boolean relax(int u, int v, long weightuv, long[] distance, int k) {
        long timePenalty = 0;
        long x = distance[u] / k;
        if (x % 2 > 0) {
            //The light is red
            timePenalty = (x + 1) * k - distance[u];
        }
        if (distance[v] > distance[u] + weightuv + timePenalty) {
            distance[v] = distance[u] + weightuv + timePenalty;
            return true;
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = leastTimeToInterview(n, k, m);

        System.out.println(result);

        scanner.close();
    }
}

class Tuple<E extends Comparable<E>, F extends Comparable<F>> implements Comparable<Tuple<E, F>> {
    final public E first;
    final public F second;

    public Tuple(E first, F second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public F getSecond() {
        return second;
    }

    public static <E extends Comparable<E>, F extends Comparable<F>> Tuple<E, F> build(E first, F second) {
        return new Tuple<>(first, second);
    }

    @Override
    public boolean equals(Object o) {
        Tuple other = (Tuple) o;
        return first == other.first && second == other.second;
    }

    @Override
    public int hashCode() {
        return first.hashCode() & second.hashCode();
    }

    @Override
    public int compareTo(Tuple<E, F> o) {
        int compareFirst = first.compareTo(o.first);
        return compareFirst == 0 ? second.compareTo(o.second) : compareFirst;
    }
}
